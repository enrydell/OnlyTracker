<%@include file="../WEB-INF/jspf/header.jspf" %>
        <form action="${pageContext.request.contextPath}/FrontController" method="POST">
            <h2>Atualizar</h2>
            <c:choose>
                <c:when test="${error == 'Senhas não são iguais'}">
                    <span class="error">Senhas não são iguais</span>
                </c:when>
                <c:when test="${error == 'Email já cadastrado'}">
                    <span class="error">Email já cadastrado</span>
                </c:when>
            </c:choose>
            <p><input type="text" name="nome" placeholder="Nome" value="${user.name}"/></p>
            <p><input type="email" name="email" placeholder="Email" value="${user.email}"/></p>
            <p><input type="password" name="password" placeholder="Senha" required /></p>
            <p><input type="password" name="password_to_verify" placeholder="Confirme a senha" required /></p>
            <label for="birthday">Data de nascimento:</label>
            <p><input id="birthday" type="date" name="birthday" value="${user.birthdayToString()}" required /></p>
            <input type="hidden" name="ctrl" value="Atualizar" />
            <p><button type="submit">Enviar</button></p>
            <p><a href="${pageContext.request.contextPath}/user/feed.jsp">Voltar</a></p>
        </form>
<%@include file="../WEB-INF/jspf/footer.jspf" %>