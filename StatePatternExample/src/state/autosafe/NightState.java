package state.autosafe;

/**
 * Created by soyoon on 2015. 12. 9..
 */
public class NightState implements SafeState {

    private static NightState instance;
    private NightState(){}
    public static NightState getInstance() {
        synchronized (NightState.class) {
            if(instance == null) {
                instance = new NightState();
            }
        }
        return instance;
    }

    public String toString() {
        return "[야간]";
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨 울림");
    }

    @Override
    public void doClock(Context context, int time) {
        if(time>=9 || time<=18) {
            context.changeState(DayState.getInstance());
        }
    }

    @Override
    public void doPhone(Context context) {
        context.recordLog("전화 연락");
    }

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("금고사용 비상!!");
    }
}
