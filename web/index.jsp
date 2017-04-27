<%@include file="WEB-INF/jspf/header.jspf" %>
<c:if test="${user == null}" >
    <c:redirect url="/login.jsp" ></c:redirect>
</c:if>
    
    <h2>Olá, ${user.name}</h2>
    <p>Gostaria de <a href="/OnlyTrackerApp/update.jsp">Atualizar Cadastro</a> ou <a href="/OnlyTrackerApp/FrontController?ctrl=Logout">Sair</a>?</p>
    <form action="FrontController" method="GET">
        <p><input type="text" name="q" placeholder="O que deseja buscar?" /></p>
        <input type="hidden" name="ctrl" value="Busca" />
        <p><button type="submit">Buscar</button></p>
    </form>
    
<c:if test="${movie != null}" >
    <h1>${movie.title}</h1>
    <img src="${movie.poster}" alt="" />
    <span>Lançamento: ${movie.released}</span>
    <span>Classificação indicativa: ${movie.rated}</span>
</c:if>
    
<%@include file="WEB-INF/jspf/footer.jspf" %>
