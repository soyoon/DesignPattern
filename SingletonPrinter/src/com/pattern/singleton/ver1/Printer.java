package com.pattern.singleton.ver1;

/**
 * Created by soyoon on 2015. 12. 8..
 */

/*
[Singleton Pattern]
어디서든 단 하나의 객체만 생성해서 사용할 때 쓰는 패턴

문제 : 유저가 동시 다발적으로 프린터를 사용한다면(멀티유저) ? -> User를 Thread로 바꿔서 테스트해보자
com.pattern.singleton.ver1.Printer@364c52c2 printer: 3- user is using...
com.pattern.singleton.ver1.Printer@364c52c2 printer: 2- user is using...
com.pattern.singleton.ver1.Printer@2e22470e printer: 0- user is using...
com.pattern.singleton.ver1.Printer@364c52c2 printer: 1- user is using...
com.pattern.singleton.ver1.Printer@364c52c2 printer: 4- user is using...
이렇게 다른 객체가 생성될 수 있다.

그래서 클래스를 동기화 시켜서 사용하면 해결할 수 있다 syncronized

static method와 singleton pattern과의 차이는 뭘까 static method 는 override가 안됨


 */
public class Printer {
    private static Printer instance;
    private Printer() {

    }
    public static Printer getInstance() {
        synchronized (Printer.class) { // 얘가 static method이기 때문에 synchronized(this) 안됨.
            if(instance == null) {
                try{Thread.sleep(1);}catch (Exception e){}
                instance = new Printer();
            }
        }
        return instance;
    }

    public void print(String msg, long time) {
        try{
            Thread.sleep(5000);
        }catch (Exception e) {}
        System.out.printf("%s printer: %s \n", this, msg);
        long endTime = System.currentTimeMillis();
        System.out.printf("print time : %d \n", endTime-time);

    }
}
