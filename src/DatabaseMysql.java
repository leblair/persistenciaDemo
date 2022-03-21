import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.sql.*;

public class DatabaseMysql extends Database{

    @Override
    void insertar(String title) {
        String uri = "jdbc:mysql://localhost/mydatabase?user=myuser&password=mypass";
        try (Connection conn = DriverManager.getConnection(uri)) {
            //INSERT
            PreparedStatement statement = conn.prepareStatement("INSERT INTO movies(title) VALUES(?)");
            statement.setString(1, title);
            statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    void consultar() {
        String uri = "jdbc:mysql://localhost/mydatabase?user=myuser&password=mypass";

        try (Connection conn = DriverManager.getConnection(uri)) {
            //QUERY
            ResultSet resultSet = conn.createStatement().executeQuery("SELECT * FROM movies");
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString(title));
//            }

            while (resultSet.next()) {
                System.out.println(resultSet.getString("title"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
