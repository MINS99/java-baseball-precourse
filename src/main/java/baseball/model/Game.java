package baseball.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private Balls computer;
    private GameStatus gameStatus = GameStatus.PROGRESS;

    private static final String INVALID_INPUT_MESSAGE = "올바르지 않은 입력입니다. 게임을 종료합니다.";

    public Game() {
    }

    public void start(String input) {
        computer = Balls.newInstance(input);
    }

    public List<BallStatus> input(String input) {
        Balls player = Balls.newInstance(input);
        List<BallStatus> result = compareBalls(computer, player);
        if (Collections.frequency(result, BallStatus.STRIKE) == 3) {
            gameStatus = GameStatus.FINISHED;
        }
        return result;
    }

    private List<BallStatus> compareBalls(Balls computer, Balls player) {
        List<BallStatus> ballStatus = new ArrayList<>();
        for (Ball playerInput : player.getBalls()) {
            ballStatus.add(compareBall(computer, playerInput));
        }
        return ballStatus;
    }

    private BallStatus compareBall(Balls computer, Ball player) {
        int index = computer.getBalls().indexOf(player);
        if (index != -1 && computer.getBalls().get(index).equals(player)) {
            return BallStatus.STRIKE;
        }
        if (isBall(computer, player)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean isBall(Balls computer, Ball player) {
        boolean ball = false;
        for (Ball comBall : computer.getBalls()) {
            ball = ball || comBall.getNumber().equals(player.getNumber());
        }
        return ball;
    }

    public void end(String input) {
        invalidNumberCheck(input);
        if (input.equals("1")) {
            gameStatus = GameStatus.PROGRESS;
        }
        if (input.equals("2")) {
            gameStatus = GameStatus.END;
        }
    }

    private void invalidNumberCheck(String input) {
        if (input == null || !(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }
}
