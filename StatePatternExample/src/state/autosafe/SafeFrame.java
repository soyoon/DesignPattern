package state.autosafe;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Color;
import java.awt.Button;
import java.awt.TextField;
import java.awt.TextArea;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SafeFrame extends Frame implements ActionListener, Context {
    private TextField textClock = new TextField(60);        // 현재시각 표시
    private TextArea textScreen = new TextArea(10, 60);     // 경비센터 출력
    private Button buttonUse = new Button("금고사용");      // 금고사용 버튼
    private Button buttonAlarm = new Button("비상벨");    // 비상벨 버튼
    private Button buttonPhone = new Button("일반 통화");    // 일반 통화 버튼
    private Button buttonExit = new Button("종료");         // 종료 버튼

    private SafeState state = DayState.getInstance();           // 현재의 상태

    // 생성자
    public SafeFrame(String title) {
        super(title);
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());
        // textClock을 배치
        add(textClock, BorderLayout.NORTH);
        textClock.setEditable(false);
        // textScreen을 배치
        add(textScreen, BorderLayout.CENTER);
        textScreen.setEditable(false);
        // 패널에 버튼을 보관
        Panel panel = new Panel();
        panel.add(buttonUse);
        panel.add(buttonAlarm);
        panel.add(buttonPhone);
        panel.add(buttonExit);
        // 그 패널을 배치
        add(panel, BorderLayout.SOUTH);
        // 표시
        pack();
        show();
        // 리스너의 설정
        buttonUse.addActionListener(this);
        buttonAlarm.addActionListener(this);
        buttonPhone.addActionListener(this);
        buttonExit.addActionListener(this);
    }
    // 버튼이 눌러지면 여기로 온다.
    public void actionPerformed(ActionEvent e) {
        System.out.println("" + e);
        if (e.getSource() == buttonUse) {           // 금고사용 버튼
            state.doUse(this);
        } else if (e.getSource() == buttonAlarm) {  // 비상벨 버튼
            state.doAlarm(this);
        } else if (e.getSource() == buttonPhone) {  // 일반 통화 버튼
            state.doPhone(this);
        } else if (e.getSource() == buttonExit) {   // 종료 버튼
            System.exit(0);
        } else {
            System.out.println("?");
        }
    }
    // 시각의 설정
    public void setClock(int hour) {
        String clockstring = "현재 시각은";
        if (hour < 10) {
            clockstring += "0" + hour + ":00";
        } else {
            clockstring += hour + ":00";
        }
        System.out.println(clockstring);
        textClock.setText(clockstring);
        state.doClock(this, hour);
    }
    // 상태변화
    public void changeState(SafeState state) {
        System.out.println(this.state + "에서" + state + "로 상태가 변화했습니다.");
        this.state = state;
    }
    // 경비센터 호출
    public void callSecurityCenter(String msg) {
        textScreen.append("call! " + state + msg + "\n");
    }
    // 경비센터 기록
    public void recordLog(String msg) {
        textScreen.append("record ... " + state + msg + "\n");
    }

    @Override
    public void connectCalling() {
    }
}
