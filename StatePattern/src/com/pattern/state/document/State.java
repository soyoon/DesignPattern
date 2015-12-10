package com.pattern.state.document;

/**
 * Created by soyoon on 2015. 12. 9..
 */
public interface State {
    public void open();
    public void close();
    public void save();
    public void edit(String text);
}
