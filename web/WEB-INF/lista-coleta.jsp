<%-- 
    Document   : lista-coleta
    Created on : 24/05/2017, 23:31:50
    Author     : Jessica Barbosa
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Coleta</title>
    </head>
    <body>
        <%@include file="jspf/menu.jspf" %>
        <h1>Lista Coleta </h1>
         <table border="1">
            
            <tr>
                <th>ID</th>
                <th>Descrição</th>
                <th>Data</th>
                
            </tr>
            <c:forEach var="coletas" items="${coletas}">
                <tr>
                <td><a href="edita.html?id=${coletas.id}">${coletas.id} </a></td> 
                <td>${coletas.descricao}</td>
                <td>${coletas.data}</td>
                </tr>
            </c:forEach>
    </body>
</html>
