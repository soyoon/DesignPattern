package school.net;
import school.*;						import school.model.*;
public class ShowCommand extends Command {
	public void execute(SchoolMgr model) {
		 setResult(model.show());
	}
}
