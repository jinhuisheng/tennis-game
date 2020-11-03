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
        if (firstPlayerGoals == secondPlayerGoals) {
            return firstPlayerGoals > 2 ? "deuce" : SCORE_TEXT[firstPlayerGoals] + "-all";
        }
        if (firstPlayerGoals <= 3 && secondPlayerGoals <= 3) {
            return SCORE_TEXT[firstPlayerGoals] + "-" + SCORE_TEXT[secondPlayerGoals];
        }
        return player() + " " + processText();
    }

    private String processText() {
        return firstPlayerGoals - secondPlayerGoals != 1 && firstPlayerGoals - secondPlayerGoals != -1
                ? "win" : "advantage";
    }

    private String player() {
        return firstPlayerGoals > secondPlayerGoals
                ? "firstPlayer" : "secondPlayer";

    }

}