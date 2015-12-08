/**
 * Created by soyoon on 2015. 12. 8..
 */
public class DiagonalMoveStrategy implements MoveStrategy {
    public void move(Ball ball) {
        ball.setxInterval(ball.INTERVAL);
        ball.setyInterval(ball.INTERVAL);
    }
}
