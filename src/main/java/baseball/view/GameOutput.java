package baseball.view;

import baseball.model.BallStatus;

import java.util.Collections;
import java.util.List;

public class GameOutput {
    private static final String GAME_FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void viewBallStatus(List<BallStatus> result) {
        int strike = Collections.frequency(result, BallStatus.STRIKE);
        int ball = Collections.frequency(result, BallStatus.BALL);

        printResult(strike, ball);
    }

    public void printResult(int strike, int ball) {
        if(ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if(strike > 0) {
            System.out.print(strike + "스트라이크");
        }
        if(strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public void printEndResult() {
        System.out.println(GAME_FINISH_MESSAGE);
    }
}
