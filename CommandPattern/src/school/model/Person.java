package school.model;
import java.io.*;
public class  Person implements Serializable
{
	private String no, name, address, tel;
	private int age;
	public Person(){}
	public Person(String no, String name,int age, String address, String tel){
		this.no = no;				this.name = name;		   this.age = age;
		this.address = address;	this.tel = tel;
	}
	public String toString(){
		return "no :"+no+" "+name+" - "+age+"세,"+address+","+tel;
	}
	public boolean equals(Object o){
		boolean result = false;
		if(o !=null){
			if(o instanceof Person){
				Person p = (Person)o;
				if(no.equals(p.no)) result = true;
			}
		}
		return result;
	}
	public void setNo(String no){  this.no = no;}
	public void setName(String name){  this.name = name;}
	public void setAddress(String address){  this.address = address;}
	public void setTel(String tel){  this.tel = tel;}
	public void setAge(int age){  this.age = age;}
	public String getNo(){ return no;}
	public String getName(){ return name;}
	public String getAddress(){ return address;}
	public String getTel(){ return tel;}
	public int getAge(){ return age;}
}


