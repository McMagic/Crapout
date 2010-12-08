package net.rallyedu.Crapout.servlet;


import twitter4j.Twitter;
import net.rallyedu.Crapout.Game;
import twitter4j.TwitterException;
import twitter4j.http.AccessToken;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

import static net.rallyedu.Crapout.TwitterUtils.getAccessToken;
import static net.rallyedu.Crapout.TwitterUtils.newTwitter;

public class GameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session = req.getSession(true);
	boolean newGame = false;
	
	// The session's userid needs to be set before the MySQL calls
        try {
	            AccessToken accessToken = getAccessToken(session);
	            Twitter twitter = newTwitter(accessToken);
	            req.setAttribute("User", twitter.showUser(twitter.getId()));
		if (session.getAttribute("userid") == null)
		{
	            session.setAttribute("userid", twitter.getId());
			newGame = true;
		}
        } catch (TwitterException e) {
                e.printStackTrace();
        }
	
	if (newGame == false)
	{
		req.setAttribute("playerbal", Game.getPlayerBal());
	}
	
	// MySQL
        try {
                Statement stmt;
                ResultSet rs;

                // Define driver for JDBC
                Class.forName("org.sqlite.JDBC");

                // Database name is Crapout
                String url = "jdbc:sqlite:crapout.db";

                // Using root account for now
                Connection con = DriverManager.getConnection(url);
		
                stmt = con.createStatement();
		stmt.setQueryTimeout(30);
		stmt.executeUpdate("create table if not exists users (id integer, playerBal integer)");
		System.out.println("Create table was fine\n");

                // Check if there is already this user
		rs = stmt.executeQuery("select * from users where id=" + session.getAttribute("userid"));
		System.out.println("Select users was fine\n");
                if ((!rs.next()) && (newGame == true))
                {
			if (newGame == true)
			{
				req.setAttribute("playerbal", 1000);
				Game.setPlayerBal(1000);
	                        stmt.executeUpdate("insert into users(id, playerBal) values (" + session.getAttribute("userid") + ", " + req.getAttribute("playerbal") + ")");
				System.out.println("New game!\n");
			}
			else
			{
				stmt.executeUpdate("insert into users(id, playerBal) values (" + session.getAttribute("userid") + ", " + req.getAttribute("playerbal") + ")");
				System.out.println("Inserting into database!\n");
			}
                }
                else
                {
			if (newGame == true)
			{
				Game.setPlayerBal(rs.getInt("playerBal"));
				req.setAttribute("playerbal", Game.getPlayerBal());
			}
                        stmt.executeUpdate("update users set playerbal=" + req.getAttribute("playerbal") + " where id=" + session.getAttribute("userid"));
                }

                rs = stmt.executeQuery("select * from users order by id");
                System.out.println("Display all results:");
                while(rs.next())
                {
                        String userid = rs.getString("id");
                        int myBalance = rs.getInt("playerBal");
			System.out.println("\nid= " + userid + "\nBalance = " + myBalance);
                }

                con.close();
        } catch (Exception e) {
                e.printStackTrace();
        }
	
        req.setAttribute("crapStatus", Game.getCrapStatus());
	
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

