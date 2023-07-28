package pomodoro_app.Buttons;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import pomodoro_app.Chrono.CountdownTimer;

public class StopButton extends JButton implements ActionListener {
    CountdownTimer timer;

    public StopButton(CountdownTimer timer) {
        this.timer = timer;
        this.setText("Stop");
        this.setPreferredSize(new Dimension(100, 50));
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        this.timer.reset();
    }

}
