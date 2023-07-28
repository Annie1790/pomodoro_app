package pomodoro_app.Buttons;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import pomodoro_app.Chrono.CountdownTimer;

public class StartButton extends JButton implements ActionListener {

    private CountdownTimer timer;

    public StartButton(CountdownTimer timer) {
        this.setText("Start");
        this.timer = timer;
        this.addActionListener((ActionListener) this);
        this.setPreferredSize(new Dimension(100, 50));
    };

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (this.getText() == "Start") {
            this.timer.start();
            this.setText("Pause");
        } else if (this.getText() == "Pause") {
            this.timer.stop();
            this.setText("Start");
        }
    }

}
