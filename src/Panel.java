import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Panel extends JPanel implements Runnable {
    private final int SIZE = 16;
    private final int SCALE = 3;

    private final int TILE_SIZE = SIZE * SCALE;
    private final int MAX_SCREEN_COL = 16;
    private final int MAX_SCREEN_ROW = 16;
    private final int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COL;
    private final int SCREEN_LENGTH = TILE_SIZE * MAX_SCREEN_ROW;

    private Player player;

    private Thread gameThread;
    public Panel() {
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
            updatePos();
        }
    }
    public void updatePos() {
        if (player.getUpPressed() && player.getLeftPressed()) {
            player.changeYPos(-1.0 * player.getPlayerSpeed());
            player.changeXPos(-1.0 * player.getPlayerSpeed());
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else if (player.getDownPressed() && player.getLeftPressed()) {
            player.changeYPos(player.getPlayerSpeed());
            player.changeXPos(-1.0 * player.getPlayerSpeed());
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else if (player.getRightPressed() && player.getUpPressed()) {
            player.changeXPos(player.getPlayerSpeed());
            player.changeYPos(-1.0 * player.getPlayerSpeed());
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else if (player.getRightPressed() && player.getDownPressed()) {
            player.changeXPos(player.getPlayerSpeed());
            player.changeYPos(player.getPlayerSpeed());
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else if (player.getUpPressed()) {
            player.changeYPos(-1 * player.getPlayerSpeed());
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else if (player.getDownPressed()) {
            player.changeYPos(player.getPlayerSpeed());
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else if (player.getRightPressed()) {
            player.changeXPos(player.getPlayerSpeed());
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else if (player.getLeftPressed()) {
            player.changeXPos(-1 * player.getPlayerSpeed());
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        this.setBackground(Color.WHITE);
        player.draw(g2);
        g2.dispose();
    }


}
