<%-- 
    Document   : update
    Created on : 21/03/2017, 14:38:40
    Author     : 41514181
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="FrontController" method="POST">
            <h2>Atualizar</h2>
            <p><input type="text" name="nome" placeholder="Nome" value="${user.name}"/></p>
            <p><input type="email" name="email" placeholder="Email" value="${user.email}"/></p>
            <p><input type="password" name="password" placeholder="Senha" required /></p>
            <p><input type="password" name="password_to_verify" placeholder="Confirme a senha" required /></p>
            <label for="birthday">Data de nascimento:</label>
            <p><input id="birthday" type="date" name="birthday" value="${user.birthdayToString()}" required /></p>
            <input type="hidden" name="ctrl" value="Atualizar" />
            <p><button type="submit">Enviar</button></p>
        </form>
    </body>
</html>
