package school.net;
import school.*;						import school.model.*;
public class FindByNoCommand extends Command {
	private String no;
	public FindByNoCommand(){}
	public FindByNoCommand(String no){	this.no = no;}
	public void execute(SchoolMgr model) {
		try {
			setResult(model.findByNo(no));
		} catch (Exception e) {
			setResult(e);
		}
	}
}
