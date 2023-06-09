import javax.swing.*;
import java.io.IOException;

public class Frame extends JFrame {
    private JFrame frame;
    private Panel panel;
    public Frame() throws IOException {
        panel = new Panel();
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(768,768);
        frame.setResizable(false);
        frame.setTitle("Koala Treasure Hunt");
        frame.add(panel);
        frame.setVisible(true);
    }
}
