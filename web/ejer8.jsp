<%-- 
    Document   : ejer8
    Created on : Apr 21, 2023, 3:22:51 PM
    Author     : cruzr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>8. Leer tres números diferentes e imprimir el número mayor de los tres.</h1>
        <form action="SVejer8" method="post">
            Ingrese el primer número: <input type="text" name="1"><br>
            Ingrese el segundo número: <input type="text" name="2"><br>
            Ingrese el tercer número: <input type="text" name="3"><br>

            <input type="submit" value="Calcular"><br>
        </form>

        <h1>El mayor número es: ${mayor}</h1>
        
        <h1>
        <% String error = (String)request.getAttribute("error"); %>
<% if(error != null) { %>
    <div class="alert alert-danger" role="alert">
        <%= error %>
    </div>
<% } %>
    </h1>
        <a href="index.jsp">
            <section>
                Regreso
            </section>
        </a>
    </body>
</html>
