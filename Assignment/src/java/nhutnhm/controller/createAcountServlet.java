/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhutnhm.controller;

import LoginTable.LoginTableCreateError;
import LoginTable.LoginTableDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SE130162
 */
@WebServlet(name = "createAcountServlet", urlPatterns = {"/createAcountServlet"})
public class createAcountServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String ERROR_PAGE = "createNewAccount.jsp";
    private final String LOGIN_PAGE = "login.html";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String confirm = request.getParameter("txtConfirm");
        String lastname = request.getParameter("txtLastName");
        String url = ERROR_PAGE;

        LoginTableCreateError er = new LoginTableCreateError();
        try {
            boolean FoundErr = false;
            if (username.trim().length() < 6 || username.trim().length() > 20) {
                FoundErr = true;
                er.setUsernameLengthError("Username must * (6 - 20 characters)");
            }
            if (password.trim().length() < 6 || password.trim().length() > 20) {
                FoundErr = true;
                er.setPasswordLengthError("Password must * (6 - 20 characters)");
            } else if (!confirm.trim().equals(password.trim())) {
                FoundErr = true;
                er.setConfirmIsNotMatched("Confirm password is not match");
            }
            if (lastname.trim().length() < 2 || lastname.trim().length() > 50) {
                FoundErr = true;
                er.setLastNameLengthError("Last name must *(2-50 characters)");
            }
            if (FoundErr) {
                request.setAttribute("CREATEERROR", er);
            } else {
                LoginTableDAO dao = new LoginTableDAO();
                boolean result = dao.addRecord(username, password, lastname);
                if (result) {
                    url = LOGIN_PAGE;

                }
            }
        } catch (NamingException e) {
            log(e.getMessage() + "NamingException createNewAccountServlet");
        } catch (SQLException e) {
            if (e.getMessage().contains("duplicate")) {
                er.setUsernameIsExisted(username + " is existed");
                request.setAttribute("CREATEERROR", er);
            } else {
                log(e.getMessage() + "SQLException createNewAccountServlet");
            }
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
