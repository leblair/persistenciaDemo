import com.mongodb.client.*;
import org.bson.Document;

import java.sql.*;

import static com.mongodb.client.model.Filters.eq;

public class DatabaseMongo implements Database{


    public void insertar(String title) {
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

    public void consultar() {
        String uri = "mongodb://localhost";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("sampledb");
            //QUERY
            FindIterable<Document> iterable = database.getCollection("movies").find();
            iterable.forEach(document -> System.out.println(document));
        }
        //QUERY
//        System.out.println(collection.find(eq("title", title)).first().toJson());
    }

    @Override
    public void consultarOne(String title) {
        String uri = "mongodb://localhost";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("sampledb");
            MongoCollection<Document> collection = database.getCollection("movies");

            //QUERY

            System.out.println(collection.find().);
        }

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteOne(String title) {

    }
}
