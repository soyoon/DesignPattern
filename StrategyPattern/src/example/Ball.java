package example;

/**
 * Created by soyoon on 2015. 12. 8..
 */
public class Ball {
    private String name;
    private MoveStrategy moveStrategy;
    private ColorStrategy colorStrategy;


    public Ball(String name) {
        this.name = name;
    }

    public void color() {
        colorStrategy.color();
    }

    public void move() {
        moveStrategy.move();
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void setColorStrategy(ColorStrategy colorStrategy) {
        this.colorStrategy = colorStrategy;
    }
}
