package com.pattern.state.document;

/**
 * Created by soyoon on 2015. 12. 9..
 */
public class Main {
    public static void main(String[] args) {
        Document doc = new Document();

        doc.open();
        doc.edit("hello");
        doc.open();
        doc.save();
        doc.close();
        doc.open();
    }
}
