<%@include file="../WEB-INF/jspf/header.jspf" %>
    <div class="container">
        <c:forEach var="movie" items="${user.movies}">
            <div class="movie">
                <mv:MovieTag poster="${movie.poster}" released="${movie.released}" title="${movie.title}" />
                <a href="${pageContext.request.contextPath}/FrontController?ctrl=CollectionRemove&movie_id=${movie.movie_id}">Remove</a>
            </div>
        </c:forEach>
    </div>
<%@include file="../WEB-INF/jspf/footer.jspf" %>