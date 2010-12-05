package net.rallyedu.Crapout.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


import static net.rallyedu.Crapout.TwitterUtils.newTwitter;
import static net.rallyedu.Crapout.TwitterUtils.setAccessToken;


import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.http.RequestToken;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static net.rallyedu.Crapout.TwitterUtils.newTwitter;
import static net.rallyedu.Crapout.TwitterUtils.setAccessToken;


/**
 * Created by IntelliJ IDEA.
 * User: kalkur
 * Date: Dec 5, 2010
 * Time: 4:44:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class SignoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         //Access the session key and nullify it
         HttpSession session = req.getSession();
         setAccessToken(session, null);

         resp.sendRedirect("login");


    }


}
