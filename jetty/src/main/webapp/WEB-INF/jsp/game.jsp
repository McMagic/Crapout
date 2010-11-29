<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>

<layout:default>
	<jsp:attribute name="content">
		<img src="http://jonghost.iyikes.com/craps/table.php"/>
<%--
    <c:forEach var="contact" items="${contacts}">
        <tr>
            <td><c:out value="${contact.name}"/></td>
            <td><c:out value="${contact.phoneNumber}"/></td>
            <td><c:out value="${contact.emailAddress}"/></td>
        </tr>
    </c:forEach>
--%>

<%-- End content container --%>
	</jsp:attribute>
</layout:default>
