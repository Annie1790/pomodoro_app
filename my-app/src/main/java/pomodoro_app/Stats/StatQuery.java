package pomodoro_app.Stats;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import pomodoro_app.Database.Database;

public class StatQuery implements ActionListener {
    public Database database;

    public StatQuery(Database database) {
        this.database = database;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        try {
            this.database.query();
        } catch(SQLException | ParseException e) {
            System.out.println(e);
        }
    }

}
