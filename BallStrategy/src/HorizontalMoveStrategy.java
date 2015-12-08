/**
 * Created by soyoon on 2015. 12. 8..
 */
public class HorizontalMoveStrategy implements MoveStrategy {
    public void move(Ball ball) {
        ball.setxInterval(Ball.INTERVAL);
        ball.setyInterval(0);
    }
}
