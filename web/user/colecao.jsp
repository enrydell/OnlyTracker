<%@include file="../WEB-INF/jspf/header.jspf" %>
    <c:forEach var="movie" items="${user.movies}">
        <mv:MovieTag poster="${movie.poster}" released="${movie.released}" title="${movie.title}" />
    </c:forEach>
<%@include file="../WEB-INF/jspf/footer.jspf" %>