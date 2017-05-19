<%@include file="WEB-INF/jspf/header.jspf" %>
    <div id="index">
        <form action="${pageContext.request.contextPath}/FrontController" method="post">
            <h2>Cadastro</h2>
            <c:choose>
                <c:when test="${error == 'Usuário já cadastrado'}">
                    <span class="error">Usuário já cadastrado</span>
                </c:when>
                <c:when test="${error == 'Há campos em branco ou senhas não são iguais'}">
                    <span class="error">Há campos em branco ou senhas não são iguais</span>
                </c:when>
            </c:choose>
            <p><input type="text" name="nome" placeholder="Nome" required /></p>
            <p><input type="email" name="email" placeholder="Email" required /></p>
            <p><input type="password" name="password" placeholder="Senha" required /></p>
            <p><input type="password" name="password_to_verify" placeholder="Confirme a senha" required /></p>
            <label for="birthday">Data de nascimento:</label>
            <p><input id="birthday" type="date" name="birthday" required /></p>
            <input type="hidden" name="ctrl" value="Cadastro" />
            <p><button type="submit">Enviar</button></p>
        </form>
        
        <form action="${pageContext.request.contextPath}/FrontController" method="post">
            <h2>Login</h2>
            <c:if test="${error == 'Email ou senha incorreta'}">
                <span class="error">Email ou senha incorreta</span>
            </c:if>
            <p><input type="email" name="email" placeholder="Email" required /></p>
            <p><input type="password" name="password" placeholder="Senha" required /></p>
            <input type="hidden" name="ctrl" value="Login" />
            <p><button type="submit">Enviar</button></p>
        </form>
    </div>
<%@include file="WEB-INF/jspf/footer.jspf" %>
