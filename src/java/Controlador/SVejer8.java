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
@WebServlet(name = "SVejer8", urlPatterns = {"/SVejer8"})
public class SVejer8 extends HttpServlet {

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
            out.println("<title>Servlet SVejer8</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SVejer8 at " + request.getContextPath() + "</h1>");
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
         response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
              String num1 = request.getParameter("1");
        String num2 = request.getParameter("2");
        String num3 = request.getParameter("3");
        String errorMsg = null;
                String pattern = "^[+-]?\\d*(\\.\\d+)?([Ee][+-]?\\d+)?$";

         if (!num1.matches(pattern) || !num2.matches(pattern) || !num3.matches(pattern)) {
            request.setAttribute("error", "Debe ingresar valores numéricos");
            request.getRequestDispatcher("ejer8.jsp").forward(request, response);
            return;
        }
        // Convertir los valores a números enteros
        double n1 = Double.parseDouble(num1);
        double n2 = Double.parseDouble(num2);
        double n3 = Double.parseDouble(num3);
        
        // Encontrar el mayor de los tres números
        double mayor = n1;
        if (n2 > mayor) {
            mayor = n2;
        }
        if (n3 > mayor) {
            mayor = n3;
        }
        
        // Guardar el resultado en el objeto request
        request.setAttribute("mayor", mayor);
        
        // Enviar la respuesta al archivo JSP
        RequestDispatcher view = request.getRequestDispatcher("ejer8.jsp");
        view.forward(request, response);
    
        }  catch (NumberFormatException e) {
            // Si no es un número válido, guardar un mensaje de error y redirigir al JSP
            request.setAttribute("error", "Por favor ingrese un número válido para todos los campos.");
            request.getRequestDispatcher("ejer8.jsp").forward(request, response);
        }
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
