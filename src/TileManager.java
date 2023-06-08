import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

    public static Tile[][] tiles;
    public static int[][] map =  new int[48][48];
    private Tile sand1, sand2, sandRock, water, palmTree, waterCornerIn, waterCornerInFlipped, waterCornerOut, waterCornerOutFlipped, waterCornerConnect, waterCornerConnectFlipped, waterFlat, waterFlatFlipped,
                 waterFlat2, waterFlat2Flipped, suspiciousSand, axeTile, shovelTile;

    public TileManager() throws IOException {
        initMap();
        tiles = new Tile[48][48];
        sand1 = new Tile("sand1", ImageIO.read(getClass().getResourceAsStream("/Terrain/Sand.png")), false, 0, 0);
        sand2 = new Tile("sand2",ImageIO.read(getClass().getResourceAsStream("/Terrain/Sand2.png")), false,0, 0);
        sandRock = new Tile("sandRock",ImageIO.read(getClass().getResourceAsStream("/Terrain/Sand_Rock.png")), true, 0, 0);
        water = new Tile("water",ImageIO.read(getClass().getResourceAsStream("/Terrain/Water.png")), true, 0, 0);
        palmTree = new Tile("palmTree", ImageIO.read(getClass().getResourceAsStream("/Terrain/Palm_Tree.png")), true, 0, 0);
        waterCornerIn = new Tile("waterCornerIn",ImageIO.read(getClass().getResourceAsStream("/Terrain/Water_Corner_In.png")), true, 0, 0);
        waterCornerInFlipped = new Tile("waterCornerInFlipped",ImageIO.read(getClass().getResourceAsStream("/Terrain/Water_Corner_In_Flipped.png")), true, 0, 0);
        waterCornerOut = new Tile("waterCornerOut",ImageIO.read(getClass().getResourceAsStream("/Terrain/Water_Corner_Out.png")), true, 0, 0);
        waterCornerOutFlipped = new Tile("waterCornerOutFlipped",ImageIO.read(getClass().getResourceAsStream("/Terrain/Water_Corner_Out_Flipped.png")), true, 0, 0);
        waterCornerConnect = new Tile("waterCornerConnect",ImageIO.read(getClass().getResourceAsStream("/Terrain/Water_Corner_Connect.png")), true, 0, 0);
        waterCornerConnectFlipped = new Tile("waterCornerConnectFlipped",ImageIO.read(getClass().getResourceAsStream("/Terrain/Water_Corner_Connect_Flipped.png")), true, 0, 0);
        waterFlat = new Tile("waterFlat",ImageIO.read(getClass().getResourceAsStream("/Terrain/Water_Flat.png")), true, 0, 0);
        waterFlatFlipped = new Tile("waterFlatFlipped",ImageIO.read(getClass().getResourceAsStream("/Terrain/Water_Flat_Flipped.png")), true, 0, 0);
        waterFlat2 = new Tile("waterFlat2",ImageIO.read(getClass().getResourceAsStream("/Terrain/Water_Flat2.png")), true, 0, 0);
        waterFlat2Flipped = new Tile("waterFlat2Flipped",ImageIO.read(getClass().getResourceAsStream("/Terrain/Water_Flat2_Flipped.png")), true, 0, 0);
        suspiciousSand = new Tile("suspiciousSand",ImageIO.read(getClass().getResourceAsStream("/Terrain/Sand_Suspicious.png")), false, 0, 0);
        axeTile = new Tile("axe",ImageIO.read(getClass().getResourceAsStream("/Terrain/Tile_Axe.png")), false, 0, 0);
        shovelTile = new Tile("shovel",ImageIO.read(getClass().getResourceAsStream("/Terrain/Tile_Shovel.png")), false, 0, 0);
        initTiles();
    }

    public void initMap() {
        try {
            InputStream is = getClass().getResourceAsStream("/map.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0;
            int row = 0;
            while(col < Panel.MAX_WORLD_COL && row < Panel.MAX_WORLD_ROW) {
                String line = br.readLine();
                while(col < Panel.MAX_WORLD_COL) {
                    String[] numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    map[col][row] = num;
                    col++;
                }
                if (col == Panel.MAX_WORLD_COL) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void initTiles() {
        for (int i = 0; i < Panel.MAX_WORLD_ROW; i++) {
            for (int j = 0; j < Panel.MAX_WORLD_COL; j++) {
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
                } else if (map[i][j] == 9) {
                    tiles[i][j] = waterFlat2;
                }  else if (map[i][j] == 10) {
                    tiles[i][j] = waterCornerInFlipped;
                } else if (map[i][j] == 11) {
                    tiles[i][j] = waterCornerOutFlipped;
                } else if (map[i][j] == 12) {
                    tiles[i][j] = waterCornerConnectFlipped;
                } else if (map[i][j] == 13) {
                    tiles[i][j] = waterFlatFlipped;
                } else if (map[i][j] == 14) {
                    tiles[i][j] = waterFlat2Flipped;
                } else if (map[i][j] == 15) {
                    tiles[i][j] = suspiciousSand;
                } else if (map[i][j] == 16) {
                    tiles[i][j] = axeTile;
                } else {
                    tiles[i][j] = shovelTile;
                }
            }
        }
    }
    public void draw(Graphics2D g2) throws IOException {
        int worldCol = 0;
        int worldRow = 0;
        while(worldCol < Panel.MAX_WORLD_COL && worldRow < Panel.MAX_WORLD_ROW) {
            Tile tileNum = tiles[worldRow][worldCol];
            int worldX = worldRow * Panel.TILE_SIZE;
            int worldY = worldCol * Panel.TILE_SIZE;
            int screenX = worldX - Player.worldXPos + Player.screenX;
            int screenY = worldY - Player.worldYPos + Player.screenY;

            if (worldX + Panel.TILE_SIZE * 2 > Player.worldXPos - Player.screenX &&
                    worldX - Panel.TILE_SIZE * 2 < Player.worldXPos + Player.screenX &&
                    worldY + Panel.TILE_SIZE * 2> Player.worldYPos - Player.screenY &&
                    worldY - Panel.TILE_SIZE * 2< Player.worldYPos + Player.screenY) {
                g2.drawImage(tileNum.getImage(), screenX, screenY, Panel.TILE_SIZE, Panel.TILE_SIZE, null);
            }
                worldCol++;


            if (worldCol == Panel.MAX_WORLD_COL){
                worldCol = 0;
                worldRow++;
            }
        }


    }
}
