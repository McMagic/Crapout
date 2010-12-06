<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>

<layout:default>
	<jsp:attribute name="content">
		<h2>Rules</h2>
		<b>What is Craps?</b> Craps is a game of round that consists of a player rolling the 2 dice, shooter. Bets can be made on the table according to the outcomes of the rolls of the 2 dice.<br /><br />

		<b>How to Play</b>: Game starts when the shooter rolls the dice for the first time, come out roll. If the roll results in a 7 or 11 that is an Automatic win and results in a win for Pass Line bets. The shooter now gets to keep the dice and is entitled to another "come out roll".  If the roll results in a 2, 3, or 12 that is Craps and results in a lost for Pass Line bets. The shooter still keeps the dice and is entitled to another "come out roll". If a 4, 5, 6, 8, 9, or 10 is rolled than that number is called the point. A white puck will then be placed on the table to designate what that point is. If a point is rolled the dice will be rolled continuously until the same point is rolled again or a 7 is rolled.<br /><br />

		If the shooter establishes a point, the series continues and the shooter continues to roll the dice. The object of the game now changes and the goal is for the shooter to roll the point number again before rolling a 7.<br /><br />
		If any number other than the point or a 7 is rolled, nothing happens, series continues and shooter rolls again.<br /><br />
		If the point is rolled, Pass Line bets win and the series end.<br /><br />
		If a 7 is rolled, Pass Line bets lose (seven out) and series end. <br /><br />
	
        <h3>References</h3>
        Kanzen, J. (n.d.). Craps Rules. Retrieved October 21, 2010, from Gamblin il dado: <a href="http://www.ildado.com/craps_rules.html" target="_blank">http://www.ildado.com/craps_rules.html</a><br />
Parkansky, K. (n.d.). Basic Craps Play. Retrieved October 21, 2010, from Going to Vegas: <a href="http://www.goingtovegas.com/kpv-crap.htm" target="_blank">http://www.goingtovegas.com/kpv-crap.htm</a><br />
RTG Casinos. (2009). CRAPS. Retrieved October 21, 2010, from Club USA Casino: <a href="http://www.goingtovegas.com/kpv-crap.htm" target="_blank">http://www.rtgcasinos.org/craps.htm</a><br />
        </p>

<%-- End content container --%>
	</jsp:attribute>
</layout:default>
