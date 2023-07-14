package pomodoro_app.Chrono;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class CountdownTimer extends JLabel implements ActionListener {

    int remainingSec;

    Timer timer = new Timer(1000, this);

    public CountdownTimer(int seconds) {
        this.remainingSec = seconds;
        updateTime();
    }

    public void stop() {
        timer.stop();
    }

    public void start() {
        timer.start();
    }

    public void reset(int minutes) {
        this.remainingSec = minutes;
        updateTime();
    }

    private void updateTime() {
        this.setText(String.valueOf(remainingSec));
        if (remainingSec <= 0) {
            timer.stop();
        }
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        this.remainingSec -= 1;
        updateTime();
    }


}
