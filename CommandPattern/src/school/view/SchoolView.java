package school.view;
import java.awt.*;			import javax.swing.*;		import javax.swing.table.*;
import java.awt.event.*;	import school.*;				import school.model.*;
import java.util.*;
public class SchoolView {
	JFrame frame;
	JButton addP, removeP,findP,findTelP, findAddP,show;
	JTextField[]  fields;
	String[] labels={"번호","이름","나이","주소","전화번호"};
	JLabel[] label ;
	JPanel   left,right, ltop,lmain, lbottom, info, log;
	JLabel   rightLabel, logLabel,logTop;//오른쪽에 테이블 위 Label
	DefaultTableModel  tableModel;
	JTable table;
	JScrollPane tablePane;
	SchoolMgr model;
	ActionListener addHandler = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			Person  person = new Person();
			person.setNo(fields[0].getText());
			person.setName(fields[1].getText());
			String ages = fields[2].getText();
			int age = ages==null?0:Integer.parseInt(ages);
			person.setAge(age);
			person.setAddress(fields[3].getText());
			person.setTel(fields[4].getText());
			try {
				model.addPerson(person);
				logLabel.setText(person+"\n정보를 저장하였습니다");
				for(int i=0; i<fields.length; i++)fields[i].setText("");
				show();
			} catch (Exception e2) {
				logLabel.setText(person+"을 저장하는데 실패했습니다.\n"+e2.getMessage());
			}
		}
	};
	ActionListener removeHandler = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String no = fields[0].getText();
			Person person = new Person();
			person.setNo(no);
			try {
				model.removePerson(person);
				logLabel.setText(no+"\n삭제하였습니다.");
				fields[0].setText("");
				show();
			} catch (Exception e2) {
				logLabel.setText(no+"을 삭제하는데 실패했습니다.\n"+e2.getMessage());
			}
		}
	};
	ActionListener showHandler = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			show();
		}
	};
	ActionListener findPHandler = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String no = fields[0].getText();
			try {
				Person person = model.findByNo(no);
				fields[1].setText(person.getName());
				fields[2].setText(""+person.getAge());
				fields[3].setText(person.getAddress());
				fields[4].setText(person.getTel());
			} catch (Exception e2) {
				logLabel.setText(no+"\n 정보를 load하지못했습니다.\n"+e2.getMessage());
			}
		}
	};
	ActionListener findTHandler = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String tel = fields[4].getText();
			try {
				ArrayList<Person> list = model.findByTel(tel);
				show(list);
			} catch (Exception e2) {
				logLabel.setText(tel+"\n해당하는 정보로딩실패\n"+e2.getMessage());
			}
		}
	};
	ActionListener findAddressHandler = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String address = fields[3].getText();
			try {
				ArrayList<Person> list = model.findByAddress(address);
				show(list);
			} catch (Exception e2) {
				logLabel.setText(address+"\n해당하는 정보로딩실패\n"+e2.getMessage());
			}
		}
	};
	public void show(){
		ArrayList<Person> list = model.show();
		show(list);
	}
	/**ArrayList들어온 Person정보를 tableModel에 setting하는 메서드  */
	public void show(ArrayList<Person> list){
		String[][] data = new String[list.size()][5];
		int i=0;
		for (Person person : list) {
			data[i][0] = person.getNo();
			data[i][1] = person.getName();
			data[i][2] = ""+person.getAge();
			data[i][3] = person.getAddress();
			data[i++][4] = person.getTel();
		}
		tableModel.setDataVector(data, labels);
	}
	public void setLeftTop(){
		ltop = new JPanel(new GridLayout(1,4));
		findP = new JButton("FindByNo");
		findTelP = new JButton("FindByTel");
		findAddP = new JButton("FindByAddress");
		show =  new JButton("list");
		ltop.add(findP);	ltop.add(findTelP);	ltop.add(findAddP);	ltop.add(show);

		findP.addActionListener(findPHandler);
		findTelP.addActionListener(findTHandler);
		findAddP.addActionListener(findAddressHandler);
		show.addActionListener(showHandler);
	}
	public void setLeftMain(){
		log = new JPanel(new BorderLayout());
		logTop = new JLabel("log", SwingConstants.CENTER);
		logLabel  = new JLabel("");
		logLabel.setSize(30,100);
		log.add(logTop,"North");
		log.add(logLabel,"Center");
		info =  new JPanel(new GridLayout(5,2));
		label = new JLabel[labels.length];
		fields = new JTextField[labels.length];
		for (int i = 0; i < labels.length; i++) {
			label[i] = new JLabel(labels[i], SwingConstants.CENTER);
			fields[i] = new JTextField(10);
			info.add(label[i]);
			info.add(fields[i]);
		}
		lmain = new JPanel(new GridLayout(1,2));
		lmain.add(info);		lmain.add(log);
	}
	public void setLeftBottom(){
		lbottom = new JPanel();
		addP = new JButton("추가");
		removeP = new JButton("삭제");
		lbottom.add(addP);
		lbottom.add(removeP);
		addP.addActionListener(addHandler);
		removeP.addActionListener(removeHandler);
	}
	public void setRight(){
		right = new JPanel(new BorderLayout());
		rightLabel = new JLabel("리스트", SwingConstants.CENTER);
		tableModel = new DefaultTableModel(labels,10);
		table =new  JTable(tableModel);
		tablePane = new JScrollPane(table);
		right.add(rightLabel,"North");
		right.add(tablePane,"Center");
	}
	public SchoolView(){   this(null); }
	public SchoolView(SchoolMgr model){
		this.model =model;
		setLeftTop();
		setLeftMain();
		setLeftBottom();
		setRight();
		left = new JPanel(new BorderLayout());
		left.add(ltop,"North");
		left.add(lmain,"Center");
		left.add(lbottom,"South");

		frame = new JFrame("Person Management");
		frame.setLayout(new GridLayout(1,2));
		Container con = frame.getContentPane();
		con.add(left);
		con.add(right);
		show();
		frame.setSize(800,200);
		frame.setVisible(true);
	}
	public static void main(String[] args) {new  SchoolView();	}
}





