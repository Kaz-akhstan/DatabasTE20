import javax.swing.*;
import java.sql.*;

public class DatabaseExample {
    public static void main(String[] args) {
        Connection conn = null;


        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + DatabaseLoginData.DBURL + ":" + DatabaseLoginData.port + "/" + DatabaseLoginData.DBname +
                            "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    DatabaseLoginData.user, DatabaseLoginData.password);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            Statement stmt = conn.createStatement();
            String SQLQuery = "SELECT * FROM rj28forum";
            ResultSet result = stmt.executeQuery(SQLQuery);

            ResultSetMetaData metadata = result.getMetaData();

            int numCols = metadata.getColumnCount();
            for (int i = 1 ; i <= numCols ; i++) {
                System.out.println(metadata.getColumnClassName(i));
            }

            while (result.next()) {
                String output = "";
                output += result.getInt("id") + ", " +
                        result.getString("title") + ", " +
                        result.getString("content") + ", " +
                        result.getTimestamp("createdAt") + ", " +
                        result.getInt("AuthorId") + ", " +
                        result.getInt("likes");
                System.out.println(output);
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
