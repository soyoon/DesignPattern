package com.pattern.command.ver3;

/**
 * Created by soyoon on 2015. 12. 9..
 */
public class LampOnCommand implements Command {
    @Override
    public void execute(Object o) {
        if (o instanceof Lamp) {
            Lamp lamp = (Lamp) o;
            lamp.turnOn();
        }
    }
}
