package school;
import java.util.*;
import school.model.*;
public interface SchoolMgr {
	public boolean addPerson(Person person)throws DuplicateException, NoSpaceException;
	public ArrayList<Person> findByTel(String tel) throws ObjectNotFoundException;
	public ArrayList<Person> findByAddress(String address);
	public Person findByNo(String no) throws ObjectNotFoundException;
	public ArrayList<Person> show();
	public boolean removePerson(Person person) throws RemoveException;
}
