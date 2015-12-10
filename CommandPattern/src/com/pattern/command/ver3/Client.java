package com.pattern.command.ver3;

public class Client {
	public static void main(String[] args) {
		Alarm alarm = new Alarm() ;
		Lamp lamp = new Lamp();

		Button alarmButton = new Button(new AlarmStartCommand()) ;
		alarmButton.pressed(alarm);
		alarmButton.setCommand(new LampOnCommand());
		alarmButton.pressed(lamp);
	}
}
