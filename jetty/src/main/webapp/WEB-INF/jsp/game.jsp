<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>

<layout:default>
	<jsp:attribute name="content">
		<img id="table" src="http://jonghost.iyikes.com/craps/table.php?
			p=<c:out value="${point}"/>
			&pl=<c:out value="${passline}"/>
			&dp=<c:out value="${dontpass}"/>
			&dc=<c:out value="${dontcome}"/>
			&c=<c:out value="${come}"/>
			&f=<c:out value="${field}"/>
			&p4=<c:out value="${placefour}"/>
			&p5=<c:out value="${placefive}"/>
			&p6=<c:out value="${placesix}"/>
			&p8=<c:out value="${placeeight}"/>
			&p9=<c:out value="${placenine}"/>
			&p10=<c:out value="${placeten}"/>
			&a7=<c:out value="${anyseven}"/>
			&ac=<c:out value="${anycraps}"/>
			&pr2=<c:out value="${proptwo}"/>
			&pr3=<c:out value="${propthree}"/>
			&pr11=<c:out value="${propeleven}"/>
			&pr12=<c:out value="${proptwelve}"/>
			&h4=<c:out value="${hardwayfour}"/>
			&h6=<c:out value="${hardwaysix}"/>
			&h8=<c:out value="${hardwayeight}"/>
			&h10=<c:out value="${hardwayten}"/>
		"/>
	<c:if test='${diceone != 0 && dicetwo != 0}'>
        <img id="diceone" height="80" width="80" src="<c:url value="/images/dice"/><c:out value="${diceone}"/>.png"/>
        <img id="dicetwo" height="80" width="80" src="<c:url value="/images/dice"/><c:out value="${dicetwo}"/>.png"/>
	</c:if>

        <div id="status">
            <c:out value="${crapStatus}"/><br/>
    		Your Balance = <c:out value="${playerbal}"/><br/>
            <c:if test='${point != 0}'>
                Point = <c:out value="${point}"/><br/>
            </c:if>
            <c:if test='${point == 0}'>
                Point not set.<br/>
            </c:if>
            <c:if test='${comePoint != 0}'>
                Come Point = <c:out value="${comePoint}"/><br/>
            </c:if>
            <c:if test='${comePoint == 0}'>
                Come Point not set.<br/>
            </c:if>
            <c:if test='${dontComePoint != 0}'>
                Don't Come Point = <c:out value="${dontComePoint}"/><br/>
            </c:if>
            <c:if test='${dontComePoint == 0}'>
                Don't Come Point not set.<br/>
            </c:if>
            ------Current Bets------<br/>
		    <c:out value="${passLineBet}"/><br/>
            <c:out value="${dontPassLineBet}"/><br/>
            <c:out value="${placeBet}"/><br/>
            <c:out value="${dontComeBet}"/><br/>
            <c:out value="${hardwayBet}"/><br/>
            <c:out value="${propBet}"/><br/>
            <c:out value="${comeBet}"/><br/>
            <c:out value="${fieldBet}"/><br/>
            --------Payout--------<br/>
	    <c:out value="${passLinePayout}"/><br/>
            <c:out value="${dontPassLinePayout}"/><br/>
            <c:out value="${placePayout}"/><br/>
            <c:out value="${dontComePayout}"/><br/>
            <c:out value="${hardwayPayout}"/><br/>
            <c:out value="${propPayout}"/><br/>
            <c:out value="${comePayout}"/><br/>
            <c:out value="${fieldPayout}"/><br/>
        </div>

        <div id="betform">
		<c:out value="${errorMsg}"/><br/>
		<form action="<c:url value="/roll"/>" method="post">
			<div id="betname">Passline Bet:</div>
			<input id="betamt" type="text" name="passlineBet"/><br/>
			<div id="betname">Don't Passline Bet:</div>
			<input id="betamt" type="text" name="dontPasslineBet"/><br/>
			<div id="betname">Place 4 Bet:</div>
			<input id="betamt" type="text" name="placefourBet"/><br/>
			<div id="betname">Place 5 Bet:</div>
			<input id="betamt" type="text" name="placefiveBet"/><br/>
			<div id="betname">Place 6 Bet:</div>
			<input id="betamt" type="text" name="placesixBet"/><br/>
			<div id="betname">Place 8 Bet:</div>
			<input id="betamt" type="text" name="placeeightBet"/><br/>
			<div id="betname">Place 9 Bet:</div>
			<input id="betamt" type="text" name="placenineBet"/><br/>
			<div id="betname">Place 10 Bet:</div>
			<input id="betamt" type="text" name="placetenBet"/><br/>
			<div id="betname">Come Bet:</div>
			<input id="betamt" type="text" name="comeBet"/><br/>
			<div id="betname">Don't Come Bet:</div>
			<input id="betamt" type="text" name="dontComeBet"/><br/>
			<div id="betname">Hardway 4 Bet:</div>
			<input id="betamt" type="text" name="hardwayfourBet"/><br/>
			<div id="betname">Hardway 6 Bet:</div>
			<input id="betamt" type="text" name="hardwaysixBet"/><br/>
			<div id="betname">Hardway 8 Bet:</div>
			<input id="betamt" type="text" name="hardwayeightBet"/><br/>
			<div id="betname">Hardway 10 Bet:</div>
			<input id="betamt" type="text" name="hardwaytenBet"/><br/>
			<div id="betname">Any Seven Bet:</div>
			<input id="betamt" type="text" name="propAnySevenBet"/><br/>
			<div id="betname">Any Craps Bet:</div>
			<input id="betamt" type="text" name="propAnyCrapsBet"/><br/>
			<div id="betname">Proposition 2 Bet:</div>
			<input id="betamt" type="text" name="propTwoBet"/><br/>
			<div id="betname">Proposition 3 Bet:</div>
			<input id="betamt" type="text" name="propThreeBet"/><br/>
			<div id="betname">Proposition 11 Bet:</div>
			<input id="betamt" type="text" name="propElevenBet"/><br/>
			<div id="betname">Proposition 12 Bet:</div>
			<input id="betamt" type="text" name="propTwelveBet"/><br/>
			<div id="betname">Field Bet:</div>
			<input id="betamt" type="text" name="fieldBet"/><br/>
			<input type="submit" value="Roll"/><br/>
		</form>
        </div>

<%-- End content container --%>
	</jsp:attribute>
</layout:default>
