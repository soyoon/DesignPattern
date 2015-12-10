package com.pattern.state.document;

/**
 * Created by soyoon on 2015. 12. 9..
 */
public class Document {
    private static State state = CleanState.getInstance();
    private StringBuilder text;

    public Document() {
        this.text = new StringBuilder(100);
    }

    public static void setState(State s) {
        state = s;
    }

    public void open() {
        state.open();
    }

    public void close() {
        state.close();
    }

    public void edit(String text) {
        this.text.append(text);
        state.edit(text);
    }

    public void save() {
        state.save();
    }
}
