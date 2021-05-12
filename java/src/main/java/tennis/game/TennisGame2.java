package tennis.game;

public class TennisGame2 implements TennisGame {
    private static final String FIFTEEN = "Fifteen";
    private static final String THIRTY = "Thirty";
    private static final String FORTY = "Forty";
    private static final String LOVE = "Love";
    private static final String DEUCE = "Deuce";
    private static final String ALL = "All";
    private static final String SEPARATOR = "-";
    private static final String BLANK = " ";
    private static final String PLAYER_1 = "player1";
    private static final String PLAYER_2 = "player2";
    private static final String ADVANTAGE = "Advantage";
    private static final String WIN_FOR = "Win for";

    private int playerOnePoints = 0;
    private int playerTwoPoints = 0;

    private String playerOneScore = "";
    private String playerTwoScore = "";

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
            score = getPlayerScore(playerOnePoints);
            score += SEPARATOR + ALL;
        }

        if (equalPointsLargerThan3) {
            score = DEUCE;
        }

        if (playerTwoLeadsPlayerTwoLessThan4 || playerOneLeadsPlayerOneLessThan4 || playerTwoLeadsPlayerOne0 || playerOneLeadsPlayerTwo0) {
            playerOneScore = getPlayerScore(playerOnePoints);
            playerTwoScore = getPlayerScore(playerTwoPoints);

            score = playerOneScore + SEPARATOR + playerTwoScore;
        }

        if (playerOneLeadsPlayerTwoLargerThanSame3) {
            score = ADVANTAGE + BLANK + PLAYER_1;
        }

        if (playerTwoLeadsPlayerOneLargerThanSame3) {
            score = ADVANTAGE + BLANK + PLAYER_2;
        }

        if (playerOneLargerSame4andPlayerTwoLargerSame0andLeadsByLargerEquals2) {
            score = WIN_FOR + BLANK + PLAYER_1;
        }

        if (playerTwoLargerThanEquals4andLeadsByLargerEquals2) {
            score = WIN_FOR + BLANK + PLAYER_2;
        }
        return score;
    }

    private String getPlayerScore(int playerPoints) {
        if (playerPoints == 0) {
            return LOVE;
        }
        if (playerPoints == 1) {
            return FIFTEEN;
        }
        if (playerPoints == 2) {
            return THIRTY;
        }
        if (playerPoints == 3) {
            return FORTY;
        }
        return "";
    }

    private void playerOneScored() {
        playerOnePoints++;
    }

    private void playerTwoScored() {
        playerTwoPoints++;
    }

    public void wonPoint(String player) {
        if (player.equals(PLAYER_1)) {
            playerOneScored();
        } else {
            playerTwoScored();
        }
    }
}
