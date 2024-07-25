import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://sql.freedb.tech:3306/freedb_jenovic"
    ;
    private static final String USER = "freedb_glodie"
    ;
    private static final String PASSWORD = "8E2KmGg6Zs@A#4y"
    ;
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            if (connection != null) {
                System.out.println("Connected to the database!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
