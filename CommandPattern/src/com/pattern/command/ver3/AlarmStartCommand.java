package com.pattern.command.ver3;

/**
 * Created by soyoon on 2015. 12. 9..
 */
public class AlarmStartCommand implements Command {
    @Override
    public void execute(Object o) {
        if (o instanceof Alarm) {
            Alarm alarm = (Alarm) o;
            alarm.start();
        }
    }
}
