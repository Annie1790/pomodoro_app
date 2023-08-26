package pomodoro_app.Stats;

import java.awt.Insets;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import pomodoro_app.Database.Database;

public class StatGui extends JPanel {
    // Panels
    private final JPanel chronoButtons;
    private final JPanel queryPanel;
    private final JPanel allTimePanel;

    // Buttons for query data
    private final JButton today;
    private final JButton week;
    private final JButton month;

    // Fields for data entry
    private JTextArea queryText;
    private JTextArea queryTime;

    private JTextArea allText;
    private JTextArea allTime;

    public StatGui(Database database) throws SQLException, ParseException {
        today = new JButton("day");
        week = new JButton("week");
        month = new JButton("month");

        queryText = new JTextArea("Pomodoro:");
        queryTime = new JTextArea("2:00 h");

        allText = new JTextArea("All time:");
        allTime = new JTextArea(database.getAllTime() + "h");

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

        // Adding to JPanel and set layout
        this.add(chronoButtons);
        this.add(queryPanel);
        this.add(allTimePanel);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(new Insets(100, 50, 100, 50)));
    }
}
