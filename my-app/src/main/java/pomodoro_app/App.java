//build: mvn package
//run:  java -cp target/my-app-1.0-SNAPSHOT.jar pomodoro_app.App

package pomodoro_app;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pomodoro_app.Buttons.Buttons;
import pomodoro_app.Chrono.CountdownTimer;

public class App extends JFrame {

    private JFrame frameObj;

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;

    private JButton navBarTimer;
    private JButton navBarStats;

    CountdownTimer cdTimer = new CountdownTimer(1500);

    public App() {
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();

        navBarTimer = new JButton("Timer");
        navBarStats = new JButton("Stats");

        frameObj = new JFrame();
        frameObj.add(panel1);
        frameObj.add(panel3);
        frameObj.add(panel2);

        panel1.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
        panel1.add(navBarTimer);
        panel1.add(navBarStats);

        panel2.add(new Buttons(cdTimer));

        panel3.add(cdTimer);

        frameObj.setLayout(new java.awt.GridLayout(3, 1));
        frameObj.setSize(300, 600);
        frameObj.pack();
        frameObj.setVisible(true);
        frameObj.setTitle("Pomodoro App by Annie");
        frameObj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    };

    public static void main(String[] args) {
        new App();
    };
};
