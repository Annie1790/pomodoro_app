package pomodoro_app.Stats;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import pomodoro_app.Database.Database;
import pomodoro_app.Database.DateUtils;

public class StatGui extends JPanel implements ActionListener {
    // panels
    private final JPanel chronoButtons;
    private final JPanel queryPanel;
    private final JPanel allTimePanel;

    // buttons for query data
    private final JButton today;
    private final JButton week;
    private final JButton month;

    // fields for data entry
    private JTextArea queryText;
    private JTextArea queryTime;

    private JTextArea allText;
    private JTextArea allTime;
    private Database database;

    public StatGui(Database database) throws SQLException, ParseException {
        this.database = database;

        today = new JButton("day");
        week = new JButton("week");
        month = new JButton("month");

        queryText = new JTextArea("Query time:");
        queryTime = new JTextArea("h");

        allText = new JTextArea("All time:");
        allTime = new JTextArea(this.database.getAllTime() + "h");

        chronoButtons = new JPanel();
        chronoButtons.add(today);
        chronoButtons.add(week);
        chronoButtons.add(month);

        queryPanel = new JPanel();
        queryPanel.add(queryText);
        queryPanel.add(queryTime);

        allTimePanel = new JPanel();
        allTimePanel.add(allText);
        allTimePanel.add(allTime);

        // adding to JPanel and set layout
        this.add(chronoButtons);
        this.add(queryPanel);
        this.add(allTimePanel);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(new Insets(100, 50, 100, 50)));

        // adding action listeners to buttons
        today.addActionListener(this);
        week.addActionListener(this);
        month.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == today) {
            try {
                queryTime.setText(this.database.getSelectedTime(new DateUtils().getToday()));
            } catch (SQLException | ParseException e) {
                System.out.println("Error on today time query: \n" + e);
            }
        } else if (event.getSource() == week) {
            try {
                queryTime.setText(this.database.getSelectedTime(new DateUtils().getWeek()));
            } catch (SQLException | ParseException e) {
                System.out.println("Error on this week time query: \n" + e);

            }
        } else if (event.getSource() == month) {
            try {
                queryTime.setText(this.database.getSelectedTime(new DateUtils().getMonth()));
            } catch (SQLException | ParseException e) {
                System.out.println("Error on this month time query: \n" + e);

            }
        } else {
            System.out.println("Throw some exception");
        }
    }
}
