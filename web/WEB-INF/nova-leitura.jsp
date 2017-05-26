

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nova Leitura</title>
    </head>
    <body>
       <%@include file="jspf/menu.jspf" %>
        <h1>Nova Leitura</h1>
        <div style ="color: red;">${mensagem}</div>
        <form method="post">
            <div><label>Unidade: <input type="text" name="unidade" placeholder="digite a unidade"/></label></div>
            <div><label>Local: <input type="text" name="local" placeholder="digite o local"</label></div>
            <div><input type="submit" /></div>
        </form>
    </body>
</html>
