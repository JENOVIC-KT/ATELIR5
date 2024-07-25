import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertOptionIntoDatabase {
    // Informations de connexion à la base de données
    private static final String URL = "jdbc:mysql://sql.freedb.tech:3306/freedb_jenovic";
    private static final String USER = "freedb_glodie";
    private static final String PASSWORD = "8E2KmGg6Zs@A#4y";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Affichage des options
        System.out.println("Choisissez une option à insérer dans la base de données :");
        System.out.println("1. Option A");
        System.out.println("2. Option B");
        System.out.println("3. Option C");
        System.out.print("Entrez votre choix (1-3) : ");
        int choice = scanner.nextInt();

        // Convertir le choix en texte
        String option = "";
        switch (choice) {
            case 1:
                option = "Option A";
                break;
            case 2:
                option = "Option B";
                break;
            case 3:
                option = "Option C";
                break;
            default:
                System.out.println("Choix invalide.");
                return;
        }

        // Insérer l'option dans la base de données
        insertOption(option);
    }

    private static void insertOption(String option) {
        String query = "INSERT INTO options_table (option_name) VALUES (?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, option);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Option insérée avec succès : " + option);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
