<%-- 
    Document   : ejer1
    Created on : Apr 20, 2023, 11:05:43 PM
    Author     : cruzr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ejer1</title>
    <script src="script.js"></script>
    <link rel="stylesheet" href="style.css">
<html>
<head>
    <meta charset="UTF-8">
    <title>ejer1</title>
    <script src="script.js"></script>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Calcular interés en un banco</h1>
    <p>Suponga que un individuo desea invertir su capital en un banco y desea saber cuánto dinero ganará después de un mes si el banco paga a razón del 2% mensual.</p>
    <form action="SVscript" method="post">
    <label for="capital">Ingrese su capital:</label>
    <input type="text" id="capital" name="capital">
    <input type="submit" value="Calcular interes">
</form>
    <h1>
        <% String error = (String)request.getAttribute("error"); %>
<% if(error != null) { %>
    <div class="alert alert-danger" role="alert">
        <%= error %>
    </div>
<% } %>
    </h1>
    
    <h1>El interés ganado después de un mes es: <%= request.getAttribute("interes") %></h1>

    <a href="index.jsp">Volver al formulario</a>
</body>
</html>
