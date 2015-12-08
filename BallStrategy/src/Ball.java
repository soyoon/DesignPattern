import java.awt.*;

/**
 * Created by soyoon on 2015. 12. 8..
 */
public class Ball extends Thread {
    public static int SIZE = 20;
    public static int INTERVAL = 10;
    private int x;
    private int y;
    private int xInterval;
    private int yInterval;
    private Color color;
    private MoveStrategy moveStrategy;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move() {
        moveStrategy.move(this);
    }

    public void run() {
        while(true) {
            x+=xInterval;
            y+=yInterval;
            if(x<0 || xInterval<0 || x+Ball.INTERVAL > BallFrame.WIDTH-15 && xInterval > 0) {
                xInterval = -xInterval;
            }

            if(y<0 || yInterval<0 || y+Ball.INTERVAL > BallFrame.HEIGHT-15 && yInterval > 0) {
                yInterval = -yInterval;
            }

            try{ Thread.sleep(30);} catch(Exception e){};
        }
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setxInterval(int xInterval) {
        this.xInterval = xInterval;
    }

    public void setyInterval(int yInterval) {
        this.yInterval = yInterval;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getxInterval() {
        return xInterval;
    }

    public int getyInterval() {
        return yInterval;
    }

    public Color getColor() {
        return color;
    }

    public MoveStrategy getMoveStrategy() {
        return moveStrategy;
    }
}
