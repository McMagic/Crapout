package net.rallyedu.lab7.servlet;

import twitter4j.Twitter;
import twitter4j.TwitterException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static net.rallyedu.lab7.TwitterUtils.getTwitter;

public class TweetServlet extends HttpServlet {
    public static final String TEXT_PARAM = "text";
    public static final String TIMELINE_URI = "timeline";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Twitter twitter = getTwitter(req);
        try {
            twitter.updateStatus(req.getParameter(TEXT_PARAM));
            resp.sendRedirect(TIMELINE_URI);
        } catch (TwitterException e) {
            resp.sendError(e.getStatusCode(), e.getMessage());
        }
    }
}
