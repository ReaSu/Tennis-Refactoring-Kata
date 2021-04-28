package tennis.game;

public class TennisGame2 implements TennisGame {
    private int playerOnePoints = 0;
    private int playerTwoPoints = 0;

    private String player1score = "";
    private String player2score = "";

    /*
     * done - Zustände lesbar machen, eventuell Booleans Alle Warnings ausbessern
     */

    public String getScore() {
        String score = "";
        boolean equalPointsLessThan4 = playerOnePoints == playerTwoPoints && playerOnePoints < 4;
        boolean equalPointsLargerThan3 = playerOnePoints == playerTwoPoints && playerOnePoints >= 3;
        boolean playerOneLeadsPlayerTwo0 = playerOnePoints > 0 && playerTwoPoints == 0;
        boolean playerOneLeadsPlayerOneLessThan4 = playerOnePoints > playerTwoPoints && playerOnePoints < 4;
        boolean playerTwoLeadsPlayerTwoLessThan4 = playerTwoPoints > playerOnePoints && playerTwoPoints < 4;
        boolean playerOneLeadsPlayerTwoLargerThanSame3 = playerOnePoints > playerTwoPoints && playerTwoPoints >= 3;
        boolean playerTwoLeadsPlayerOneLargerThanSame3 = playerTwoPoints > playerOnePoints && playerOnePoints >= 3;
        boolean playerOneLargerSame4andPlayerTwoLargerSame0andLeadsByLargerEquals2 = playerOnePoints >= 4
                && playerTwoPoints >= 0 && (playerOnePoints - playerTwoPoints) >= 2;
        boolean playerTwoLargerThanEquals4andLeadsByLargerEquals2 = playerTwoPoints >= 4 && playerOnePoints >= 0
                && (playerTwoPoints - playerOnePoints) >= 2;
        boolean playerTwoLeadsPlayerOne0 = playerTwoPoints > 0 && playerOnePoints == 0;

        if (equalPointsLessThan4) {
            if (playerOnePoints == 0) {
                score = "Love";
            }
            if (playerOnePoints == 1) {
                score = "Fifteen";
            }
            if (playerOnePoints == 2) {
                score = "Thirty";
            }
            score += "-All";
        }
        if (equalPointsLargerThan3) {
            score = "Deuce";
        }

        if (playerOneLeadsPlayerTwo0) {
            if (playerOnePoints == 1)
                player1score = "Fifteen";
            if (playerOnePoints == 2)
                player1score = "Thirty";
            if (playerOnePoints == 3)
                player1score = "Forty";

            player2score = "Love";
            score = player1score + "-" + player2score;
        }
        if (playerTwoLeadsPlayerOne0) {
            if (playerTwoPoints == 1)
                player2score = "Fifteen";
            if (playerTwoPoints == 2)
                player2score = "Thirty";
            if (playerTwoPoints == 3)
                player2score = "Forty";

            player1score = "Love";
            score = player1score + "-" + player2score;
        }

        if (playerOneLeadsPlayerOneLessThan4) {

            if (playerOnePoints == 2)
                player1score = "Thirty";
            if (playerOnePoints == 3)
                player1score = "Forty";
            if (playerTwoPoints == 1)
                player2score = "Fifteen";
            if (playerTwoPoints == 2)
                player2score = "Thirty";
            score = player1score + "-" + player2score;
        }

        if (playerTwoLeadsPlayerTwoLessThan4) {
            if (playerTwoPoints == 2)
                player2score = "Thirty";
            if (playerTwoPoints == 3)
                player2score = "Forty";
            if (playerOnePoints == 1)
                player1score = "Fifteen";
            if (playerOnePoints == 2)
                player1score = "Thirty";
            score = player1score + "-" + player2score;
        }

        if (playerOneLeadsPlayerTwoLargerThanSame3) {
            score = "Advantage player1";
        }

        if (playerTwoLeadsPlayerOneLargerThanSame3) {
            score = "Advantage player2";
        }

        if (playerOneLargerSame4andPlayerTwoLargerSame0andLeadsByLargerEquals2) {
            score = "Win for player1";
        }

        if (playerTwoLargerThanEquals4andLeadsByLargerEquals2) {
            score = "Win for player2";
        }
        return score;
    }

    private void playerOneScored() {
        playerOnePoints++;
    }

    private void playerTwoScored() {
        playerTwoPoints++;
    }

    public void wonPoint(String player) {
        if (player.equals("player1"))
            playerOneScored();
        else
            playerTwoScored();
    }
}