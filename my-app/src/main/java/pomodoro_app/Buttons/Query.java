package pomodoro_app.Buttons;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JButton;

import pomodoro_app.Database.Database;

public class Query extends JButton implements ActionListener {
    private Database database;

    public Query(Database database) {
        this.database = database;
        this.addActionListener((ActionListener) this);
        this.setText("Query current data");
        this.setPreferredSize(new Dimension(150, 50));
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        try {
            this.database.query();
        } catch (SQLException | ParseException e) {
            System.out.println(e);
        }
    }

}
