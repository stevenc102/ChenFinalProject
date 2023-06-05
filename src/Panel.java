import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Panel extends JPanel implements Runnable {
    public static final int SIZE = 16;
    public static final int SCALE = 3;

    public static final int TILE_SIZE = SIZE * SCALE;
    public static final int MAX_SCREEN_COL = 16;
    public static final int MAX_SCREEN_ROW = 16;
    public static final int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COL;
    public static final int SCREEN_LENGTH = TILE_SIZE * MAX_SCREEN_ROW;
    public static final int MAX_WORLD_COL = 48;
    public static final int MAX_WORLD_ROW = 48;
    public static final int MAX_WORLD_HEIGHT = TILE_SIZE * MAX_WORLD_ROW;
    public static final int MAX_WORLD_LENGTH = TILE_SIZE * MAX_WORLD_COL;

    private Player player;
    private TileManager tileManager;

    private Thread gameThread;
    public Panel() throws IOException {
        tileManager = new TileManager();
        player = new Player();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_LENGTH));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.addKeyListener(player);

        this.setFocusable(true);
        startGameThread();

    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run() {
        while(gameThread != null) {
            repaint();
            player.update();
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        this.setBackground(Color.WHITE);
        try {
            tileManager.draw(g2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        player.draw(g2);
        g2.draw(player.getHitBox());
        g2.dispose();
    }


}
