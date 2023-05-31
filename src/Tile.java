import java.awt.image.BufferedImage;

public class Tile {

    private BufferedImage image;
    private boolean hasCollision;
    public Tile(BufferedImage img, boolean coll) {
        hasCollision = coll;
        image = img;
    }

    public BufferedImage getImage() {
        return image;
    }

    public boolean hasCollision() {
        return hasCollision;
    }
}
