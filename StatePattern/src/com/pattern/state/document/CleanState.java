package com.pattern.state.document;

/**
 * Created by soyoon on 2015. 12. 9..
 */
public class CleanState implements State {
    private static CleanState instance;
    private CleanState() {
    }

    public static CleanState getInstance() {
        synchronized (CleanState.class) {
            if(instance == null) {
                instance = new CleanState();
            }
        }
        return instance;
    }

    @Override
    public void open() {
        System.out.println("새로운 문서 열기");
    }

    @Override
    public void close() {
        System.out.println("문서 닫기");
    }

    @Override
    public void save() {}

    @Override
    public void edit(String text) {
        Document.setState(DirtyState.getInstance());
    }
}
