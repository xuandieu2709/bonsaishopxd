/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import bean.Account;
import bean.Catagory;
import bean.Product;
import dao.DAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author TG
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)
@WebServlet(name = "addProduct", urlPatterns = {"/addProduct"})
public class addProduct extends HttpServlet {

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
            throws ServletException, IOException {/*
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("idProducts");
        String name = request.getParameter("nameProducts");
        String image = request.getParameter("image");
        String des = request.getParameter("description");
        String unit = request.getParameter("unit");
        String inven = request.getParameter("inventory");
        String im = request.getParameter("imPrice");
        String ex = request.getParameter("exPrice");
        String note = request.getParameter("note");
        String cid = request.getParameter("idIndustry");
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("a");
        DAO dao = new DAO();
        dao.insertProducts(id, name, image, des, unit, Integer.parseInt(inven), Long.parseLong(im), Long.parseLong(ex), note, cid);
        response.sendRedirect("p_managerControl"); */

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
        request.setCharacterEncoding("UTF-8");
        DAO dao = new DAO();
        List<Catagory> listC =  dao.getAllCatagory();
        request.setAttribute("listC", listC);
        request.getRequestDispatcher("manager/p_manager.jsp").forward(request, response);
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
        String id = request.getParameter("idProducts");
        String name = request.getParameter("nameProducts");
        String des = request.getParameter("description");
        String unit = request.getParameter("unit");
        String inven = request.getParameter("inventory");
        String im = request.getParameter("imPrice");
        String ex = request.getParameter("exPrice");
        String note = request.getParameter("note");
        String cid = request.getParameter("idIndustry");
        String image1 = "img\\core-img\\logoweb.jpg";
        DAO dao = new DAO();
        if (dao.checkProductExist(id) != true) {
            try {
                Part part = request.getPart("image");
                String fileName = extractFileName(part);
                fileName = new File(fileName).getName();
                String path1 = request.getContextPath();
                System.out.println(path1);
                part.write("C:/Java/BonsaiShopXD/web/img/product/" + fileName);
                String image = "img/product/" + fileName;
                dao.insertProducts(name, image, des, unit, Integer.parseInt(inven), Long.parseLong(im), Long.parseLong(ex), note, cid);
                request.setAttribute("mess", "Thêm sản phẩm thành công!");
                //response.sendRedirect("p_managerControl");
                request.getRequestDispatcher("p_managerControl").forward(request, response);
            } catch (IOException e) {
                dao.insertProducts(name, image1, des, unit, Integer.parseInt(inven), Long.parseLong(im), Long.parseLong(ex), note, cid);
                request.setAttribute("mess", "Thêm sản phẩm thành công!");
                request.getRequestDispatcher("p_managerControl").forward(request, response);
            } catch (NumberFormatException | ServletException e) {
                //response.sendRedirect("p_managerControl");
                request.setAttribute("mess", "Thêm sản phẩm thất bại<br>Vui lòng nhập giá trị số ở mục tương ứng!");
                request.getRequestDispatcher("p_managerControl").forward(request, response);
            }
        } else {
            request.setAttribute("mess", "Mã sản phẩm đã tồn tại");
            response.sendRedirect("p_managerControl");
        }
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
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
