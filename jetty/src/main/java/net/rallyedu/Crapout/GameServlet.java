package net.rallyedu.Crapout;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class GameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session = req.getSession(true);
	
	session.setAttribute("userid", 1);
	req.setAttribute("playerbal", Game.getPlayerBal());
        req.setAttribute("crapStatus", Game.getCrapStatus());
	
	// MySQL
	try {
		Statement stmt;
		ResultSet rs;
		
		// Define driver for JDBC
		Class.forName("com.mysql.jdbc.Driver");
		
		// Database name is Crapout
		String url = "jdbc:mysql://localhost/Crapout";
		
		// Using root account for now
		String username = "root";
		String password = "CrapOut!";
		Connection con = DriverManager.getConnection(url, username, password);
		
		stmt = con.createStatement();
		
		// Check if there is already this user
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		rs = stmt.executeQuery("SELECT * FROM users WHERE id=" + session.getAttribute("userid"));
		if (!rs.next())
		{
			stmt.executeUpdate("INSERT INTO users(id, playerBal) VALUES (" + session.getAttribute("userid") + ", " + req.getAttribute("playerbal") + ")");
		}
		else
		{
			stmt.executeUpdate("UPDATE users SET playerbal=" + req.getAttribute("playerbal") + " WHERE id=" + session.getAttribute("userid"));
		}
		
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		rs = stmt.executeQuery("SELECT * FROM users ORDER BY id");

		System.out.println("Display all results:");
		while(rs.next())
		{
			int userid = rs.getInt("id");
			int myBalance = rs.getInt("playerBal");
			System.out.println("\tid= " + userid + "\tBalance = " + myBalance);
		}
		
		con.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	String errorMsg = "";
	if (session.getAttribute("errorMsg") != null)
	{
		errorMsg = session.getAttribute("errorMsg").toString();
	}
	req.setAttribute("errorMsg", errorMsg);
	
        req.setAttribute("passLineBet", Game.getBetAmtString(0));
        req.setAttribute("dontPassLineBet", Game.getBetAmtString(1));
        req.setAttribute("PlaceBet", Game.getBetAmtString(2));
        req.setAttribute("dontComeBet", Game.getBetAmtString(3));
        req.setAttribute("hardwayBet", Game.getBetAmtString(4));
        req.setAttribute("propBet", Game.getBetAmtString(5));
        req.setAttribute("comeBet", Game.getBetAmtString(6));
        req.setAttribute("fieldBet", Game.getBetAmtString(7));

        req.setAttribute("passLinePayout", Game.getBetPayoutString(0));
        req.setAttribute("dontPassLinePayout", Game.getBetPayoutString(1));
        req.setAttribute("placePayout", Game.getBetPayoutString(2)); 
        req.setAttribute("dontComePayout", Game.getBetPayoutString(3));
        req.setAttribute("hardwayPayout", Game.getBetPayoutString(4));
        req.setAttribute("propPayout", Game.getBetPayoutString(5));
        req.setAttribute("comePayout", Game.getBetPayoutString(6));
        req.setAttribute("fieldPayout", Game.getBetPayoutString(7));
	
	// For image URL
        req.setAttribute("passline", Game.getBet(0));
        req.setAttribute("dontpass", Game.getBet(1));
        req.setAttribute("dontcome", Game.getBet(3));
        req.setAttribute("come", Game.getBet(6));
        req.setAttribute("Field", Game.getBet(7));
        req.setAttribute("placefour", Game.getPlaceBet(0));
        req.setAttribute("placefive", Game.getPlaceBet(1));
        req.setAttribute("placesix", Game.getPlaceBet(2));
        req.setAttribute("placeeight", Game.getPlaceBet(3));
        req.setAttribute("placenine", Game.getPlaceBet(4));
        req.setAttribute("placeten", Game.getPlaceBet(5));
        req.setAttribute("anyseven", Game.getPropBet(0));
        req.setAttribute("anycraps", Game.getPropBet(1));
        req.setAttribute("proptwo", Game.getPropBet(2));
        req.setAttribute("propthree", Game.getPropBet(3));
        req.setAttribute("propeleven", Game.getPropBet(4));
        req.setAttribute("proptwelve", Game.getPropBet(5));
        req.setAttribute("hardwayfour", Game.getHardBet(0));
        req.setAttribute("hardwaysix", Game.getHardBet(1));
        req.setAttribute("hardwayeight", Game.getHardBet(2));
        req.setAttribute("hardwayten", Game.getHardBet(3));
	
        req.setAttribute("diceone", Game.getDiceVal(0));
        req.setAttribute("dicetwo", Game.getDiceVal(1));
        req.setAttribute("point", Game.getPoint());
        req.setAttribute("comePoint", Game.getComePoint());
        req.setAttribute("dontComePoint", Game.getDontComePoint());
        req.getRequestDispatcher("/WEB-INF/jsp/game.jsp").forward(req, resp);
    }
}

