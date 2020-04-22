package eluis.tk.dao;

import eluis.tk.models.Books;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BooksDao extends BaseDao<Books> {
    @Override
    public Books Get(int id) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        this.Connect();

        Books books = new Books();

        String sql = "SELECT * FROM \"Books\" WHERE \"Id\" = " + id;

        Statement statement = this.GetConnection().createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.first();

        books.setId(resultSet.getInt("Id"));
        books.setIBSN(resultSet.getString("Ibsn"));
        books.setTitle(resultSet.getString("Title"));
        books.setPrice(resultSet.getFloat("Price"));
        books.setPublisherId(resultSet.getInt("PublisherId"));

        resultSet.close();

        this.Disconnect();

        return books;
    }

    @Override
    public List<Books> GetAll() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        this.Connect();

        String sql = "SELECT * FROM \"Books\"";

        PreparedStatement preparedStatement = this.GetConnection().prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Books> booksList = new ArrayList<>();

        while (resultSet.next()) {
            Books books = new Books();

            books.setId(resultSet.getInt("Id"));
            books.setIBSN(resultSet.getString("Ibsn"));
            books.setTitle(resultSet.getString("Title"));
            books.setPrice(resultSet.getFloat("Price"));
            books.setPublisherId(resultSet.getInt("PublisherId"));

            booksList.add(books);
        }

        resultSet.close();

        this.Disconnect();

        return booksList;
    }

    @Override
    public void Add(Books books) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        this.Connect();

        String sql = "INSERT INTO \"Books\" VALUES (?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = this.GetConnection().prepareStatement(sql);
        preparedStatement.setInt(1, Integer.parseInt(books.getIBSN().replaceAll("\\D*", "")));
        preparedStatement.setString(2, books.getTitle());
        preparedStatement.setString(3, books.getIBSN());
        preparedStatement.setInt(4, books.getPublisherId());
        preparedStatement.setFloat(5, books.getPrice());

        preparedStatement.execute();

        this.Disconnect();
    }

    @Override
    public void Update(Books books) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        this.Connect();

        String sql = "UPDATE \"Books\" SET \"Title\" = ?, " +
                "\"PublisherId\" = ?, \"Price\" = ? WHERE \"Id\" = ?";

        PreparedStatement preparedStatement = this.GetConnection().prepareStatement(sql);
        preparedStatement.setString(1, books.getTitle());
        preparedStatement.setInt(2, books.getPublisherId());
        preparedStatement.setFloat(3, books.getPrice());
        preparedStatement.setFloat(4, books.getId());

        preparedStatement.execute();

        this.Disconnect();
    }

    @Override
    public void Delete(int id) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        this.Connect();

        String sql = "DELETE FROM \"Books\" WHERE \"Id\" = ?";

        PreparedStatement preparedStatement = this.GetConnection().prepareStatement(sql);
        preparedStatement.setInt(1, id);

        preparedStatement.execute();

        this.Disconnect();
    }
}
