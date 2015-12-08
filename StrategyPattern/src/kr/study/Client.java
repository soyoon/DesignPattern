package kr.study;

import example.*;

/**
 * Created by soyoon on 2015. 12. 8..
 */
public class Client {
    /*
    [ 스트래티지 패턴 ]( 전략을 쉽게 바꿀 수 있도록 해주는 디자인 패턴 )
    같은 문제를 해결하는 여러 알고리즘이 클래스별로 캡슐화되어 있고 이들이 필요할 때 교체할 수 있도록 함을써 동일한 문제를
    다른 알고리즘으로 해결할 수 있게 하는 디자인 패턴
    - Strategy : 인터페이스나 추상 클래스로 외부에서 동일한 방식으로 알고리즘을 호출하는 방법을 명시
        --> kr.study.MovingStrategy, kr.study.AttackStrategy
    - ConcreteStrategy1, ConcreteStrategy2, ConcreteStrategy3 : 스트래티치 패턴에서 명시한 알고리즘을 실제로 구현
        --> kr.study.WalkingStrategy, kr.study.FlyingStrategy, kr.study.PunchStrategy, kr.study.MissileStrategy
    - Context : 스트래티지 패턴을 이용하는 역할을 수행 필요에 따라 동적으로 구체적인 전략을 바꿀 수 있도록 setter 메서드를 제공
        --> kr.study.Robot, kr.study.Atom, kr.study.TaekwonV

    ex) 쿠키런 : episode / 쿠키 / 보석 별로 다른 게임이 되어야 하니까 if/else의 향연이 아닌 ? 스트래티지 패턴으로 적용시킬 수 있을듯
     */
    public static void main(String[] args) {
        Robot taekwonV = new TaekwonV("kr.study.TaekwonV");
        Robot atom = new Atom("kr.study.Atom");

        taekwonV.setMovingStrategy(new WalkingStrategy());
        taekwonV.setAttackStrategy(new MissileStrategy());

        atom.setMovingStrategy(new FlyingStrategy());
        atom.setAttackStrategy(new PunchStrategy());

        System.out.println("My name is " + taekwonV.getName());
        taekwonV.move();
        taekwonV.attack();

        System.out.println();

        System.out.println("My name is " + atom.getName());
        atom.move();
        atom.attack();

        System.out.println();

        Ball ball1 = new Ball("Ball1");
        Ball ball2 = new Ball("Ball2");

        ball1.setMoveStrategy(new MoveDialonal());
        ball1.setColorStrategy(new ColorRed());
        ball1.move();
        ball1.color();

        ball2.setMoveStrategy(new MoveUpDown());
        ball2.setColorStrategy(new ColorBlue());
        ball2.move();
        ball2.color();

    }
}
