package eluis.tk.services;

import eluis.tk.interfaces.services.IConnectionService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService implements IConnectionService {
    public Connection connection;

    @Override
    public void Connect() throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {
        Class.forName("org.postgresql.Driver").newInstance();

        String url = "jdbc:postgresql://localhost/postgres";
        String username = "postgres";
        String password = "postgres";

        connection = DriverManager.getConnection(url, username, password);
    }

    @Override
    public void Disconnect() throws SQLException {
        this.connection.close();
    }

    @Override
    public Connection GetConnection() {
        return this.connection;
    }

}
