/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import bean.Product;
import dao.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.dbcp.dbcp2.SQLExceptionList;

/**
 *
 * @author TG
 */
@WebServlet(name = "showCart", urlPatterns = {"/showCart"})
public class showCart extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        Cookie arr[] = request.getCookies(); // lấy tất cả các giá trị trong cookies đổ vào mảng arr
        PrintWriter out = response.getWriter(); // 
        List<Product> list = new ArrayList<>();  //
        int countPro = 0;
        try {
            DAO dao = new DAO();
            for (Cookie o : arr) {   // gan o cho tung gia trị trong cookies
                if (o.getName().equals("id")) { // nếu tên cookies bằng id
                    String txt[] = o.getValue().split("%x2C");// thì mảng txt = giá trị của từng cookies o bỏ 
                    //qua bởi ký tự '%x2C'. VD: 1%x2C1%x2C1
                    // txt = {1,1,1}
                    for (String s : txt) { // s sẽ được gán cho từng phần tử trong mảng txt
                        list.add(dao.getProductsByIDProduct(s)); // list sẽ có thêm 3 product(có id la 1)
                    }
                }
            }
            for (int i = 0; i < list.size(); i++) { // duyet mang tu 0 den het list
                int count = 1;
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(i).getIdProducts() == null ? list.get(j).getIdProducts() == null : list.get(i).getIdProducts().equals(list.get(j).getIdProducts())) {
                        count++;
                        list.remove(j);
                        j--; //
                        list.get(i).setAmount(count);
                        /*if (list.get(i).getAmount() < 100 || (list.get(i).getAmount() < list.get(i).getInventory())) {
                            
                        } else {
                            break;
                        } */
                    }
                }
            }
            double total = 0;
            for (Product o : list) {
                total = total + o.getAmount() * o.getExPrice();
            }
            NumberFormat fm = NumberFormat.getNumberInstance();
            fm.setMinimumIntegerDigits(0);
            request.setAttribute("list", list);
            request.setAttribute("total", fm.format((long) total));
            request.setAttribute("vat", fm.format((long) (0.1 * total)));
            request.setAttribute("sum", fm.format((long) (1.1 * total)));
        } catch (Exception ex) {
            // cookies null
        }
        request.setAttribute("cart", "link"); // hiệu ứng trang
        request.getRequestDispatcher("cart.jsp").forward(request, response);
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
        processRequest(request, response);
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
