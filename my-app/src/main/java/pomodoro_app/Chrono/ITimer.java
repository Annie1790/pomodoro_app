package pomodoro_app.Chrono;

public interface ITimer {

    public void stop();

    public void start();
    
    public void reset(int seconds);

    public int getDuration();

}
