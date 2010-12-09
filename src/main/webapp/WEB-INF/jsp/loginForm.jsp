<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>


<layout:default>
	<jsp:attribute name="content">
        <p>To use Crapout, you must authorize the application access your Twitter account. It's Easy as 1, 2, 3:</p>

        <ol>
            <li>Click <a href="<c:out value="${authUrl}"/>" target="_blank">here</a> to log in to Twitter to generate a PIN.</li>            
            <li>Return to this page and enter the PIN below.</li>
            <li>Click Sign In with Twitter.</li>
        </ol>

        <c:choose>
            <c:when test="${errorMsg != null}">
                <c:out value="${errorMsg}"/><br/>
            </c:when>
            <c:otherwise>
                <c:out value="${param.errorMsg}"/><br/>
            </c:otherwise>
        </c:choose>
                

        <form action="<c:url value="/login"/>" method="post">
            <label for="pin">PIN:</label>
            <input id="pin" type="text" name="pin"/>
            <input id="twitSignIn" type="image" src="/images/twitSignIn.png"/>
        </form>

        
<%-- End content container --%>
	</jsp:attribute>
</layout:default>
