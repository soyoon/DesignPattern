package com.pattern.observer.stock;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

//1.implements Observer 
public class ObserverView implements Observer {
	private Frame main;
	private TextArea area;
	private Button button;

	public ObserverView(Stock stock) {
		// 3. Observable한테 등록
		stock.addObserver(this);

		main = new Frame("Test");
		area = new TextArea(10, 40);
		button = new Button("지우기");
		main.add(area);
		main.add(button, "South");
		main.pack();
		main.setVisible(true);

		main.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				area.setText("");
			}
		});
	}

	// 2. notify되었을때 수행할 내용
	public void update(Observable thing, Object arg) {
		Stock stock = (Stock) thing;
		area.append("The price of " + stock.getName() + " is now "
				+ stock.getPrice() + "\r\n");
	}
}