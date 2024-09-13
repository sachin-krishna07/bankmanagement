package anudip.org;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    private static String url;
    private static String username;
    private static String password;

    static {
        try (InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("db.properties")) {
            Properties prop = new Properties();

            // Load the properties file
            if (input == null) {
                throw new RuntimeException("Sorry, unable to find db.properties");
            }
            prop.load(input);

            // Get the properties values
            url = prop.getProperty("db.url");
            username = prop.getProperty("db.username");
            password = prop.getProperty("db.password");

            // Optionally, load the driver class
            Class.forName(prop.getProperty("db.driverClassName"));

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Failed to load database properties", ex);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
