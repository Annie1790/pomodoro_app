//build: mvn package
//run:  java -cp target/my-app-1.0-SNAPSHOT.jar pomodoro_app.App

package pomodoro_app;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App implements ActionListener {

    JFrame frameObj;

    JPanel panel1;
    JPanel panel2;
    JPanel panel3;

    JButton navBarTimer;
    JButton navBarStats;
    JButton startTimer;

    JLabel timer;

    Boolean startTimerBoolean;

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

        Icon icon = new ImageIcon("/play_circle.png", "play button");

        startTimer = new JButton(icon);
        startTimer.setText("Start");
        startTimer.addActionListener(this);
        startTimer.setPreferredSize(new Dimension(100, 100));
        startTimerBoolean = false;

        panel1.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
        panel1.add(navBarTimer);
        panel1.add(navBarStats);

        panel2.add(startTimer);

        frameObj.setLayout(new java.awt.GridLayout(3, 1));
        frameObj.setSize(300, 600);
        frameObj.pack();
        frameObj.setVisible(true);
        frameObj.setTitle("Pomodoro App by Annie");
        frameObj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    };

    public void setTimerButtonText() {
        if (startTimerBoolean == false) {
            this.startTimer.setText("Start");
        } else {
            this.startTimer.setText("Stop");
        }
    }

    public static void main(String[] args) {
        new App();
    };

    @Override
    public void actionPerformed(ActionEvent arg0) {
        startTimerBoolean = !startTimerBoolean;
        this.setTimerButtonText();
    }
};
