/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

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

/**
 *
 * @author TG
 */
@WebServlet(name = "cartControl", urlPatterns = {"/cartControl"})
public class cartControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // Tính toán giá sản phẩm trong giỏ hàng
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id"); // truyenf id ben jsp sang servlet
        Cookie arr[] = request.getCookies(); // tạo mang arr lay tat ca cac gia tri trong cookies
        String txt = ""; // tao chuoi txt bang ""
        for (Cookie o : arr) {           
            if (o.getName().equals("id")) { // neu ton tsi cookies cos ten la 'id'
                txt = txt + o.getValue(); // gan txt = gia tri của cookies hien tai
                o.setMaxAge(0);   // dat thoi gian ton tai cookies o là 0(tuc la gan gia tri cookies cho txt thi xoa o ra khoi cookies)
                response.addCookie(o); // thêm 1 cookies o moi vao cookies
            }
        }
        int count = 0;
        if (txt.isEmpty()) { // neu txt rong 
            txt = id; // txt = gtr id VD: id = 1 thi txt = 1
        } else {                      // nguoc lai khac null (VD: 1)
            txt = txt + "%x2C" + id;    // gan txt = 1+%x2C+ => 1%x2C1 
            /*if(id.equals(txt.split("%x2C"))){
                count++;
                if(count==100){
                    response.sendRedirect("showCart");
                }
            } */
        } 
        Cookie c = new Cookie("id", txt); // tao moi 1 cookies id voi ten la id và gia trị là theo(2 trường hợp trên) bên trên
        c.setMaxAge(60 * 60 * 24); // set time của c là 1 ngày
        response.addCookie(c);  // thêm c vào cookies
        response.sendRedirect("showCart"); //
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
        processRequest(request, response);
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
