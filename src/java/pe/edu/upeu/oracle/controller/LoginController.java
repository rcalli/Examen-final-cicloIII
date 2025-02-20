
package pe.edu.upeu.oracle.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.edu.upeu.oracle.dao.UsuarioDao;
import pe.edu.upeu.oracle.daoImpl.UsuarioDaoImpl;
import pe.edu.upeu.oracle.dto.UsuariLogin;

/**
 *
 * @author Docente
 */
public class LoginController extends HttpServlet {
private UsuarioDao udao = new UsuarioDaoImpl();
private static final int INTENTOSMAXIMOS = 3;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String clave = request.getParameter("clave");
        HttpSession sesion = request.getSession();


        Integer failedAttempts = (Integer) sesion.getAttribute("failedAttempts");
        if (failedAttempts == null) {
            failedAttempts = 0;
        }

        List<UsuariLogin> lista = udao.login(username, clave);
        if (!lista.isEmpty()) { 
            sesion.setAttribute("username", lista.get(0).getUsername());
            sesion.setAttribute("rol", lista.get(0).getRol());


            sesion.setAttribute("failedAttempts", 0);

            response.sendRedirect("home.jsp");
        } else {
            failedAttempts++;
            sesion.setAttribute("failedAttempts", failedAttempts);

            if (failedAttempts >= INTENTOSMAXIMOS) {
                sesion.invalidate();  
                response.sendRedirect("sesionexpirada.jsp");  
            } else {
                response.sendRedirect("index.jsp");
            }
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
