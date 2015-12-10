package school;
import school.model.*;
import school.view.*;
public class TestSchool {
	public static void main(String[] args) {
		SchoolMgrFileIO  model = new SchoolMgrFileIO();
		SchoolView view = new SchoolView(model);
	}
}
