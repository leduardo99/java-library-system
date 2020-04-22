package eluis.tk.dao;

import eluis.tk.models.Publishers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PublishersDao extends BaseDao<Publishers> {
    @Override
    public Publishers Get(int id) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        this.Connect();

        Publishers publishers = new Publishers();

        String sql = "SELECT * FROM \"Publishers\" WHERE \"Id\" = " + id;

        Statement statement = this.GetConnection().createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.first();

        publishers.setId(resultSet.getInt("Id"));
        publishers.setName(resultSet.getString("Name"));
        publishers.setURL(resultSet.getString("Url"));

        resultSet.close();

        this.Disconnect();

        return publishers;
    }

    @Override
    public List<Publishers> GetAll() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        this.Connect();

        String sql = "SELECT * FROM \"Publishers\"";

        PreparedStatement preparedStatement = this.GetConnection().prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Publishers> publishersList = new ArrayList<>();

        while (resultSet.next()) {
            Publishers publishers = new Publishers();

            publishers.setId(resultSet.getInt("Id"));
            publishers.setName(resultSet.getString("Name"));
            publishers.setURL(resultSet.getString("Url"));

            publishersList.add(publishers);
        }

        resultSet.close();

        this.Disconnect();

        return publishersList;
    }

    @Override
    public void Add(Publishers publishers) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        this.Connect();

        String sql = "INSERT INTO \"Publishers\" (\"Name\", \"Url\") VALUES (?, ?)";

        PreparedStatement preparedStatement = this.GetConnection().prepareStatement(sql);
        preparedStatement.setString(1, publishers.getName());
        preparedStatement.setString(2, publishers.getURL());

        preparedStatement.execute();

        this.Disconnect();
    }

    @Override
    public void Update(Publishers publishers) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        this.Connect();

        String sql = "UPDATE \"Publishers\" SET \"Name\" = ?, \"Url\" = ? WHERE \"Id\" = ?";

        PreparedStatement preparedStatement = this.GetConnection().prepareStatement(sql);
        preparedStatement.setString(1, publishers.getName());
        preparedStatement.setString(2, publishers.getURL());
        preparedStatement.setInt(3, publishers.getId());

        preparedStatement.execute();

        this.Disconnect();
    }

    @Override
    public void Delete(int id) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        this.Connect();

        String sql = "DELETE FROM \"Publishers\" WHERE \"Id\" = ?";

        PreparedStatement preparedStatement = this.GetConnection().prepareStatement(sql);
        preparedStatement.setInt(1, id);

        preparedStatement.execute();

        this.Disconnect();
    }
}
