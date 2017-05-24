<%@include file="../WEB-INF/jspf/header.jspf" %>
    <h2>Olá, ${user.name}</h2>
    <p>Gostaria de <a href="${pageContext.request.contextPath}/user/profile.jsp">Atualizar Cadastro</a> ou <a href="${pageContext.request.contextPath}/FrontController?ctrl=Logout">Sair</a>?</p>
    <form action="${pageContext.request.contextPath}/FrontController" method="GET">
        <select name="c">
            <option value="tv">Série</option>
            <option value="movie">Filme</option>
        </select>
        <p><input type="text" name="q" placeholder="Nome do filme/da série em inglês" /></p>
        <input type="hidden" name="ctrl" value="Busca" />
        <p><button type="submit">Buscar</button></p>
    </form>
    
    <c:choose>
        <c:when test="${movie.title == 'Não encontrado!'}">
            <h1>${movie.title}</h1>
        </c:when>
        <c:when test="${movie.title != 'Não encontrado!' && movie.getImdbID() != null}">
            <mv:MovieTag poster="${movie.poster}" released="${movie.released}" title="${movie.title}" />
        </c:when>
    </c:choose>
    
<%@include file="../WEB-INF/jspf/footer.jspf" %>
