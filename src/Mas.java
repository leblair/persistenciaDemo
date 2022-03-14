import java.sql.*;
import java.util.Scanner;

import static com.mongodb.client.model.Filters.eq;

public class Mas {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(
                "Title:"
        );
        //para insertar un nuevo titulo
        String title = scanner.nextLine();

        //patron facade
        //"para hacerlo mas facil"
        Database.insertarPeliculaSQL(title);
        Database.insertarPeliculaMongo(title);


    }


}
