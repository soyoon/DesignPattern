package school.model;
import java.util.*;				import java.io.*;		import school.*;
public class SchoolMgrFileIO implements SchoolMgr {
	ArrayList<Person> list = new ArrayList<Person>();
	int index;
	public SchoolMgrFileIO(){
		try {
			list = load();
			System.out.println("[load...]");
			System.out.println(list);
		} catch (Exception e) {
			System.out.println("정보 loading error : "+e.getMessage());
		}
	}
	/**파일에 저장해주는 메서드
	 * 파일 저장시 오류가 발생하면 NoSapceException을 발생 시킨다.  */
	public boolean save() throws NoSpaceException{
		boolean result = false;
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("c:/school.txt"));
			oos.writeObject(list);
			result = true;
		} catch (Exception e) {
			throw new NoSpaceException("파일에 저장시 오류 발생 다시 작정하십시오");
		}finally{
			if(oos!=null)try{oos.close();}catch(Exception e){}
		}
		return result;
	}
	public ArrayList<Person> load() throws Exception{
		ArrayList<Person> list =null;
		/*처음 실행하면 c:/school.txt가 없으므로 오류가 발생하므로
		 *파일이 있는지 검사하기 위해 File객체 생성 */
		File file = new File("c:/school.txt");
		if(file.exists()){
			ObjectInputStream ois = null;
			try {
				ois = new ObjectInputStream(new FileInputStream("c:/school.txt"));
				Object o = ois.readObject();
				if (o instanceof ArrayList) 	list= (ArrayList<Person>) o;
			} catch (Exception e) {
				throw e;
			}finally{
				if(ois !=null)try{ois.close();}catch(Exception e){}
			}
		}else{
			list = new ArrayList<Person>();
		}
		return list;
	}

	public boolean addPerson(Person person) throws DuplicateException,NoSpaceException {
		if(person!=null){
			if(list.size()>=100)  throw new NoSpaceException("더이상 저장할 공간이 없습니다.");
			//person이 저장되어 있는지 확인
			/* int indexOf(Object o) : boolean equals(Object o)를 통해 같은 객체인지 검사하므로
			 * equals메서드를 오버라이드 하지 않으면 같은 내용의 객체를 찾지 못함  */
			int pindex = list.indexOf(person);
			if(pindex>=0) throw new DuplicateException(person+"은 이미 저장되었습니다.");
			list.add(person);
			/*추가후 이상이 없으면 파일에 저장 */
			save();
			return true;
		}
		return false;
	}
	public Person findByNo(String no) throws ObjectNotFoundException{
		Person p = new Person();
		p.setNo(no);
		int index = list.indexOf(p);
		if(index>=0) return list.get(index);
		else throw new ObjectNotFoundException(no+"해당하는 사람이 없습니다.");
	}
	public ArrayList<Person> findByAddress(String address) {
		ArrayList<Person> plist = new ArrayList<Person>();
		for (Person p : list) {  //주소가 같은 사람인지 검사
			if(address.equals(p.getAddress())) plist.add(p);
		}
		return plist;
	}
	public ArrayList<Person> findByTel(String tel)
			throws ObjectNotFoundException {
		ArrayList<Person> plist = new ArrayList<Person>();
		for (Person p : list) {  //주소가 같은 사람인지 검사
			if(tel.equals(p.getTel())) plist.add(p);
		}
		return plist;
	}
	public boolean removePerson(Person person) throws RemoveException {
		if(person !=null){
			int index = list.indexOf(person);
			if(index<0) throw new RemoveException(person+"을 삭제할 수 없습니다.");
			else {
				list.remove(index);
				try{
					save();//삭제후 이상이 없으면 파일에 저장
				}catch(Exception e){
					throw new RemoveException(person+"을 삭제할 수 없습니다.");
				}
			}
			return true;
		}
		return false;
	}

	public ArrayList<Person> show() {
		ArrayList<Person> clist = new ArrayList<Person>();
		for (Person p : list) {
			System.out.println(p);
			clist.add(p);
		}
		return clist;
	}
}




