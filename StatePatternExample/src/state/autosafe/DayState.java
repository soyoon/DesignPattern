package state.autosafe;

/**
 * Created by soyoon on 2015. 12. 9..
 */
public class DayState implements SafeState {

    private static DayState instance;
    private DayState(){}
    public static DayState getInstance() {
        synchronized (DayState.class) {
            if(instance == null) {
                instance = new DayState();
            }
        }
        return instance;
    }

    public String toString() {
        return "[주간]";
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨 울림");
    }

    @Override
    public void doClock(Context context, int time) {
        if(time<9 || time>18) {
            context.changeState(NightState.getInstance());
        }
    }

    @Override
    public void doPhone(Context context) {
        context.connectCalling();
    }

    @Override
    public void doUse(Context context) {
        context.recordLog("금고 사용");
    }
}
