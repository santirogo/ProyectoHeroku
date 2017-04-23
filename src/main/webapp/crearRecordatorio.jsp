<%-- 
    Document   : index
    Created on : 22/04/2017, 01:02:15 PM
    Author     : ayoro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            body {
                background-image: url(Barcelona.jpg);
                background-repeat: no-repeat;
                background-size: cover;
                margin: 0;
                padding: 0;
            }
            .logo{
                text-align: right;
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="logo"><image src="logo_pagina.png"/></div>
        <h1>Generar recordatorio</h1><br><br>
        <form action="RecordatorioServlet" method="get" name="formato">
            ID: <input type="text" name="id"><br><br>
            Fecha: <input type="text" name="fecha"><br><br>
            Hora: <input type="text" name="hora"><br><br>
            Descripcion: <input type="text" name="descripcion"><br><br>
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>
