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
@WebServlet(name = "ejer22", urlPatterns = {"/ejer22"})
public class ejer22 extends HttpServlet {

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
            out.println("<title>Servlet ejer22</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ejer22 at " + request.getContextPath() + "</h1>");
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
        
        // Obtener el total de la compra ingresado por el usuario
        String strTotal = request.getParameter("total");
        
        // Validar que el campo no esté vacío y que sea un número positivo
        String errorMessage = null;
        Double total = null;
        if (strTotal == null || strTotal.isEmpty()) {
            errorMessage = "Debe ingresar un valor para el total de la compra.";
        } else {
            try {
                total = Double.parseDouble(strTotal);
                if (total < 0) {
                    errorMessage = "El total de la compra debe ser un número positivo.";
                }
            } catch (NumberFormatException e) {
                errorMessage = "El total de la compra debe ser un número válido.";
            }
        }
        
        // Si hay un error, redirigir de vuelta al formulario con el mensaje de error
        if (errorMessage != null) {
            request.setAttribute("error", errorMessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("ejer3.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        // Calcular el descuento y el total a pagar
        Double descuento = total * 0.15;
        Double totalAPagar = total - descuento;
        
        // Guardar los resultados en el objeto request para mostrarlos en el JSP
        request.setAttribute("descuento", descuento);
        request.setAttribute("totalAPagar", totalAPagar);
        
        // Redirigir al archivo JSP para mostrar el resultado
        RequestDispatcher dispatcher = request.getRequestDispatcher("ejer3.jsp");
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
