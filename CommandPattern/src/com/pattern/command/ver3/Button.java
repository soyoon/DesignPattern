package com.pattern.command.ver3;

import com.pattern.command.ver1.Lamp;

public class Button {
	private Command command;
	public Button(Command command) {
		this.command = command ;
	}
	public void pressed(Object o) {
		command.execute(o); ;
	}

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}
}
