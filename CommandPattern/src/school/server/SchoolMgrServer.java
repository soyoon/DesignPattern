package school.server;
import java.io.*;			import java.net.*;	 	import school.*;
/**SchoolMgrClient와 통신하여 클라이언트의 요청을 받아
 * SchoolMgr를 구현한 SchoolMgrFileIO를 실행할 클래스 */
public class SchoolMgrServer extends Thread {
	private Socket socket;
	private SchoolMgr model;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	public SchoolMgrServer(){}
	public SchoolMgrServer(Socket socket, SchoolMgr model){
		this.socket = socket;
		this.model = model;
	}
	/**클라이언트와 통신하도록 구현 */
	public void run(){
		try {
			//클라이언트와 통신할 수 있는 stream생성
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			while(true){   //클라이언트가 연결을 끊기 전까지 통신
				try{
					Command com = (Command)ois.readObject();
					com.execute(model);
					System.out.println(socket.getInetAddress()+"의 요청 "+com);
					oos.writeObject(com);
				}catch(Exception e){
					e.printStackTrace();
					try{ //클라이언트와 연결이 유지 되었는가?
						if(!socket.getKeepAlive()){
							close();//클라이언트와 연결이 유지 되지 않으면 소켓 close하기
							break;
						}
					}catch(Exception e1){}
				}
			}
		} catch (Exception e) {	}
	}
	public void close(){
		if(ois!=null)try{ois.close();}catch(Exception e){}
		if(oos!=null)try{oos.close();}catch(Exception e){}
		if(socket!=null)try{socket.close();}catch(Exception e){}
	}
}





