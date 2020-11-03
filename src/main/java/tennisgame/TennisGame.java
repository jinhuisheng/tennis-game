package tennisgame;

/**
 * @author huisheng.jin
 * @date 2020/11/3.
 */
public class TennisGame {
    private final int firstPlayerGoals;
    private final int secondPlayerGoals;
    private static final String[] SCORE_TEXT = new String[]{"love", "fifteen", "thirty", "forty"};

    public TennisGame(int firstPlayerGoals, int secondPlayerGoals) {
        this.firstPlayerGoals = firstPlayerGoals;
        this.secondPlayerGoals = secondPlayerGoals;
    }

    public String getScore() {
        return isSame()
                ? isDeuce() ? Deuce() : normalSame()
                : readyForWin() ? readyWinScore() : normalScore();
    }

    private String Deuce() {
        return "deuce";
    }

    private String normalSame() {
        return SCORE_TEXT[firstPlayerGoals] + "-all";
    }

    private boolean isDeuce() {
        return firstPlayerGoals > 3;
    }

    private String normalScore() {
        return SCORE_TEXT[firstPlayerGoals] + "-" + SCORE_TEXT[secondPlayerGoals];
    }

    private String readyWinScore() {
        return playerName() + " " + scoreForDeuceAndBeyond();
    }

    private boolean readyForWin() {
        return firstPlayerGoals > 3 || secondPlayerGoals > 3;
    }

    private boolean isSame() {
        return firstPlayerGoals == secondPlayerGoals;
    }

    private String scoreForDeuceAndBeyond() {
        return firstPlayerGoals - secondPlayerGoals != 1 && firstPlayerGoals - secondPlayerGoals != -1
                ? "win" : "advantage";
    }

    private String playerName() {
        return firstPlayerGoals > secondPlayerGoals
                ? "firstPlayer" : "secondPlayer";

    }

}