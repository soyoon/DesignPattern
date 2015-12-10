package school;
import java.io.*;
public abstract class Command implements Serializable {
	private Object result;
	public abstract void  execute(SchoolMgr model);
	public Object getResult() {		return result;	}
	public void setResult(Object result) {		this.result = result;	}
}
