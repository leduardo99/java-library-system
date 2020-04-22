package eluis.tk.controllers;

import eluis.tk.dao.BooksDao;
import eluis.tk.models.Books;

import java.sql.SQLException;
import java.util.List;

public class BooksController extends ControllerBase<Books> {
    BooksDao booksDAO = new BooksDao();

    @Override
    public Books Get(int id) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        return booksDAO.Get(id);
    }

    @Override
    public List<Books> GetAll() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        return booksDAO.GetAll();
    }

    @Override
    public void Add(Books books) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        booksDAO.Add(books);
    }

    @Override
    public void Update(Books books) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        booksDAO.Update(books);
    }

    @Override
    public void Delete(int id) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        booksDAO.Delete(id);
    }
}
