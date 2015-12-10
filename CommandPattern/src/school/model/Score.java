package school.model;
import java.io.*;

public class  Score implements Serializable{
	private String term;
	private double totalavg;
	public Score(){}
	public Score(String term,double totalavg){
		this.term = term;
		this.totalavg = totalavg;
	}
	public String toString(){ 	 return "학기 :"+term+" 학점:"+totalavg;	}
	public void setTerm(String term){this.term = term;}
	public void setTotalavg(double total){totalavg = total;}
	public String getTerm(){return term;}
	public double getTotalavg(){return totalavg;}
}
