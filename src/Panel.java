import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel implements Runnable {
    private final int SIZE = 16;
    private final int SCALE = 3;

    private final int TILE_SIZE = SIZE * SCALE;
    private final int MAX_SCREEN_COL = 16;
    private final int MAX_SCREEN_ROW = 16;
    private final int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COL;
    private final int SCREEN_LENGTH = TILE_SIZE * MAX_SCREEN_ROW;


    private Thread gameThread;
    public Panel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_LENGTH));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        startGameThread();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run() {
        while(gameThread != null) {
            repaint();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        g2.fillRect(100, 100 , 48, 48);
        g2.dispose();
    }
}
