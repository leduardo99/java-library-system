package eluis.tk.dao;

import eluis.tk.models.Author;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AuthorDao extends BaseDao<Author> {

    @Override
    public Author Get(int id) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        this.Connect();

        Author author = new Author();

        String sql = "SELECT * FROM \"Author\" WHERE \"Id\" = " + id;

        Statement statement = this.GetConnection().createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.first();

        author.setId(resultSet.getInt("Id"));
        author.setName(resultSet.getString("Name"));
        author.setFName(resultSet.getString("FName"));

        resultSet.close();

        this.Disconnect();

        return author;
    }

    @Override
    public List<Author> GetAll() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        this.Connect();

        String sql = "SELECT * FROM \"Author\"";

        PreparedStatement preparedStatement = this.GetConnection().prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Author> authorList = new ArrayList<>();

        while (resultSet.next()) {
            Author author = new Author();
            author.setId(resultSet.getInt("Id"));
            author.setName(resultSet.getString("Name"));
            author.setFName(resultSet.getString("FName"));
            authorList.add(author);
        }

        resultSet.close();

        this.Disconnect();

        return authorList;
    }

    @Override
    public void Add(Author author) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        this.Connect();

        String sql = "INSERT INTO \"Author\" (\"Name\", \"FName\") VALUES (?, ?)";

        PreparedStatement preparedStatement = this.GetConnection().prepareStatement(sql);
        preparedStatement.setString(1, author.getName());
        preparedStatement.setString(2, author.getFName());

        preparedStatement.execute();

        this.Disconnect();
    }

    @Override
    public void Update(Author author) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        this.Connect();

        String sql = "UPDATE \"Author\" SET \"Name\" = ?, \"FName\" = ? WHERE \"Id\" = ?";

        PreparedStatement preparedStatement = this.GetConnection().prepareStatement(sql);
        preparedStatement.setString(1, author.getName());
        preparedStatement.setString(2, author.getFName());
        preparedStatement.setInt(3, author.getId());

        preparedStatement.execute();

        this.Disconnect();
    }

    @Override
    public void Delete(int id) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        this.Connect();

        String sql = "DELETE FROM \"Author\" WHERE \"Id\" = ?";

        PreparedStatement preparedStatement = this.GetConnection().prepareStatement(sql);
        preparedStatement.setInt(1, id);

        preparedStatement.execute();

        this.Disconnect();
    }
}
