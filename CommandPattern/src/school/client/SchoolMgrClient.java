package school.client;

import java.util.*;		import school.*;			import school.model.*;
import school.net.*;
public class SchoolMgrClient implements SchoolMgr {
	private NetClient net;    //서버와 통신 담당 하는 객체
	public SchoolMgrClient(NetClient net){ this.net = net;}

	/** 서버에 Person정보를 등록하도록 요청해주는 메서드  */
	public boolean addPerson(Person person) throws DuplicateException,	NoSpaceException {
		Command obj = null;
		try {
			AddPersonCommand add = new AddPersonCommand(person);
			net.send(add);
			obj = net.receive();
		} catch (Exception e) {   //네트웍 오류 발생
			return false;
		}
		Object resultObj = obj.getResult();
		/*결과가 Exception이라면 서버에 등록이 안됐기 때문에 Exception을
		 *해당 상황에 맞게 변경해서 전달
		 *결과가 Exception이 아니라면 서버에 잘 등록 됐음  */
		if (resultObj instanceof DuplicateException ) {
			throw new DuplicateException("이미 저장되어 있습니다");
		}else if(resultObj instanceof NoSpaceException ) {
			throw new NoSpaceException("더이상 저장할 수 없습니다.");
		}
		return true;  //Exception발생 하지 않았으므로 서버에 등록되었음.
	}

	@Override
	public ArrayList<Person> findByAddress(String address) {
		ArrayList<Person> list = null;
		try {
			FindByAddressCommand command = new FindByAddressCommand(address);
			net.send(command);
			Command com = net.receive();
			Object resultObj = com.getResult();
			if (resultObj instanceof ArrayList) list = (ArrayList<Person>) resultObj;
		} catch (Exception e) {		}
		return list;
	}
	@Override
	public Person findByNo(String no) throws ObjectNotFoundException {
		Person p = null;
		try {
			FindByNoCommand command = new FindByNoCommand(no);
			net.send(command);
			Command com = net.receive();
			Object resultObj = com.getResult();
			if (resultObj instanceof Person) 	p= (Person) resultObj;
			else if(resultObj instanceof Exception)
				throw (ObjectNotFoundException)resultObj; //no에 해당하는 사람이 없을때
		} catch (Exception e) {  //network 오류가 발생한것을 처리
			throw new ObjectNotFoundException(e.getMessage());
		}
		return p;
	}
	@Override
	public ArrayList<Person> findByTel(String tel)throws ObjectNotFoundException {
		ArrayList<Person> list = null;
		try {
			FindByTelCommand command = new FindByTelCommand(tel);
			net.send(command);
			Command com = net.receive();
			Object resultObj = com.getResult();
			if (resultObj instanceof ArrayList) list = (ArrayList<Person>) resultObj;
			else if(resultObj instanceof Exception)
				throw (ObjectNotFoundException)resultObj;
		} catch (Exception e) {
			throw new ObjectNotFoundException(e.getMessage());
		}
		return list;
	}

	@Override
	public boolean removePerson(Person person) throws RemoveException {
		try{
			RemovePersonCommand command = new RemovePersonCommand(person);
			net.send(command);
			Command com = net.receive();
			Object result = com.getResult();
			//결과값에 RemoveException만 담았기 때문에 RemoveException이 아니면
			//성공적으로 삭제 됨
			if (result instanceof RemoveException) throw (RemoveException)result;
		}catch (Exception e) {  //네트웍 오류
			throw new RemoveException(e.getMessage());
		}
		return true;
	}

	/** 서버에 등록된 모든 Person정보를 얻어오는 메서드  */
	public ArrayList<Person> show() {
		ArrayList<Person> list = new ArrayList<Person>();
		try {
			net.send(new ShowCommand());//서버에 Person 리스트를 요청
			Command o = net.receive();
			if (o instanceof ShowCommand) {
				ShowCommand show = (ShowCommand) o;
				Object resultObj = show.getResult();
				if (resultObj instanceof ArrayList) {
					list = (ArrayList) resultObj;
				}
			}
		} catch (Exception e) {e.printStackTrace();}
		System.out.println("show list..."+list);
		return list;
	}

}





