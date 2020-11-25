package tennisgame;

import java.util.HashMap;

/**
 * @author huisheng.jin
 * @date 2020/11/25.
 */
public class TennisGame {

    private static HashMap<Integer, String> map;

    static {
        map = new HashMap<>();
        map.put(0, "love");
        map.put(1, "fifteen");
        map.put(2, "thirty");
        map.put(3, "forty");
    }

    private final int firstPlayerGoals;
    private final int secondPlayerGoals;

    public TennisGame(int firstPlayerGoals, int secondPlayerGoals) {

        this.firstPlayerGoals = firstPlayerGoals;
        this.secondPlayerGoals = secondPlayerGoals;
    }

    public static String score(int firstPlayerGoals, int secondPlayerGoals) {
        TennisGame tennisGame = new TennisGame(firstPlayerGoals, secondPlayerGoals);
        return tennisGame.score();
    }

    private String score() {
        return isSame()
                ? isDeuce() ? deuce() : normalSame()
                : isReadyWin() ? readyWin() : normalScore();
    }

    private String normalScore() {
        return map.get(firstPlayerGoals) + "-" + map.get(secondPlayerGoals);
    }

    private String readyWin() {
        return leadingPlayer() + " " + progress();
    }

    private boolean isReadyWin() {
        return firstPlayerGoals >= 2 && secondPlayerGoals >= 2;
    }

    private String normalSame() {
        return map.get(firstPlayerGoals) + "-all";
    }

    private String deuce() {
        return "deuce";
    }

    private boolean isDeuce() {
        return firstPlayerGoals >= 4;
    }

    private boolean isSame() {
        return firstPlayerGoals == secondPlayerGoals;
    }

    private String progress() {
        if (Math.abs(this.firstPlayerGoals - this.secondPlayerGoals) == 1) {
            return "advantage";
        } else {
            return "win";
        }
    }

    private String leadingPlayer() {
        return this.firstPlayerGoals - this.secondPlayerGoals > 0 ? "firstPlayer" : "secondPlayer";
    }

}
