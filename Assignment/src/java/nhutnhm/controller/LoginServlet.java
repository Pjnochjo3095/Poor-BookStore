/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhutnhm.controller;

import Cart.CartObj;
import LoginTable.LoginTableDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SE130162
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String SEARCH_PAGE = "searchPage";
    private final String ERROR_PAGE = "invalid.html";
    private final String VIEW_CART_PAGE = "viewCart.jsp";
    private final String SHOPPING_PAGE = "loadBooktoShop";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        boolean check = false;
        HttpSession session = request.getSession(true);
        String url = ERROR_PAGE;
        ServletContext sc = request.getServletContext();
        Map<String, String> map = (Map<String, String>) sc.getAttribute("MAPPING");
        try {
            /* TODO output your page here. You may use following sample code. */
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            LoginTableDAO dao = new LoginTableDAO();
            boolean result = dao.checkLogin(username, password);
            boolean isAdmin = dao.getIsAdmin(username);
            CartObj cart = (CartObj) session.getAttribute("CART");
            if (result) {
                session.setAttribute("USERNAME", username);
                session.setAttribute("ROLE", isAdmin);
//                url = SEARCH_PAGE;
                url = map.get(SEARCH_PAGE);
//                if (cart != null && !isAdmin) {
//                    url = VIEW_CART_PAGE;
//                } else if (cart == null && !isAdmin) {
//                    url = SEARCH_PAGE;
//                    if (map.containsKey(url)) {
//                        url = map.get(url);
//                        System.out.println(url);
//                    }
//                }
            }
        } catch (NamingException e) {
            log("LoginServlet NamingException " + e.getMessage());
        } catch (SQLException e) {
            log("LoginServlet SQLException " + e.getMessage());
        } finally {
//            if (check == true) {
//                response.sendRedirect(url);
//            } else {
//                response.sendRedirect(url);
//                if (url.equals("searchPage")) {
//                    
//                }else{
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
//                }
            out.close();
        }

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
