<%@include file="../WEB-INF/jspf/header.jspf" %>
    <c:forEach var="movie" items="${user.movies}">
        <mv:MovieTag poster="${movie.poster}" released="${movie.released}" title="${movie.title}" />
        <a href="${pageContext.request.contextPath}/FrontController?ctrl=CollectionRemove&movie_id=${movie.movie_id}">Remove</a>
    </c:forEach>
<%@include file="../WEB-INF/jspf/footer.jspf" %>