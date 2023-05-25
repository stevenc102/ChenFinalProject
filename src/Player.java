import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player implements KeyListener {
    private int xPos, yPos;
    private boolean upPressed, downPressed, leftPressed, rightPressed;

    private BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    private int playerSpeed;

    private BufferedImage img;
    public Player()  {
        playerSpeed = 2;
        xPos = 100;
        yPos = 100;
        upPressed = false;
        downPressed = false;
        leftPressed = false;
        rightPressed = false;
        try {
            getPlayerImage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }
    public int getPlayerSpeed() {
        return playerSpeed;
    }
    public boolean getUpPressed() {
        return upPressed;
    }

    public boolean getDownPressed() {
        return downPressed;
    }
    public boolean getRightPressed() {
        return rightPressed;
    }
    public boolean getLeftPressed() {
        return leftPressed;
    }

    public void changeYPos(int a) {
        yPos += a;
    }
    public void changeXPos(int a) {
        xPos += a;
    }

    public void getPlayerImage() throws IOException {
        img = ImageIO.read(getClass().getResourceAsStream("/Sprites/player.png"));
    }

    public BufferedImage getImage() {
        return img;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int temp = e.getKeyCode();
        if (temp == KeyEvent.VK_W || temp == KeyEvent.VK_UP) {
            upPressed = true;
        } else if (temp == KeyEvent.VK_A || temp == KeyEvent.VK_LEFT) {
            leftPressed = true;
        } else if (temp == KeyEvent.VK_S || temp == KeyEvent.VK_DOWN) {
            downPressed = true;
        } else if (temp == KeyEvent.VK_D || temp == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int temp = e.getKeyCode();
        if (temp == KeyEvent.VK_W || temp == KeyEvent.VK_UP) {
            upPressed = false;
        } else if (temp == KeyEvent.VK_A || temp == KeyEvent.VK_LEFT) {
            leftPressed = false;
        } else if (temp == KeyEvent.VK_S || temp == KeyEvent.VK_DOWN) {
            downPressed = false;
        } else if (temp == KeyEvent.VK_D || temp == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = getImage();
        g2.drawImage(image, getXPos(), getYPos(), 48, 48, null);
    }
}
