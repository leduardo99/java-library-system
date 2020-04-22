package eluis.tk.interfaces.controllers;

import java.sql.SQLException;
import java.util.List;

public interface IControllerBase<T> {
    T Get(int id) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException;

    List<T> GetAll() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException;

    void Add(T entity) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException;

    void Update(T entity) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException;

    void Delete(int id) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
}
