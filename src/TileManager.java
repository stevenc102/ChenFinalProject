import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class TileManager {

    private Tile[][] tiles;

    public TileManager() throws IOException {
        tiles = new Tile[16][16];
    }

    public void initTiles() throws IOException {

    }

    public void draw(Graphics2D g2) throws IOException {
        tiles[0][0] = new Tile(ImageIO.read(getClass().getResourceAsStream("/Terrain/Sand.png")));
        g2.drawImage(tiles[0][0].getImage(), 0, 0, 48, 48, null);
    }
}
