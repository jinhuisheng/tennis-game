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
        if (firstPlayerGoals == secondPlayerGoals) {
            if (firstPlayerGoals >= 4) {
                return "deuce";
            }
            return map.get(firstPlayerGoals) + "-all";
        }
        if (firstPlayerGoals >= 2 && secondPlayerGoals >= 2) {
            return leadingPlayer() + " " + progress();
        }
        return map.get(firstPlayerGoals) + "-" + map.get(secondPlayerGoals);
    }

    private String progress() {
        if (differValue(1)) {
            return "advantage";
        } else if (differValue(2)) {
            return "win";
        }
        return "";
    }

    private String leadingPlayer() {
        return this.firstPlayerGoals - this.secondPlayerGoals > 0 ? "firstPlayer" : "secondPlayer";
    }

    private boolean differValue(int value) {
        return Math.abs(this.firstPlayerGoals - this.secondPlayerGoals) == value;
    }
}
