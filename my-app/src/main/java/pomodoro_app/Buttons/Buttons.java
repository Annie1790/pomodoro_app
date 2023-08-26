package pomodoro_app.Buttons;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pomodoro_app.Chrono.ITimer;
import pomodoro_app.Database.Database;

public class Buttons extends JPanel implements ActionListener {
    private StopButton stop;
    private StartButton start;

    public Buttons(ITimer timer, Database database) {
        stop = new StopButton(timer, database);
        start = new StartButton(timer);

        stop.setEnabled(false);

        JPanel utilityCont = new JPanel();
        utilityCont.add(start);
        utilityCont.add(stop);

        this.add(utilityCont);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(new Insets(100, 50, 100, 50)));

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
