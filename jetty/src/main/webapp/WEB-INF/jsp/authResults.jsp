<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>

<layout:default title="Jittr Auth Results">
    <jsp:attribute name="content">
        <p>Welcome to Jittr!</p>

        <p>If you would like to avoid generating another pin, use the following command (with system properties) starting the server:</p>

        <p class="command">mvn -Dtoken=<c:out value="${accessToken.token}"/> -DtokenSecret=<c:out value="${accessToken.tokenSecret}"/> jetty:run</p>

        <p>Click <a href="<c:url value="/timeline"/>">here</a> to get to your timeline.</p>
    </jsp:attribute>
</layout:default>
