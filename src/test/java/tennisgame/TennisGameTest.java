package tennisgame;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * @author huisheng.jin
 * @date 2020/11/25.
 */
public class TennisGameTest {

    @ParameterizedTest
    @CsvSource({
            "0,0,love-all",
            "1,0,fifteen-love",
            "2,0,thirty-love",
            "3,0,forty-love",

            "0,1,love-fifteen",
            "0,2,love-thirty",
            "0,3,love-forty",

            "1,1,fifteen-all",
            "2,2,thirty-all",
            "3,3,forty-all",

            "4,2,firstPlayer win",
            "2,4,secondPlayer win",

            "4,4,deuce",
            "5,5,deuce",

            "4,3,firstPlayer advantage",
            "5,3,firstPlayer win",

            "3,4,secondPlayer advantage",

    })
    public void assertEqual(int firstPlayerGoals, int secondPlayerGoals, String expected) {
        assertThat(TennisGame.score(firstPlayerGoals, secondPlayerGoals)).isEqualTo(expected);
    }

}
