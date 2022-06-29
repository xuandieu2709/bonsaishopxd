/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import bean.Customer;
import bean.Order;
import bean.Product;
import dao.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TG
 */
@WebServlet(name = "checkoutControl", urlPatterns = {"/checkoutControl"})
public class checkoutControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        Cookie arr[] = request.getCookies();
        String txt = "";
        for (Cookie o : arr) {
            if (o.getName().equals("id")) {
                txt = txt + o.getValue();
                o.setMaxAge(0);
                response.addCookie(o);
            }
        }
        if (txt.isEmpty()) {
            txt = id;
        } else {
            txt = txt + "%x2C" + id;
        }
        Cookie c = new Cookie("id", txt);
        c.setMaxAge(60 * 60 * 24);
        response.addCookie(c); */
        //response.sendRedirect("showProductCheckout");
        request.setAttribute("ok", "2");
        request.setAttribute("checkout", "link"); // hiệu ứng trang
        request.getRequestDispatcher("checkout.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        DAO dao = new DAO();
        //
        Cookie arr[] = request.getCookies();
        List<Product> list = new ArrayList<>();
        for (Cookie o : arr) {
            if (o.getName().equals("id")) {
                String txt[] = o.getValue().split("%x2C");
                for (String s : txt) {
                    list.add(dao.getProductsByIDProduct(s));
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            int count = 1;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getIdProducts() == null ? list.get(j).getIdProducts() == null : list.get(i).getIdProducts().equals(list.get(j).getIdProducts())) {
                    count++;
                    list.remove(j);
                    j--;
                    list.get(i).setAmount(count);
                }
            }
        }
        int count1 = 0;// đếm tổng số lượng gói hàng
        double total = 0;
        for (Product o : list) {
            total = total + o.getAmount() * o.getExPrice();
            count1 += o.getAmount();
        }
        // Lay thong tin thanh toan va day len database
        String first = request.getParameter("first_name");
        String last = request.getParameter("last_name");
        String phone = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String city = request.getParameter("city");
        String ward = request.getParameter("ward");
        String district = request.getParameter("district");
        String street = request.getParameter("street_address");
        
        if(dao.checkExistCustommer(phone, email)== false){
        dao.insertCustomer(first + " " + last, phone, street + " - " + ward + " - " + district + " - " + city, email);
        }
        Customer cus = dao.getCustommerByInforCus(phone, email);
        dao.insertNewOrder(first + " " + last, street + " - " + ward + " - " + district + " - " + city, phone, email,count1,(long) (total*0.1), (long) (total*1.1));
        Order or = dao.getLastIDOrder();
        for (Product o : list) {
            dao.insertDetailOrder(or.getIdOrder(), Integer.parseInt(cus.getIdcus()), Integer.parseInt(o.getIdProducts()), o.getAmount());
        }
        // Xoa cookies
        for (Cookie o : arr) {
            o.setMaxAge(0);
            response.addCookie(o);
        }
        //
        Cookie cook = new  Cookie("idCus", cus.getIdcus());
        cook.setMaxAge(60 * 60 * 24); // set time của c là 1 ngày
        response.addCookie(cook);
        /*
        Order or1 = dao.getAllOrderByIDOrder(String.valueOf(or.getIdOrder()));
        List<Product> listP = dao.getAllProductByIDOrder(String.valueOf(or.getIdOrder()));
        int count = 1; */
        int order = 1; // show trang
        HttpSession session = request.getSession();
        session.setAttribute("order", order);
        session.setMaxInactiveInterval(60 * 60 * 24);
        request.setAttribute("order1", "link"); // hieu ung trang
        //request.setAttribute("count", count);
        //request.setAttribute("or1", or1);
        //request.setAttribute("listP", listP);
        //request.getRequestDispatcher("detailorder.jsp").forward(request, response);
        response.sendRedirect("showOrder");

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
