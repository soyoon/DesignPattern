package school.net;
import school.*;						import school.model.*;
public class AddPersonCommand extends Command {
	private Person person;
	public AddPersonCommand(){}
	public AddPersonCommand(Person person){	this.person = person;}
	public void execute(SchoolMgr model) {
		try {  
			setResult(new Boolean(model.addPerson(person)));	
		} catch (Exception e) {	setResult(e);	}
	}
}
