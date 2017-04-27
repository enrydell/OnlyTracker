<%@include file="WEB-INF/jspf/header.jspf" %>
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
<%@include file="WEB-INF/jspf/footer.jspf" %>
