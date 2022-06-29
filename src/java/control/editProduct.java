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

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)
@WebServlet(name = "editProduct", urlPatterns = {"/editProduct"})
public class editProduct extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        DAO dao = new DAO();
        String pid = request.getParameter("pid");
        List<Catagory> listC = dao.getAllCatagory();
        Product p = dao.getProductsByIDProduct(pid);
        Catagory c = new Catagory();
        c = dao.getCatalogByIdProduct(pid);
        request.setAttribute("listC", listC);
        request.setAttribute("c", c);
        request.setAttribute("p", p);
        request.getRequestDispatcher("manager/editP.jsp").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        DAO dao = new DAO();
        String pid = request.getParameter("idProducts");
        Product p = dao.getProductsByIDProduct(pid);
        String name = request.getParameter("nameProducts");
        String des = request.getParameter("description");
        String unit = request.getParameter("unit");
        String inven = request.getParameter("inventory");
        String im = request.getParameter("imPrice");
        String ex = request.getParameter("exPrice");
        String note = request.getParameter("note");
        String cid = request.getParameter("idIndustry");
        /*
        if (DAO.isNumeric(inven) == false || DAO.isNumeric(im) == false || DAO.isNumeric(ex) == false) {
            request.setAttribute("idProducts",pid);
            request.setAttribute("nameProducts",name);
            request.setAttribute("description",des);
            request.setAttribute("unit",unit);
            request.setAttribute("inventory",inven);
            request.setAttribute("imPrice",im);
            request.setAttribute("exPrice",ex);
            request.setAttribute("note",note);
            request.setAttribute("idIndustry",cid);
            request.setAttribute("mess", "Vui lòng nhập giá trị số ở mục:\nHàng tồn : Giá nhập : Giá xuất");
            request.getRequestDispatcher("editProduct").forward(request, response);
        }*/
        try {
            Part part = request.getPart("image");
            String fileName = extractFileName(part);
            fileName = new File(fileName).getName();
            String path1 = request.getContextPath();
            System.out.println(path1);
            part.write("C:/Java/BonsaiShopXD/web/img/product/" + fileName);
            String image = "img/product/" + fileName;
            dao.updateProducts(name, image, des, unit, Integer.parseInt(inven), Long.parseLong(im), Long.parseLong(ex), note, cid, pid);
            request.setAttribute("mess", "Sửa sản phẩm thành công!");
            //response.sendRedirect("p_managerControl");
            request.getRequestDispatcher("p_managerControl").forward(request, response);
        } catch (IOException e) {
            dao.updateProducts(name, p.getImage(), des, unit, Integer.parseInt(inven), Long.parseLong(im), Long.parseLong(ex), note, cid, pid);
            request.setAttribute("mess", "Sửa sản phẩm thành công!");
            request.getRequestDispatcher("p_managerControl").forward(request, response);
        } catch (NumberFormatException | ServletException e) {
            request.setAttribute("mess", "Sửa sản phẩm thất bại!");
            //response.sendRedirect("p_managerControl");
            request.getRequestDispatcher("p_managerControl").forward(request, response);
        }
        /*
        if (dao.checkProductExist(pid) != true) {
            dao.updateProducts(name, image, des, unit, Integer.parseInt(inven), Long.parseLong(im), Long.parseLong(ex), note, cid,pid);
            request.setAttribute("mess", "Sửa sản phẩm thành công!");
            response.sendRedirect("p_managerControl");
        } else {
            request.setAttribute("mess", "Sửa sản phẩm thất bại!");
            response.sendRedirect("p_managerControl");
        }
         */
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
