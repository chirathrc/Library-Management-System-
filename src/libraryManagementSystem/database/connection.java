package libraryManagementSystem.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection {

    private static connection DBconection;
    public Connection DatabaseConnection;

    private connection() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        DatabaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagmentsystem", "root",
                "1975@#Cc@2005");

    }

    public static connection getConection() throws Exception {

        if (DBconection == null) {

            DBconection = new connection();
            return DBconection;

        } else {

            return DBconection;

        }

    }

}

