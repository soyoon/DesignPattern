package state.autosafe;

/**
 * Created by soyoon on 2015. 12. 9..
 */
public interface Context {
    public void callSecurityCenter(String msg);
    public void changeState(SafeState state);
    public void recordLog(String msg);
    public void setClock(int time);
    public void connectCalling();
}
