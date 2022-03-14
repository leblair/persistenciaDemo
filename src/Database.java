import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.sql.*;

import static com.mongodb.client.model.Filters.eq;

public class Database {
    static void insertarPeliculaMongo(String title){
        String uri = "mongodb://localhost";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("sampledb");
            MongoCollection<Document> collection = database.getCollection("movies");

            // INSERT
            Document doc = new Document();
            doc.append("title", title);
            collection.insertOne(doc);

            //QUERY
            System.out.println(collection.find(eq("title", title)).first().toJson());
        }
    }
    static void insertarPeliculaSQL(String title){
        String uri ="jdbc:mysql://localhost/mydatabase?user=myuser&password=mypass";
        try(Connection conn = DriverManager.getConnection(uri)){
            //INSERT
            PreparedStatement statement = conn.prepareStatement("INSERT INTO movies(title) VALUES(?)");
            statement.setString(1, title);
            statement.executeUpdate();

            //QUERY
            ResultSet resultSet = conn.createStatement().executeQuery("SELECT * FROM movies");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(title));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
