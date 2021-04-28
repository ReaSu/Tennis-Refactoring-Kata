package tennis.game;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TennisTest {

    private final int playerOneScore;
    private final int playerTwoScore;
    private final String expectedScore;

    public TennisTest(int playerOneScore, int playerTwoScore, String expectedScore) {
        this.playerOneScore = playerOneScore;
        this.playerTwoScore = playerTwoScore;
        this.expectedScore = expectedScore;
    }

    @Parameters(name = "{0}x{1} -> {2}")
    public static Collection<Object[]> getAllScores() {
        return Arrays.asList(new Object[][]{
                /*
                 * (2) TESTS fachlich prüfen Eingabe Wertebereich [0-99 x 0-99] Ausgabe Werte nach Liste ? Diagramm
                 * aller Zustände https://dzone.com/articles/scoring-tennis-using-finite Tests sind fachlich
                 * vollständig!
                 */

                // gleiche zahlen
                {0, 0, "Love-All"},
                {1, 1, "Fifteen-All"},
                {2, 2, "Thirty-All"},
                {3, 3, "Deuce"},
                {4, 4, "Deuce"},

                // mit 0
                {1, 0, "Fifteen-Love"},
                {0, 1, "Love-Fifteen"},
                {2, 0, "Thirty-Love"},
                {0, 2, "Love-Thirty"},
                {3, 0, "Forty-Love"},
                {0, 3, "Love-Forty"},
                {4, 0, "Win for player1"},
                {0, 4, "Win for player2"},

                // mit 1
                {2, 1, "Thirty-Fifteen"},
                {1, 2, "Fifteen-Thirty"},
                {3, 1, "Forty-Fifteen"},
                {1, 3, "Fifteen-Forty"},
                {4, 1, "Win for player1"},
                {1, 4, "Win for player2"},

                // mit 2
                {3, 2, "Forty-Thirty"},
                {2, 3, "Thirty-Forty"},
                {4, 2, "Win for player1"},
                {2, 4, "Win for player2"},

                // mit 1 Differenz
                {4, 3, "Advantage player1"},
                {3, 4, "Advantage player2"},
                {5, 4, "Advantage player1"},
                {4, 5, "Advantage player2"},
                {15, 14, "Advantage player1"},
                {14, 15, "Advantage player2"},

                // mit 2 Differenz
                {6, 4, "Win for player1"},
                {4, 6, "Win for player2"},
                {16, 14, "Win for player1"},
                {14, 16, "Win for player2"},
        });
    }

    private void checkAllScores(TennisGame game) {
        int highestScore = Math.max(this.playerOneScore, this.playerTwoScore);
        for (int i = 0; i < highestScore; i++) {
            if (i < this.playerOneScore) {
                game.wonPoint("play" + "er1");
            }
            if (i < this.playerTwoScore) {
                game.wonPoint("player2");
            }
        }
        assertEquals(this.expectedScore, game.getScore());
    }

    @Test
    public void checkAllScoresTennisGame2() {
        TennisGame2 game = new TennisGame2();
        checkAllScores(game);
    }
}

/*
 * (1) Analyse des IN/OUT IN: Constructor mit player1 name und player2 name IN: game.wonPoint(player name) ... Spieler
 * scored 1 point OUT: game.getScore() ...Score Spielstand als Text
 */
