package eluis.tk.interfaces.services;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnectionService {
    void Connect() throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException;

    void Disconnect() throws SQLException;

    Connection GetConnection();
}
