<%@include file="../WEB-INF/jspf/header.jspf" %>
    <div class="container">
        <div id="forms">
            <form class="cadastroForm" action="${pageContext.request.contextPath}/FrontController" method="POST">
                <h2>Atualizar</h2>
                <c:choose>
                    <c:when test="${error == 'Senhas não são iguais'}">
                        <div class="error"><span>Senhas não são iguais</span></div>
                    </c:when>
                    <c:when test="${error == 'Email já cadastrado'}">
                        <div class="error"><span>Email já cadastrado</span></div>
                    </c:when>
                </c:choose>
                <p><input type="text" name="nome" placeholder="Nome" value="${user.name}"/></p>
                <p><input type="email" name="email" placeholder="Email" value="${user.email}"/></p>
                <p><input type="password" name="password" placeholder="Senha" required /></p>
                <p><input type="password" name="password_to_verify" placeholder="Confirme a senha" required /></p>
                <p>
                    <label for="birthday">Data de nascimento:</label>
                    <input id="birthday" type="date" name="birthday" value="${user.birthdayToString()}" required />
                </p>
                <input type="hidden" name="ctrl" value="Atualizar" />
                <p><button type="submit">Enviar</button></p>
            </form>
        </div>
    </div>
<%@include file="../WEB-INF/jspf/footer.jspf" %>