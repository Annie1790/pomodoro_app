package pomodoro_app.Chrono;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class CountdownTimer extends JLabel implements ActionListener {

    private int remainingSec;

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

    public void reset(int seconds) {
        this.remainingSec = seconds;
        updateTime();
    }

    public int getDuration() {
        int duration = 1500 - this.remainingSec;
        return duration;
    }

    private void updateTime() {
        this.setText(formatSec(remainingSec));
        if (remainingSec <= 0) {
            timer.stop();
        }
    }

    private String formatSec(int seconds) {
        int h = seconds / 3600;
        int m = (seconds % 3600) / 60;
        int s = seconds % 60;
        if (h == 0) {
            if (s == 0) {
                String ss = "00";
                return String.format("%d:%s", m, ss);
            } else {
                return String.format("%d:%d", m, s);
            }
        } else {
            return String.format("%d:%d:%d", h, m, s);
        }

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        this.remainingSec -= 1;
        updateTime();
    }

}
