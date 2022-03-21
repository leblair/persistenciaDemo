import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.sql.*;
import java.util.Scanner;

import static com.mongodb.client.model.Filters.eq;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quieres mysql?");

        String dbtype = scanner.nextLine();
        System.out.println("Title:");
        String title = scanner.nextLine();
        Database db;
        if("si".equals(dbtype)){
            db =  new DatabaseMysql();

        }else{
            db = new DatabaseMongo();


        }

        db.consultar();
        db.insertar(title);
        db.deleteOne(title);

    }



}
