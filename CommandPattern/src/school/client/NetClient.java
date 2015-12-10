package school.client;
import java.io.*;			import java.net.*;	import school.*;
/**서버와 통신하는 클래스로 send기능과 receive기능이 있는 클래스  */
public class NetClient {
	Socket socket;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	String host; //연결될 서버의 주소
	public NetClient(){this("localhost");}
	public NetClient(String host){
		this.host = host;
		connect(host);  //서버와 연결
	}
	/**서버에 객체를 전송해주는 메서드  */
	public void send(Object o) throws Exception{
		int retry=10;   //접속 error가 발생시 다시 서버에 전송 시도 횟수
		while(retry>0){
			try {
				oos.writeObject(o);
				retry =0;
			} catch (Exception e) {
				retry--;
				if(retry==0) throw  e;
				try{Thread.sleep(500);}catch(Exception e1){}
				connect(host);  //오류에 의해 연결이 끊겨졌으면 다시 연결해서 전송
			}
		}
	}

	/**서버로 부터 객체를 전송받는 메서드 */
	public Command receive() throws Exception {
		Command result = null;
		try {
			Object obj = ois.readObject();
			if(obj instanceof Command)
				result = (Command)obj;
		} catch (Exception e) {
			connect(host); //오류에 의해 소켓 연결이 끊겼다면 다시 연결
			throw e;
		}
		return result;
	}

	/**인자로 받은 특정 host로 연결해주는 메서드  */
	public void connect(String host){
		try {
			/*소켓이 생성이 되지 않았거나 또는 소켓이 생성은 됐지만 오류에 의해
			 * 연결이 끊어졌을때 다시 연결 */
			if(socket==null || !socket.getKeepAlive()){
				socket = new Socket(host,5555);
				oos = new ObjectOutputStream(socket.getOutputStream());
				ois = new ObjectInputStream(socket.getInputStream());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}



