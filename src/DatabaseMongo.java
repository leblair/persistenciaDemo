import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.sql.*;

import static com.mongodb.client.model.Filters.eq;

public class DatabaseMongo extends Database{


    @Override
    void insertar(String title) {
        String uri = "mongodb://localhost";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("sampledb");
            MongoCollection<Document> collection = database.getCollection("movies");

            // INSERT
            Document doc = new Document();
            doc.append("title", title);
            collection.insertOne(doc);


        }
    }

    @Override
    void consultar() {
        String uri = "mongodb://localhost";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("sampledb");
            MongoCollection<Document> collection = database.getCollection("movies");

            //QUERY
            System.out.println(collection.find().first().toJson());
        }
        //QUERY
//        System.out.println(collection.find(eq("title", title)).first().toJson());
    }
}
