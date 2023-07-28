package pomodoro_app.Buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import pomodoro_app.Chrono.CountdownTimer;

public class Buttons extends JPanel implements ActionListener {
    public StopButton stop;
    public StartButton start;

    public Buttons(CountdownTimer timer) {
        stop = new StopButton(timer);
        start = new StartButton(timer);

        stop.setEnabled(false);

        this.add(start);
        this.add(stop);

        start.addActionListener(this);
        stop.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        //if start fired
        if (event.getSource() == start && start.getText() == "Start") {
            stop.setEnabled(true);
        } 
        //if stop fired
        else if (event.getSource() == stop) {
            stop.setEnabled(false);
            start.setText("Start");
        }
    }

}