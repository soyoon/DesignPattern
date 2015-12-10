package com.pattern.state.document;

/**
 * Created by soyoon on 2015. 12. 9..
 */
public class DirtyState implements State {
    private static DirtyState instance;
    private DirtyState() {
    }

    public static DirtyState getInstance() {
        synchronized (DirtyState.class) {
            if(instance == null) {
                instance = new DirtyState();
            }
        }
        return instance;
    }

    @Override
    public void open() {
        System.out.println("수정 사항이 있습니다. 저장하시겠습니까");
        System.out.println("새로운 문서 열기");
    }

    @Override
    public void close() {
        System.out.println("수정 사항이 있습니다 저장하시겠습니까");
        System.out.println("문서 닫기");
    }

    @Override
    public void save() {
        System.out.println("저장합니다");
        Document.setState(CleanState.getInstance());
    }

    @Override
    public void edit(String text) {
    }
}
