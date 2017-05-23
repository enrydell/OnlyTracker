<%@include file="../WEB-INF/jspf/header.jspf" %>
    
    <h2>Ol�, ${user.name}</h2>
    <p>Gostaria de <a href="${pageContext.request.contextPath}/user/profile.jsp">Atualizar Cadastro</a> ou <a href="${pageContext.request.contextPath}/FrontController?ctrl=Logout">Sair</a>?</p>
    <form action="${pageContext.request.contextPath}/FrontController" method="GET">
        <select name="c">
            <option value="tv">S�rie</option>
            <option value="movie">Filme</option>
        </select>
        <p><input type="text" name="q" placeholder="Nome do filme/da s�rie em ingl�s" /></p>
        <input type="hidden" name="ctrl" value="Busca" />
        <p><button type="submit">Buscar</button></p>
    </form>
    
    <c:choose>
        <c:when test="${movie.title == 'N�o encontrado!'}">
            <h1>${movie.title}</h1>
        </c:when>
        <c:when test="${movie.title != 'N�o encontrado!' && movie.getImdbID() != null}">
            <h1>${movie.title}</h1>
            <img src="https://image.tmdb.org/t/p/w640${movie.poster}" alt="Imagem de ${movie.title}" />
            <span>Lan�amento: ${movie.released}</span>
            <!--<span>Classifica��o indicativa: ${movie.rated}</span>-->
            <!--<span>G�nero, em ingl�s: ${movie.genre}</span>-->
        </c:when>
    </c:choose>
    
<%@include file="../WEB-INF/jspf/footer.jspf" %>
