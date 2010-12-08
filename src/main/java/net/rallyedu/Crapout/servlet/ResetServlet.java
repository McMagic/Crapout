package net.rallyedu.Crapout.servlet;

import net.rallyedu.Crapout.Game;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResetServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Game.setPlayerBal(1000);

        // Redirect to the game page
        resp.sendRedirect("game#game");
    }
}

