<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>

<layout:default>
    <jsp:attribute name="content">
        <form id="tweet_form" action="<c:url value="/tweet"/>" method="post">
            <textarea cols="40" rows="2" name="text"></textarea>
            <button type="submit">Tweet</button>
        </form>
        <c:forEach var="status" items="${timeline}">
            <div class="status">
                <c:set var="twitterURL" value="http://www.twitter.com/${status.user.screenName}"/>
                <a href="<c:out value="${twitterURL}"/>"><img src="<c:out value="${status.user.profileImageURL}"/>" height="48" width="48" alt="<c:out value="${status.user.screenName}"/>"/></a>
                <a href="<c:out value="${twitterURL}"/>"><c:out value="${status.user.screenName}"/></a>
                <c:out value="${status.text}"/>
            </div>
        </c:forEach>
    </jsp:attribute>
</layout:default>
