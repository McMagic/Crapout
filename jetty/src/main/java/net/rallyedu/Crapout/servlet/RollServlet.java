package net.rallyedu.Crapout.servlet;

import net.rallyedu.Crapout.Game;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RollServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        int playerBalance = Game.getPlayerBal();
        int betTotal = 0;
        String errorMsg = "";

        /** Get the bets from the form input **/
        int passlineBet = 0;
        if (req.getParameter("passlineBet").equals("")){
            passlineBet = 0;
        }
        else {
            try
            {
                passlineBet = Integer.parseInt(req.getParameter("passlineBet"));
                if (passlineBet < 0)
                {
                    passlineBet = 0;
                }
            }
            catch (NumberFormatException e)
            {
                errorMsg += " Passline";
            }
        }
        betTotal += passlineBet;

        int dontPasslineBet = 0;
        if (req.getParameter("dontPasslineBet").equals("")){
            dontPasslineBet = 0;
        }
        else {
            try
            {
                dontPasslineBet = Integer.parseInt(req.getParameter("dontPasslineBet"));
                if (dontPasslineBet < 0)
                {
                    dontPasslineBet = 0;
                }
            }
            catch (NumberFormatException e)
            {
                errorMsg += ", Don't Passline";
            }
        }
        betTotal += dontPasslineBet;

        int placefourBet = 0;
        if (req.getParameter("placefourBet").equals("")){
            placefourBet = 0;
        }
        else {
            try
            {
                placefourBet = Integer.parseInt(req.getParameter("placefourBet"));
                //Check for valid input on place bet 4
                if ((placefourBet + Game.getPlaceBet(0)) < 0)
                {
                    placefourBet = (-1 * Game.getPlaceBet(0));
                }
            }
            catch (NumberFormatException e)
            {
                errorMsg += ", Place 4";
            }
        }
        betTotal += placefourBet;

        int placefiveBet = 0;
        if (req.getParameter("placefiveBet").equals("")){
            placefiveBet = 0;
        }
        else {
            try
            {
                placefiveBet = Integer.parseInt(req.getParameter("placefiveBet"));
                //Check for valid input on place bet 5
                if ((placefiveBet + Game.getPlaceBet(1)) < 0)
                {
                    placefiveBet = (-1 * Game.getPlaceBet(1));
                }
            }
            catch (NumberFormatException e)
            {
                errorMsg += ", Place 5";
            }
        }
        betTotal += placefiveBet;

        int placesixBet = 0;
        if (req.getParameter("placesixBet").equals("")){
            placesixBet = 0;
        }
        else {
            try
            {
                placesixBet = Integer.parseInt(req.getParameter("placesixBet"));
                //Check for valid input on place bet 6
                if ((placesixBet + Game.getPlaceBet(2)) < 0)
                {
                    placesixBet = (-1 * Game.getPlaceBet(2));
                }
            }
            catch (NumberFormatException e)
            {
                errorMsg += ", Place 6";
            }
        }
        betTotal += placesixBet;

        int placeeightBet = 0;
        if (req.getParameter("placeeightBet").equals("")){
            placeeightBet = 0;
        }
        else {
            try
            {
                placeeightBet = Integer.parseInt(req.getParameter("placeeightBet"));
                //Check for valid input on place bet 8
                if ((placeeightBet + Game.getPlaceBet(3)) < 0)
                {
                    placeeightBet = (-1 * Game.getPlaceBet(3));
                }
            }
            catch (NumberFormatException e)
            {
                errorMsg += ", Place 8";
            }
        }
        betTotal += placeeightBet;

        int placenineBet = 0;
        if (req.getParameter("placenineBet").equals("")){
            placenineBet = 0;
        }
        else {
            try
            {
                placenineBet = Integer.parseInt(req.getParameter("placenineBet"));
                //Check for valid input on place bet 9
                if ((placenineBet + Game.getPlaceBet(4)) < 0)
                {
                    placenineBet = (-1 * Game.getPlaceBet(4));
                }
            }
            catch (NumberFormatException e)
            {
                errorMsg += ", Place 9";
            }
        }
        betTotal += placenineBet;

        int placetenBet = 0;
        if (req.getParameter("placetenBet").equals("")){
            placetenBet = 0;
        }
        else {
            try
            {
                placetenBet = Integer.parseInt(req.getParameter("placetenBet"));
                //Check for valid input on place bet 10
                if ((placetenBet + Game.getPlaceBet(5)) < 0)
                {
                    placetenBet = (-1 * Game.getPlaceBet(5));
                }
            }
            catch (NumberFormatException e)
            {
                errorMsg += ", Place 10";
            }
        }
        betTotal += placetenBet;

        int comeBet = 0;
        if (req.getParameter("comeBet").equals("")){
            comeBet = 0;
        }
        else {
            try
            {
                comeBet = Integer.parseInt(req.getParameter("comeBet"));
                if (comeBet < 0)
                {
                    comeBet = 0;
                }
            }
            catch (NumberFormatException e)
            {
                errorMsg += ", Come";
            }
        }
        betTotal += comeBet;

        int dontComeBet = 0;
        if (req.getParameter("dontComeBet").equals("")){
            dontComeBet = 0;
        }
        else {
            try
            {
                dontComeBet = Integer.parseInt(req.getParameter("dontComeBet"));
                if (dontComeBet < 0)
                {
                    dontComeBet = 0;
                }
            }
            catch (NumberFormatException e)
            {
                errorMsg += ", Don't Come";
            }
        }
        betTotal += dontComeBet;

        int hardwayfourBet = 0;
        if (req.getParameter("hardwayfourBet").equals("")){
            hardwayfourBet = 0;
        }
        else {
            try
            {
                hardwayfourBet = Integer.parseInt(req.getParameter("hardwayfourBet"));
                //Check for valid input on hardway bet 4
                if ((hardwayfourBet + Game.getHardBet(0)) < 0)
                {
                    hardwayfourBet = (-1 * Game.getHardBet(0));
                }
            }
            catch (NumberFormatException e)
            {
                errorMsg += ", Hardway 4";
            }
        }
        betTotal += hardwayfourBet;

        int hardwaysixBet = 0;
        if (req.getParameter("hardwaysixBet").equals("")){
            hardwaysixBet = 0;
        }
        else {
            try
            {
                hardwaysixBet = Integer.parseInt(req.getParameter("hardwaysixBet"));
                //Check for valid input on hardway bet 6
                if ((hardwaysixBet + Game.getHardBet(1)) < 0)
                {
                    hardwaysixBet = (-1 * Game.getHardBet(1));
                }
            }
            catch (NumberFormatException e)
            {
                errorMsg += ", Hardway 6";
            }
        }
        betTotal += hardwaysixBet;

        int hardwayeightBet = 0;
        if (req.getParameter("hardwayeightBet").equals("")){
            hardwayeightBet = 0;
        }
        else {
            try
            {
                hardwayeightBet = Integer.parseInt(req.getParameter("hardwayeightBet"));
                //Check for valid input on hardway bet 8
                if ((hardwayeightBet + Game.getHardBet(2)) < 0)
                {
                    hardwayeightBet = (-1 * Game.getHardBet(2));
                }
            }
            catch (NumberFormatException e)
            {
                errorMsg += ", Hardway 8";
            }
        }
        betTotal += hardwayeightBet;

        int hardwaytenBet = 0;
        if (req.getParameter("hardwaytenBet").equals("")){
            hardwaytenBet = 0;
        }
        else {
            try
            {
                hardwaytenBet = Integer.parseInt(req.getParameter("hardwaytenBet"));
                //Check for valid input on hardway bet 10
                if ((hardwaytenBet + Game.getHardBet(3)) < 0)
                {
                    hardwaytenBet = (-1 * Game.getHardBet(3));
                }
            }
            catch (NumberFormatException e)
            {
                errorMsg += ", Hardway 10";
            }
        }
        betTotal += hardwaytenBet;

        int propAnySevenBet = 0;
        if (req.getParameter("propAnySevenBet").equals("")){
            propAnySevenBet = 0;
        }
        else {
            try
            {
                propAnySevenBet = Integer.parseInt(req.getParameter("propAnySevenBet"));
                //Check for valid input on proposition bet 7
                if ((propAnySevenBet + Game.getPropBet(0)) < 0)
                {
                    propAnySevenBet = (-1 * Game.getPropBet(0));
                }
            }
            catch (NumberFormatException e)
            {
                errorMsg += ", Proposition Any Seven";
            }
        }
        betTotal += propAnySevenBet;

        int propAnyCrapsBet = 0;
        if (req.getParameter("propAnyCrapsBet").equals("")){
            propAnyCrapsBet = 0;
        }
        else {
            try
            {
                propAnyCrapsBet = Integer.parseInt(req.getParameter("propAnyCrapsBet"));
                //Check for valid input on Any Craps proposition bet
                if ((propAnyCrapsBet + Game.getPropBet(1)) < 0)
                {
                    propAnyCrapsBet = (-1 * Game.getPropBet(1));
                }
            }
            catch (NumberFormatException e)
            {
                errorMsg += ", Proposition Any Craps";
            }
        }
        betTotal += propAnyCrapsBet;

        int propTwoBet = 0;
        if (req.getParameter("propTwoBet").equals("")){
            propTwoBet = 0;
        }
        else {
            try
            {
                propTwoBet = Integer.parseInt(req.getParameter("propTwoBet"));
                //Check for valid input on proposition bet 2
                if ((propTwoBet + Game.getPropBet(2)) < 0)
                {
                    propTwoBet = (-1 * Game.getPropBet(2));
                }
            }
            catch (NumberFormatException e)
            {
                errorMsg += ", Proposition 2 bet";
            }
        }
        betTotal += propTwoBet;

        int propThreeBet = 0;
        if (req.getParameter("propThreeBet").equals("")){
            propThreeBet = 0;
        }
        else {
            try
            {
                propThreeBet = Integer.parseInt(req.getParameter("propThreeBet"));
                //Check for valid input on proposition bet 2
                if ((propThreeBet + Game.getPropBet(3)) < 0)
                {
                    propThreeBet = (-1 * Game.getPropBet(3));
                }
            }
            catch (NumberFormatException e)
            {
                errorMsg += ", Proposition 3";
            }
        }
        betTotal += propThreeBet;

        int propElevenBet = 0;
        if (req.getParameter("propElevenBet").equals("")){
            propElevenBet = 0;
        }
        else {
            try
            {
                propElevenBet = Integer.parseInt(req.getParameter("propElevenBet"));
                //Check for valid input on proposition bet 2
                if ((propElevenBet + Game.getPropBet(4)) < 0)
                {
                    propElevenBet = (-1 * Game.getPropBet(4));
                }
            }
            catch (NumberFormatException e)
            {
                errorMsg += ", Proposition 11";
            }
        }
        betTotal += propElevenBet;

        int propTwelveBet = 0;
        if (req.getParameter("propTwelveBet").equals("")){
            propTwelveBet = 0;
        }
        else {
            try
            {
                propTwelveBet = Integer.parseInt(req.getParameter("propTwelveBet"));
                //Check for valid input on proposition bet 2
                if ((propTwelveBet + Game.getPropBet(5)) < 0)
                {
                    propTwelveBet = (-1 * Game.getPropBet(5));
                }
            }
            catch (NumberFormatException e)
            {
                errorMsg += ", Proposition 12";
            }
        }
        betTotal += propTwelveBet;

        int fieldBet = 0;
        if (req.getParameter("fieldBet").equals("")){
            fieldBet = 0;
        }
        else {
            try
            {
                fieldBet = Integer.parseInt(req.getParameter("fieldBet"));
                if (fieldBet < 0)
                {
                    fieldBet = 0;
                }
            }
            catch (NumberFormatException e)
            {
                errorMsg += ", Field";
            }
        }
        betTotal += fieldBet;

        // Store the bets
        int[] betInput = new int[6];


        if (errorMsg != "")
        {
            errorMsg = "You placed non-numerical" + errorMsg + " bets, silly! ";
        }

        if ((Game.getBet(0) + passlineBet) == 0){
            errorMsg = "You need to place a pass line bet in order to roll";
        }
        else{
            /** Set bets here **/
            if (betTotal <= playerBalance)
            {
                //Point is not set, only set the passline/don't passline bet
                if (Game.getPoint() == 0){
                    betInput[0] = passlineBet;
                    Game.setPlayerBets(betInput,0);
                    betInput[0] = dontPasslineBet;
                    Game.setPlayerBets(betInput,1);
                }

                //Point has been set, may place any other bet except passline/don't passline bets
                else if (Game.getPoint() > 0){
                    //Place Bets
                    betInput[0] = placefourBet;
                    betInput[1] = placefiveBet;
                    betInput[2] = placesixBet;
                    betInput[3] = placeeightBet;
                    betInput[4] = placenineBet;
                    betInput[5] = placetenBet;
                    Game.setPlayerBets(betInput,2);

                    //Don't come Bet
                    if (Game.getDontComePoint() == 0)
                    {
                        betInput[0] = dontComeBet;
                        Game.setPlayerBets(betInput,3);
                    }
                    //Come Bet
                    if (Game.getComePoint() == 0){
                        betInput[0] = comeBet;
                        Game.setPlayerBets(betInput,6);
                    }


                }

                /** Bets that can be placed at any point in game **/
                //Hardway Bets
                betInput[0] = hardwayfourBet;
                betInput[1] = hardwaysixBet;
                betInput[2] = hardwayeightBet;
                betInput[3] = hardwaytenBet;
                Game.setPlayerBets(betInput,4);

                //Proposition bets
                betInput[0] = propAnySevenBet;
                betInput[1] = propAnyCrapsBet;
                betInput[2] = propTwoBet;
                betInput[3] = propThreeBet;
                betInput[4] = propElevenBet;
                betInput[5] = propTwelveBet;
                Game.setPlayerBets(betInput,5);

                //Field Bet
                betInput[0] = fieldBet;
                Game.setPlayerBets(betInput,7);

                /** ALL BETS HAVE BEEN SET: START GAME NOW **/
                // Start a round
                Game.playRound();

                // For debugging
                Game.printPlayerBets();
            }

            else
            {
                errorMsg += "Your bets exceeded your balance. No bets have been placed. ";
            }
        }

        session.setAttribute("errorMsg", errorMsg);



        // Redirect to the game page
        resp.sendRedirect("game");
    }
}

