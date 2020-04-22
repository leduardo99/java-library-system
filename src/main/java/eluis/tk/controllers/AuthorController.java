package eluis.tk.controllers;

import eluis.tk.dao.AuthorDao;
import eluis.tk.models.Author;

import java.sql.SQLException;
import java.util.List;

public class AuthorController extends ControllerBase<Author> {
    AuthorDao authorDAO = new AuthorDao();

    @Override
    public Author Get(int id) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        return authorDAO.Get(id);
    }

    @Override
    public List<Author> GetAll() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        return authorDAO.GetAll();
    }

    @Override
    public void Add(Author author) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        authorDAO.Add(author);
    }

    @Override
    public void Update(Author author) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        authorDAO.Update(author);
    }

    @Override
    public void Delete(int id) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        authorDAO.Delete(id);
    }
}
