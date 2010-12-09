package net.rallyedu.Crapout.servlet;


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
* Date: Dec 4, 2010
* Time: 7:33:52 PM
* To change this template use File | Settings | File Templates.
*/
public class LoginServlet extends HttpServlet {
    public static final String AUTH_FORM_VIEW = "/WEB-INF/jsp/loginForm.jsp";
    public static final String AUTH_RESULTS_VIEW = "/WEB-INF/jsp/game.jsp";
    public static final String AUTH_URL_ATTRIBUTE = "authUrl";
    public static final String REQUEST_TOKEN_ATTRIBUTE = "requestToken";
    public static final String PIN_PARAM = "pin";
    public static final String ERROR_STRING = "Invalid login. Please try again.";
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Calling the new instance of Twitter
        Twitter twitter = newTwitter();


        try {
            RequestToken requestToken = twitter.getOAuthRequestToken();
            req.getSession().setAttribute(REQUEST_TOKEN_ATTRIBUTE, requestToken);
            req.setAttribute(AUTH_URL_ATTRIBUTE, requestToken.getAuthorizationURL());
            req.getRequestDispatcher(AUTH_FORM_VIEW).forward(req, resp);
        } catch (TwitterException e) {

            req.setAttribute("errorMsg", ERROR_STRING);

            req.getRequestDispatcher(AUTH_FORM_VIEW).forward(req, resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Twitter twitter = newTwitter();

        HttpSession session = req.getSession();

        RequestToken requestToken = (RequestToken) session.getAttribute(REQUEST_TOKEN_ATTRIBUTE);


        try {

            session.removeAttribute(REQUEST_TOKEN_ATTRIBUTE);
            

            setAccessToken(session, twitter.getOAuthAccessToken(requestToken, req.getParameter(PIN_PARAM)));
            

            resp.sendRedirect("game#game");

            
        } catch (TwitterException e) {
             resp.sendRedirect("/login?errorMsg=" + ERROR_STRING);



         } catch(IllegalStateException e) {
             resp.sendRedirect("/login?errorMsg=" + ERROR_STRING);
         }
        
    }
}

