package school.net;
import school.*;						import school.model.*;
public class RemovePersonCommand extends Command {
	private Person person;
	public RemovePersonCommand(){}
	public RemovePersonCommand(Person person){	this.person = person;}
	public void execute(SchoolMgr model) {
		try {   model.removePerson(person);	} catch (Exception e) {	setResult(e);	}
	}
}
