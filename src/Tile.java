import java.awt.image.BufferedImage;

public class Tile {

    private BufferedImage image;
    private boolean collision;
    public Tile(BufferedImage img) {
        collision = false;
        image = img;
    }

    public BufferedImage getImage() {
        return image;
    }
}
