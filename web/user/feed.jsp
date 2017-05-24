<%@include file="../WEB-INF/jspf/header.jspf" %>
    <div class="container">
        <c:choose>
            <c:when test="${movie.title == 'Não encontrado!'}">
                <h1>${movie.title}</h1>
            </c:when>
            <c:when test="${movie.title != 'Não encontrado!' && movie.getImdbID() != null}">
                <mv:MovieTag poster="${movie.poster}" released="${movie.released}" title="${movie.title}" />
            </c:when>
        </c:choose>
    </div>
<%@include file="../WEB-INF/jspf/footer.jspf" %>
