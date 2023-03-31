package DatabaseModel;

import java.sql.Timestamp;

public class Post {
    int id;
    String title;
    String content;
    Timestamp createdAt;
    int authorId;
    int likes;
    public Post(int id, String title, String content, Timestamp createdAt, int authorId, int likes)
    {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.authorId = authorId;
        this.likes = likes;
    }
}
