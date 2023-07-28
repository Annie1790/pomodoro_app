package pomodoro_app.Buttons;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import pomodoro_app.Chrono.CountdownTimer;

public class StartButton extends JButton implements ActionListener {

    private Boolean startTimerBoolean;
    private CountdownTimer timer;

    public StartButton(CountdownTimer timer) {
        this.setText("Start");
        this.timer = timer;
        this.addActionListener((ActionListener) this);
        this.setPreferredSize(new Dimension(100, 50));
        startTimerBoolean = false;
    };

    public void setTimerButtonText() {
        if (startTimerBoolean == false) {
            this.setText("Start");
        } else {
            this.setText("Pause");
        }
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        System.out.println(startTimerBoolean);
        startTimerBoolean = !startTimerBoolean;
        if (startTimerBoolean == true) {
            this.timer.start();
        } else {
            this.timer.stop();
        }
        this.setTimerButtonText();
    }

}
