package school.server;
import java.net.*;		   import school.model.*;
public class SchoolNetServer {
	public static void main(String[] args) {
		ServerSocket  ss = null;
		try {
			ss = new ServerSocket(5555);
			System.out.println("SchoolNetServer Running......");
			while(true){
				Socket s = null;
				s = ss.accept();
				System.err.println(s.getInetAddress()+"클라이언트 접속");
				SchoolMgrFileIO model = new SchoolMgrFileIO();
				new SchoolMgrServer(s,model).start();
			}
		} catch (Exception e) {
		}finally{
			if(ss!=null)try{ss.close();}catch(Exception e){}
		}
	}
}
