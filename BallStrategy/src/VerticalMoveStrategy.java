/**
 * Created by soyoon on 2015. 12. 8..
 */
public class VerticalMoveStrategy implements MoveStrategy {
    public void move(Ball ball) {
        ball.setxInterval(0);
        ball.setyInterval(Ball.INTERVAL);
    }
}
