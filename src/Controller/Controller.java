package Controller;

import DatabaseModel.ForumModel;
import View.View;

import javax.swing.*;

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

    public static void main(String[] args) {
        Controller c = new Controller(new View(), new ForumModel());
    }
}
