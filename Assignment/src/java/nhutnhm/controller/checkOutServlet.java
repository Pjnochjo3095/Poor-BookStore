/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhutnhm.controller;

import Cart.CartObj;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Map;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ordered.OrderedDAO;
import ordered.OrderedDTO;
import ordereddetails.OrderedDetailsDAO;

/**
 *
 * @author SE130162
 */
@WebServlet(name = "checkOutServlet", urlPatterns = {"/checkOutServlet"})
public class checkOutServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String SHOPPING_PAGE = "loadBooktoShop";
    private final String ERROR_PAGE = "viewCart.jsp";
    private final String LOGIN_PAGE = "login.html";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = ERROR_PAGE;

        try {
            HttpSession session = request.getSession(false);
            CartObj cart = (CartObj) session.getAttribute("CART");
            String username = (String) session.getAttribute("USERNAME");
            if (username != null) {
                if (cart != null) {
                    Map<String, Integer> items = cart.getItems();
                    OrderedDetailsDAO dao = new OrderedDetailsDAO();
                    OrderedDAO orderDAO = new OrderedDAO();
                    //Sum total;
                    int total = 0;
                    for(String item :items.keySet()){
                      total += items.get(item);
                    }
                    Date dateCheckout = new Date(System.currentTimeMillis());
                    OrderedDTO orderDTO = new OrderedDTO(username, total, dateCheckout);
                    boolean result = dao.addOrderedDetalil(items);
                    boolean result2 = orderDAO.addOrdered(orderDTO);
                    if (result && result2) {
                        session.removeAttribute("CART");
                        url = SHOPPING_PAGE;
                    }
                }
            }else{
             url = LOGIN_PAGE;
            }
        } catch (NamingException e) {
            log(e.getMessage() + " NamingException checkOutServlet");
        } catch (SQLException e) {
            log(e.getMessage() + " SQLException checkOutServlet");
        } finally {
            response.sendRedirect(url);
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
