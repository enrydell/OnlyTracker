<%@include file="../WEB-INF/jspf/header.jspf" %>
    
    <h2>Olá, ${user.name}</h2>
    <p>Gostaria de <a href="${pageContext.request.contextPath}/user/profile.jsp">Atualizar Cadastro</a> ou <a href="${pageContext.request.contextPath}/FrontController?ctrl=Logout">Sair</a>?</p>
    <form action="${pageContext.request.contextPath}/FrontController" method="GET">
        <p><input type="text" name="q" placeholder="Nome do filme/da série em inglês" /></p>
        <input type="hidden" name="ctrl" value="Busca" />
        <p><button type="submit">Buscar</button></p>
    </form>
    
    <c:choose>
        <c:when test="${movie == null}">
            <h1>${error.title}</h1>
        </c:when>
        <c:otherwise>
            <h1>${movie.title}</h1>
            <img src="${movie.poster}" alt="Imagem de ${movie.title}" />
            <span>Lançamento: ${movie.released}</span>
            <span>Classificação indicativa: ${movie.rated}</span>
            <span>Gênero, em inglês: ${movie.genre}</span>
        </c:otherwise>
    </c:choose>
    
<%@include file="../WEB-INF/jspf/footer.jspf" %>
