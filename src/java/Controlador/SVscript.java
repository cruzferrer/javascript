/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author cruzr
 */
@WebServlet(name = "SVscript", urlPatterns = {"/SVscript"})
public class SVscript extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SVscript</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SVscript at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
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
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Obtener el capital ingresado por el usuario
    String capitalStr = request.getParameter("capital");

    // Validar que el valor ingresado es un número positivo
    if (!capitalStr.matches("^\\d+(\\.\\d+)?$")) {
        // Si no es un número válido, guardar un mensaje de error y redirigir al JSP
        request.setAttribute("error", "Por favor ingrese un número positivo válido.");
        RequestDispatcher dispatcher = request.getRequestDispatcher("ejer1.jsp");
        dispatcher.forward(request, response);
        return;
    }

    // Convertir el valor a un número
    double capital = Double.parseDouble(capitalStr);

    // Validar que el valor ingresado es positivo
    
    

    // Calcular el interés ganado después de un mes a una tasa del 2%
    double interes = capital * 0.02;

    // Guardar el resultado en el objeto request para mostrarlo en el JSP
    request.setAttribute("interes", interes);

    // Redirigir al archivo JSP para mostrar el resultado
    RequestDispatcher dispatcher = request.getRequestDispatcher("ejer1.jsp");
    dispatcher.forward(request, response);
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
