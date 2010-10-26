package net.rallyedu.lab7.servlet;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

import static net.rallyedu.lab7.TwitterUtils.getTwitter;

public class FriendsServlet extends HttpServlet {
    public static final String FRIENDS_ATTRIBUTE = "friends";
    public static final String FRIENDS_VIEW = "/WEB-INF/jsp/friends.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Twitter twitter = getTwitter(req);
        try {
            Collection<User> friends = twitter.getFriendsStatuses();
            req.setAttribute(FRIENDS_ATTRIBUTE, friends);
            req.getRequestDispatcher(FRIENDS_VIEW).forward(req, resp);
        } catch (TwitterException e) {
            resp.sendError(e.getStatusCode(), e.getMessage());
        }

    }


}
