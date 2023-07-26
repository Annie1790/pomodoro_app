package pomodoro_app.Buttons;

import java.awt.Dimension;
import javax.swing.JButton;

import pomodoro_app.Chrono.CountdownTimer;

public class StopButton extends JButton {
    CountdownTimer timer;

    public StopButton(CountdownTimer timer) {
        this.timer = timer;
        this.setText("Stop");
        this.setPreferredSize(new Dimension(100, 50));
        this.setEnabled(false);
        this.timer.stop();
    }

}
