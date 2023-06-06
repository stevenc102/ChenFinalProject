public class CollisionManager {

    public void checkCollision(Player p) {
        int playerLeftWorldX = 13 + Player.worldXPos;
        int playerRightWorldX = 13 + Player.worldXPos + p.getHitBox().width;
        int playerTopWorldY =  24 + Player.worldYPos;
        int playerBottomWorldY =  24 +Player.worldYPos + p.getHitBox().height;

        int playerLeftCol = playerLeftWorldX / (Panel.TILE_SIZE ) ;
        int playerRightCol = playerRightWorldX / (Panel.TILE_SIZE );
        int playerTopRow = playerTopWorldY / (Panel.TILE_SIZE );
        int playerBottomRow = playerBottomWorldY / (Panel.TILE_SIZE);



        Tile tile1, tile2;
        if (p.getDirection().equals("up")) {
                playerTopRow = (playerTopWorldY - p.getPlayerSpeed()) / Panel.TILE_SIZE;
                System.out.println(playerTopRow);
                if (playerTopRow >= 0 && playerTopRow < 48 && playerLeftCol < 48 && playerLeftCol >=0 && playerRightCol < 48 && playerRightCol >= 0) {
                    tile1 = TileManager.tiles[playerLeftCol][playerTopRow];
                    tile2 = TileManager.tiles[playerRightCol][playerTopRow];
                    System.out.println(tile1.getName());
                    System.out.println(tile2.getName());
                    if (tile1.hasCollision() || tile2.hasCollision()) {
                        p.setIsColliding(true);
                    }
                }

        } else if (p.getDirection().equals("down")) {
                playerBottomRow = (playerBottomWorldY + p.getPlayerSpeed()) / Panel.TILE_SIZE;
                if (playerBottomRow >= 0 && playerBottomRow < 48 && playerLeftCol < 48 && playerLeftCol >=0 && playerRightCol < 48 && playerRightCol >= 0) {
                    tile1 = TileManager.tiles[playerLeftCol][playerBottomRow];
                    tile2 = TileManager.tiles[playerRightCol][playerBottomRow];
                    if (tile1.hasCollision() || tile2.hasCollision()) {
                        p.setIsColliding(true);
                    }
                }
        } else if (p.getDirection().equals("right")) {
                playerRightCol = (playerRightWorldX + p.getPlayerSpeed()) / Panel.TILE_SIZE;
                if (playerTopRow >= 0 && playerTopRow < 48 && playerBottomRow < 48 && playerBottomRow >=0 && playerRightCol < 48 && playerRightCol >= 0) {
                    tile1 = TileManager.tiles[playerRightCol][playerTopRow];
                    tile2 = TileManager.tiles[playerRightCol][playerBottomRow];
                    if (tile1.hasCollision() || tile2.hasCollision()) {
                        p.setIsColliding(true);
                    }
                }
        } else if (p.getDirection().equals("left")) {
                playerLeftCol = (playerLeftWorldX - p.getPlayerSpeed()) / Panel.TILE_SIZE;
                if (playerTopRow >= 0 && playerTopRow < 48 && playerLeftCol < 48 && playerLeftCol >=0 && playerBottomRow < 48 && playerBottomRow >= 0) {
                    tile1 = TileManager.tiles[playerLeftCol][playerTopRow];
                    tile2 = TileManager.tiles[playerLeftCol][playerBottomRow];
                    if (tile1.hasCollision() || tile2.hasCollision()) {
                        p.setIsColliding(true);
                    }
                }
        }
    }
}
