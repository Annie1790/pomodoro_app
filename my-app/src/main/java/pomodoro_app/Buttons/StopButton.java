package pomodoro_app.Buttons;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import pomodoro_app.Chrono.ITimer;
import pomodoro_app.Database.Database;

public class StopButton extends JButton implements ActionListener {
    private ITimer timer;
    private Database database;

    public StopButton(ITimer timer, Database database) {
        this.timer = timer;
        this.database = database;
        this.addActionListener((ActionListener) this);
        this.setText("Stop");
        this.setPreferredSize(new Dimension(100, 50));
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        try {
            this.database.insert(this.timer.getDuration());
            this.timer.reset(1500);
            this.timer.stop();
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }

}
