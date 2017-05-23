<%@include file="WEB-INF/jspf/header.jspf" %>
        <div class="container">
            <div id="forms">
                <div id="typeForm">
                    <span class="cadastro textActive">Cadastro</span>
                    <span class="login">Login</span>
                </div>
                <form class="cadastroForm formActive" action="${pageContext.request.contextPath}/FrontController" method="post">
                    <h2>Cadastro</h2>
                    <c:choose>
                        <c:when test="${error == 'Usuário já cadastrado'}">
                            <div class="error"><span>Usuário já cadastrado</span></div>
                        </c:when>
                        <c:when test="${error == 'Há campos em branco ou senhas não são iguais'}">
                            <div class="error"><span>Há campos em branco ou senhas não são iguais</span></div>
                        </c:when>
                    </c:choose>
                    <p><input type="text" name="nome" placeholder="Nome" required /></p>
                    <p><input type="email" name="email" placeholder="Email" required /></p>
                    <p><input type="password" name="password" placeholder="Senha" required /></p>
                    <p><input type="password" name="password_to_verify" placeholder="Confirme a senha" required /></p>
                    <p>
                        <label for="birthday">Data de nascimento</label>
                        <input id="birthday" type="date" name="birthday" required />
                    </p>
                    <input type="hidden" name="ctrl" value="Cadastro" />
                    <p><button type="submit">Enviar</button></p>
                </form>

                <form class="loginForm" action="${pageContext.request.contextPath}/FrontController" method="post">
                    <h2>Login</h2>
                    <c:if test="${error == 'Email ou senha incorreta'}">
                        <div class="error"><span>Email ou senha incorreta</span></div>
                    </c:if>
                    <p><input type="email" name="email" placeholder="Email" required /></p>
                    <p><input type="password" name="password" placeholder="Senha" required /></p>
                    <input type="hidden" name="ctrl" value="Login" />
                    <p><button type="submit">Enviar</button></p>
                </form>
            </div>
        </div>
<%@include file="WEB-INF/jspf/footer.jspf" %>
