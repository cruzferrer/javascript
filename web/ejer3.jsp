<%-- 
    Document   : ejer3
    Created on : Apr 21, 2023, 12:11:30 AM
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
    <title>ejer3</title>
    <script src="script.js"></script>
    <link rel="stylesheet" href="style.css">
</head>
<body>
       3. Una tienda ofrece un descuento del 15% sobre el total de la compra y un cliente desea saber
cuanto debera pagar finalmente por su compra.
<h1>Descuento en tienda</h1>
    <form action="ejer22" method="post">
        <label for="total">Total de la compra:</label>
        <input type="text" name="total" id="total">
        <p style="color:red">${requestScope.error}</p>
        <input type="submit" value="Calcular">
    </form>
    <p>${requestScope.resultado}</p>

    <h1>Tu descuento es: <%= request.getAttribute("totalAPagar") %></h1>

    <a href="index.jsp">Volver al formulario</a>
</body>
</html>

