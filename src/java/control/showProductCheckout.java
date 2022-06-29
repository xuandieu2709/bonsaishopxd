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

/**
 *
 * @author TG
 */
@WebServlet(name = "showProductCheckout", urlPatterns = {"/showProductCheckout"})
public class showProductCheckout extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        int count1 = 0;
        int countSum = 0;
        try {
            Cookie arr[] = request.getCookies();
            PrintWriter out = response.getWriter();
            List<Product> list = new ArrayList<>();
            DAO dao = new DAO();
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
            double total = 0;
            for (Product o : list) {
                total = total + o.getAmount() * o.getExPrice();
                count1++;
                countSum += o.getAmount();
            }
            //
            NumberFormat fm = NumberFormat.getNumberInstance();
            fm.setMinimumIntegerDigits(0); //
            request.setAttribute("list", list);
            request.setAttribute("total", fm.format((long) total));
            request.setAttribute("vat", fm.format((long) (0.1 * total)));
            request.setAttribute("sum", fm.format((long) (1.1 * total)));

        } catch (Exception e) {
        }
        request.setAttribute("checkout", "link");// hiệu ứng trang
        request.setAttribute("count1", count1);// dem so san pham
        request.setAttribute("countSum", countSum);// dem so san pham
        request.getRequestDispatcher("checkout.jsp").forward(request, response);

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
