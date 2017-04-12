<%-- 
    Document   : index
    Created on : 09/03/2017, 09:27:53
    Author     : 41514181
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Only Tracker App</title>
    </head>
    <body>
        <form action="FrontController" method="post">
            <h2>Cadastro</h2>
            <p><input type="text" name="nome" placeholder="Nome" required /></p>
            <p><input type="email" name="email" placeholder="Email" required /></p>
            <p><input type="password" name="password" placeholder="Senha" required /></p>
            <p><input type="password" name="password_to_verify" placeholder="Confirme a senha" required /></p>
            <label for="birthday">Data de nascimento:</label>
            <p><input id="birthday" type="date" name="birthday" required /></p>
            <input type="hidden" name="ctrl" value="Cadastro" />
            <p><button type="submit">Enviar</button></p>
        </form>
        
        <form action="FrontController" method="post">
            <h2>Login</h2>
            <p><input type="email" name="email" placeholder="Email" required /></p>
            <p><input type="password" name="password" placeholder="Senha" required /></p>
            <input type="hidden" name="ctrl" value="Login" />
            <p><button type="submit">Enviar</button></p>
        </form>
        
        <c:if test="${user != null}">
            <h2>Olá, ${user.name}</h2>
            <p>Gostaria de <a href="/OnlyTrackerApp/update.jsp">Atualizar Cadastro</a> ou <a href="/OnlyTracker/FrontController?ctrl=Logout">Sair</a>?</p>
        </c:if>
    </body>
</html>
