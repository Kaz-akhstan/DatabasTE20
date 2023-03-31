package DatabaseModel;

import java.sql.*;
import java.util.ArrayList;

public class ForumModel {
    ArrayList<Post>posts = new ArrayList<>();
    Connection conn = null;
    public void connectToDatabase() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + DatabaseLoginData.DBURL + ":" + DatabaseLoginData.port + "/" + DatabaseLoginData.DBname +
                            "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    DatabaseLoginData.user, DatabaseLoginData.password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getPosts()
    {
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
                Post p = new Post(result.getInt("id"), result.getString("title"), result.getString("content"), result.getTimestamp("createdAt"), result.getInt("AuthorId"), result.getInt("likes"));
                posts.add(p);
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void login() {

    }

    public static void main(String[] args) {
        ForumModel m = new ForumModel();
        m.connectToDatabase();
        m.getPosts();
    }
}
