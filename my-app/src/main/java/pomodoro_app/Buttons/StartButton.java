package pomodoro_app.Buttons;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class StartButton extends JButton implements ActionListener {

    Boolean startTimerBoolean;

    public StartButton() {
        this.setText("Start");
        this.addActionListener((ActionListener) this);
        this.setPreferredSize(new Dimension(100, 100));
        startTimerBoolean = false;
    };

    public void setTimerButtonText() {
        if (startTimerBoolean == false) {
            this.setText("Start");
        } else {
            this.setText("Stop");
        }
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        startTimerBoolean = !startTimerBoolean;
        this.setTimerButtonText();
    }

}
