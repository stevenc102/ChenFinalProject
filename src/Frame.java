import javax.swing.*;

public class Frame extends JFrame {
    private JFrame frame;
    private Panel panel;
    public Frame() {
        panel = new Panel();
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(768,768);
        frame.setTitle("aaaaaaaaa");
        frame.add(panel);
        frame.setVisible(true);
    }
}