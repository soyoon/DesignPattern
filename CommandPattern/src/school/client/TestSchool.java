package school.client;
import school.*;			import school.view.*;			import school.net.*;
public class TestSchool {
	public static void main(String[] args) {
		SchoolMgrClient model = new SchoolMgrClient(new NetClient("172.31.0.82"));
		new SchoolView(model);
	}
}
