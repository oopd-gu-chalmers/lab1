import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CarRun {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setTitle("2d car");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JPanel jpanel = new JPanel();
        frame.add(jpanel);
        frame.pack();
        frame.setVisible(true);

        jpanel.startGameThread();
    }
}


