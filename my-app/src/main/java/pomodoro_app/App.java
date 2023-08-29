//build: mvn compile assembly:single
//run:  java -cp target/my-app-1.0-SNAPSHOT-jar-with-dependencies.jar pomodoro_app.App
package pomodoro_app;

import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import pomodoro_app.Buttons.TimerGui;
import pomodoro_app.Chrono.CountdownTimer;
import pomodoro_app.Database.Database;
import pomodoro_app.Stats.StatGui;

public class App extends JFrame {

    private final JFrame frameObj;

    private final JTabbedPane tabbedPanel;

    private final JPanel panel1;
    private final JPanel panel2;

    private Database db;

    CountdownTimer cdTimer = new CountdownTimer(1500);

    public App() throws SQLException, ParseException {

        db = new Database();
        panel1 = new JPanel();
        panel2 = new JPanel();
        frameObj = new JFrame();

        // timer tab
        panel1.add(cdTimer);
        panel1.add(new TimerGui(cdTimer, db));
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

        // stats tab
        panel2.add(new StatGui(db));

        // tab itself
        tabbedPanel = new JTabbedPane();
        tabbedPanel.addTab("Timer", panel1);
        tabbedPanel.addTab("Stats", panel2);

        // frame
        frameObj.add(tabbedPanel);
        frameObj.pack();
        frameObj.setVisible(true);
        frameObj.setTitle("Pomodoro App by Annie");

        frameObj.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                db.close();
                frameObj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }

    public static void main(String[] args) throws SQLException, ParseException {
        new App();
    };
};
