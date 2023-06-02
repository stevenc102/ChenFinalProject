import java.awt.image.BufferedImage;

public class Tile {

    private BufferedImage image;
    private boolean hasCollision;
    private double x, y;
    private String name;
    public Tile(String name, BufferedImage img, boolean coll, double x, double y) {
        this.name = name;
        hasCollision = coll;
        image = img;
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public BufferedImage getImage() {
        return image;
    }

    public boolean hasCollision() {
        return hasCollision;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getName() {
        return name;
    }
}
