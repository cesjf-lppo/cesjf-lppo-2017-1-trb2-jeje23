

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nova Coleta</title>
    </head>
    <body>
         <%@include file="jspf/menu.jspf" %>
        <h1>Novo Pedido</h1>
        <div style ="color: red;">${mensagem}</div>
        <form method="post">
            <div><label>Descrição da coleta: <input type="text" name="descricao" placeholder="digite a descrição"/></label></div>
            <div><input type="submit" /></div>
        </form>
    </body>
</html>
