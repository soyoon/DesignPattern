package school.net;
import school.*;						import school.model.*;
public class FindByTelCommand extends Command {
	private String tel;
	public FindByTelCommand(){}
	public FindByTelCommand(String tel){	this.tel = tel;}
	public void execute(SchoolMgr model) {
		try {   setResult(model.findByTel(tel));	} catch (Exception e) {	setResult(e);	}
	}
}
