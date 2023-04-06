package Controller;

import DatabaseModel.ForumModel;
import DatabaseModel.Post;
import View.View;

import javax.swing.*;
import java.util.ArrayList;

public class Controller {
    View v;
    ForumModel m;
    public Controller(View v, ForumModel m) {
        this.v = v;
        this.m = m;

        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame();
        frame.setContentPane(v.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void setPosts() {
        m.getPosts();
        v.setPosts(new JList(m.getPosts().toArray()));//FUNKAR INTE
    }

    public static void main(String[] args) {
        ForumModel m = new ForumModel();
        m.connectToDatabase();
        m.retrievePosts();
        View v = new View();
        Controller c = new Controller(v, m);
        c.setPosts();
    }
}
