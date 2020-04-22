package eluis.tk.dao;

import eluis.tk.interfaces.dao.IDAOBase;
import eluis.tk.interfaces.services.IConnectionService;
import eluis.tk.services.ConnectionService;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class BaseDao<T> implements IDAOBase<T> {
    public IConnectionService connectionService = new ConnectionService();

    void Connect() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        connectionService.Connect();
    }

    void Disconnect() throws SQLException {
        connectionService.Disconnect();
    }

    Connection GetConnection() {
        return connectionService.GetConnection();
    }
}
