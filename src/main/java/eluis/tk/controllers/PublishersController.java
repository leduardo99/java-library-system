package eluis.tk.controllers;

import eluis.tk.dao.PublishersDao;
import eluis.tk.models.Publishers;

import java.sql.SQLException;
import java.util.List;

public class PublishersController extends ControllerBase<Publishers> {
    PublishersDao publishersDao = new PublishersDao();

    @Override
    public Publishers Get(int id) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        return publishersDao.Get(id);
    }

    @Override
    public List<Publishers> GetAll() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        return publishersDao.GetAll();
    }

    @Override
    public void Add(Publishers books) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        publishersDao.Add(books);
    }

    @Override
    public void Update(Publishers books) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        publishersDao.Update(books);
    }

    @Override
    public void Delete(int id) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        publishersDao.Delete(id);
    }
}
