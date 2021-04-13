package tennis.game;

public class TennisGame2 implements TennisGame {
    private int player1points = 0;
    private int player2points = 0;

    private String player1score = "";
    private String player2score = "";
    private final String player1Name;   // todo: unused - wozu brauchen wir die?
    private final String player2Name;


    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }
    /*
     * done - Zustände lesbar machen, eventuell Booleans
     * Alle Warnings ausbessern
     * */

    public String getScore() {
        String score = "";
        boolean equalPointsLessThan4 = player1points == player2points && player1points < 4;
        boolean equalPointsLargerThan3 = player1points == player2points && player1points >= 3;
        boolean playerOneLeadsPlayerTwo0 = player1points > 0 && player2points == 0;
        boolean playerOneLeadsPlayerOneLessThan4 = player1points > player2points && player1points < 4;
        boolean playerTwoLeadsPlayerTwoLessThan4 = player2points > player1points && player2points < 4;
        boolean playerOneLeadsPlayerTwoLargerThanSame3 = player1points > player2points && player2points >= 3;
        boolean playerTwoLeadsPlayerOneLargerThanSame3 = player2points > player1points && player1points >= 3;
        boolean playerOneLargerSame4andPlayerTwoLargerSame0andLeadsByLargerEquals2 = player1points >= 4 && player2points >= 0 && (player1points - player2points) >= 2;
        boolean playerTwoLargerThanEquals4andLeadsByLargerEquals2 = player2points >= 4 && player1points >= 0 && (player2points - player1points) >= 2;
        boolean playerTwoLeadsPlayerOne0 = player2points > 0 && player1points == 0;


        if (equalPointsLessThan4) {
            if (player1points == 0) {
                score = "Love";
            }
            if (player1points == 1) {
                score = "Fifteen";
            }
            if (player1points == 2) {
                score = "Thirty";
            }
            score += "-All";
        }
        if (equalPointsLargerThan3) {
            score = "Deuce";
        }

        if (playerOneLeadsPlayerTwo0) {
            if (player1points == 1)
                player1score = "Fifteen";
            if (player1points == 2)
                player1score = "Thirty";
            if (player1points == 3)
                player1score = "Forty";

            player2score = "Love";
            score = player1score + "-" + player2score;
        }
        if (playerTwoLeadsPlayerOne0) {
            if (player2points == 1)
                player2score = "Fifteen";
            if (player2points == 2)
                player2score = "Thirty";
            if (player2points == 3)
                player2score = "Forty";

            player1score = "Love";
            score = player1score + "-" + player2score;
        }

        if (playerOneLeadsPlayerOneLessThan4) {

            if (player1points == 2)
                player1score = "Thirty";
            if (player1points == 3)
                player1score = "Forty";
            if (player2points == 1)
                player2score = "Fifteen";
            if (player2points == 2)
                player2score = "Thirty";
            score = player1score + "-" + player2score;
        }

        if (playerTwoLeadsPlayerTwoLessThan4) {
            if (player2points == 2)
                player2score = "Thirty";
            if (player2points == 3)
                player2score = "Forty";
            if (player1points == 1)
                player1score = "Fifteen";
            if (player1points == 2)
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

    public void SetP1Score(int number) {

        for (int i = 0; i < number; i++) {
            P1Score();
        }

    }

    public void SetP2Score(int number) {

        for (int i = 0; i < number; i++) {
            P2Score();
        }

    }

    public void P1Score() {
        player1points++;
    }

    public void P2Score() {
        player2points++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}