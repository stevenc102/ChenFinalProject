import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class TileManager {

    public static Tile[][] tiles;
    public static int[][] map = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                           {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                           {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 2, 0, 0, 0},
                           {0, 0, 2, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0},
                           {0, 0, 0, 1, 4, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                           {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                           {0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 0, 0, 0, 0, 0},
                           {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                           {0, 0, 0, 0, 1, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0, 0},
                           {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0},
                           {0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                           {0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0},
                           {0, 0, 1, 0, 0, 0, 3, 8, 8, 5, 0, 0, 1, 0, 0, 0},
                           {0, 0, 0, 0, 0, 3, 3, 3, 3, 7, 6, 5, 0, 0, 0, 0},
                           {0, 0, 0, 0, 3, 3, 3, 3, 3, 3, 3, 3, 6, 0, 0, 0},
                           {0, 2, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0}};
    private Tile sand1, sand2, sandRock, water, palmTree, waterCornerIn, waterCornerOut, waterCornerConnect, waterFlat;

    public TileManager() throws IOException {
        tiles = new Tile[16][16];
        sand1 = new Tile("sand1", ImageIO.read(getClass().getResourceAsStream("/Terrain/Sand.png")), false, 0, 0);
        sand2 = new Tile("sand2",ImageIO.read(getClass().getResourceAsStream("/Terrain/Sand2.png")), false,0, 0);
        sandRock = new Tile("sandRock",ImageIO.read(getClass().getResourceAsStream("/Terrain/Sand_Rock.png")), true, 0, 0);
        water = new Tile("water",ImageIO.read(getClass().getResourceAsStream("/Terrain/Water.png")), true, 0, 0);
        palmTree = new Tile("palmTree", ImageIO.read(getClass().getResourceAsStream("/Terrain/Palm_Tree.png")), true, 0, 0);
        waterCornerIn = new Tile("waterCornerIn",ImageIO.read(getClass().getResourceAsStream("/Terrain/Water_Corner_In.png")), true, 0, 0);
        waterCornerOut = new Tile("waterCornerOut",ImageIO.read(getClass().getResourceAsStream("/Terrain/Water_Corner_Out.png")), true, 0, 0);
        waterCornerConnect = new Tile("waterCornerConnect",ImageIO.read(getClass().getResourceAsStream("/Terrain/Water_Corner_Connect.png")), true, 0, 0);
        waterFlat = new Tile("waterFlat",ImageIO.read(getClass().getResourceAsStream("/Terrain/Water_Flat.png")), true, 0, 0);
        initTiles();
    }

    public void initTiles() throws IOException {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0) {
                    tiles[i][j] = sand1;
                } else if (map[i][j] == 1) {
                    tiles[i][j] = sand2;
                } else if (map[i][j] == 2) {
                    tiles[i][j] = sandRock;
                } else if (map[i][j] == 3) {
                    tiles[i][j] = water;
                } else if (map[i][j] == 4) {
                    tiles[i][j] = palmTree;
                } else if (map[i][j] == 5){
                    tiles[i][j] = waterCornerIn;
                } else if (map[i][j] == 6){
                    tiles[i][j] = waterCornerOut;
                } else if (map[i][j] == 7){
                    tiles[i][j] = waterCornerConnect;
                } else if (map[i][j] == 8){
                    tiles[i][j] = waterFlat;
                }
            }
        }
    }

    public Tile[][] getTiles()
    {
        return tiles;
    }
    public void draw(Graphics2D g2) throws IOException {
        int val = 0;
        for (int i = 0; i < Panel.MAX_SCREEN_ROW; i++) {
            int val2 = 0;
            for (int j = 0; j < Panel.MAX_SCREEN_COL; j++){
                tiles[i][j].setX(val2);
                tiles[i][j].setY(val);
                g2.drawImage(tiles[i][j].getImage(), val2, val, Panel.TILE_SIZE, Panel.TILE_SIZE, null);
                val2 += Panel.TILE_SIZE;
            }
            val += Panel.TILE_SIZE;
        }
    }
}
