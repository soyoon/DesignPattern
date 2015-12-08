import java.awt.*;

/**
 * Created by soyoon on 2015. 12. 8..
 */
public class Client {
    private static final int INIT_LOCATION[] = {50, 100, 150};
    public static void main(String[] args) {
        Ball balls[] = new Ball[3];
        for (int i = 0; i < balls.length; i++) {
            balls[i] = new Ball(INIT_LOCATION[i], INIT_LOCATION[i]);
            balls[i].start();
        }

        balls[0].setMoveStrategy(new HorizontalMoveStrategy());
        balls[0].setColor(Color.red);

        balls[1].setMoveStrategy(new VerticalMoveStrategy());
        balls[1].setColor(Color.red);

        balls[2].setMoveStrategy(new DiagonalMoveStrategy());
        balls[2].setColor(Color.blue);

        new BallFrame(balls);
    }
}
