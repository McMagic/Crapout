<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>

<layout:default title="Jittr Auth Request" >
    <jsp:attribute name="content">
        <p>To use Jittr, you must authorize the application access your Twitter account. It's Easy as 1, 2, 3:</p>

        <ol>
            <li>Click <a href="<c:out value="${authUrl}"/>" target="_blank">here</a> to log in to Twitter to generate a PIN.</li>
            <li>Return to this page and enter the PIN below.</li>
            <li>Click Go.</li>
        </ol>

        <form action="<c:url value="/auth"/>" method="post">
            <label for="pin">PIN:</label>
            <input id="pin" type="text" name="pin"/>
            <button type="submit">Go</button>
        </form>
    </jsp:attribute>
</layout:default>