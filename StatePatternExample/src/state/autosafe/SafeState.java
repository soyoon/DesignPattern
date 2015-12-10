package state.autosafe;

/**
 * Created by soyoon on 2015. 12. 9..
 */
public interface SafeState {
    public void doAlarm(Context context);
    public void doClock(Context context, int time);
    public void doPhone(Context context);
    public void doUse(Context context);
}
