package school.net;
import school.*;						import school.model.*;
public class FindByAddressCommand extends Command {
	private String address;
	public FindByAddressCommand(){}
	public FindByAddressCommand(String address){	this.address = address;}
	public void execute(SchoolMgr model) {
		 setResult(model.findByAddress(address));
	}
}
