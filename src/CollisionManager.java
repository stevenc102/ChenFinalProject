public class CollisionManager {

    public void checkCollision(Player p) {
        int playerLeftWorldX = (int) p.getHitBox().getMinX();
        int playerRightWorldX = (int) p.getHitBox().getMaxX();
        int playerTopWorldY = (int) p.getHitBox().getMinY();
        int playerBottomWorldY = (int) p.getHitBox().getMaxY();

        int playerLeftCol = playerLeftWorldX / (Panel.TILE_SIZE );
        int playerRightCol = playerRightWorldX / (Panel.TILE_SIZE );
        int playerTopRow = playerTopWorldY / (Panel.TILE_SIZE ) ;
        int playerBottomRow = playerBottomWorldY / (Panel.TILE_SIZE);





        Tile tile1, tile2;
        if (p.getDirection().equals("up")) {
                playerTopRow = (playerTopWorldY - p.getPlayerSpeed()) / Panel.TILE_SIZE;
                if (playerTopRow >= 0 && playerTopRow < 16 && playerLeftCol < 16 && playerLeftCol >=0 && playerRightCol < 16 && playerRightCol >= 0) {
                    tile1 = TileManager.tiles[playerTopRow][playerLeftCol];
                    tile2 = TileManager.tiles[playerTopRow][playerRightCol];
                    if (tile1.hasCollision() || tile2.hasCollision()) {
                        p.setIsColliding(true);
                    }
                }

        } else if (p.getDirection().equals("down")) {
                playerBottomRow = (playerBottomWorldY + p.getPlayerSpeed()) / Panel.TILE_SIZE;
                if (playerBottomRow >= 0 && playerBottomRow < 16 && playerLeftCol < 16 && playerLeftCol >=0 && playerRightCol < 16 && playerRightCol >= 0) {
                    tile1 = TileManager.tiles[playerBottomRow][playerLeftCol];
                    tile2 = TileManager.tiles[playerBottomRow][playerRightCol];
                    if (tile1.hasCollision() || tile2.hasCollision()) {
                        p.setIsColliding(true);
                    }
                }
        } else if (p.getDirection().equals("right")) {
                playerRightCol = (playerRightWorldX + p.getPlayerSpeed()) / Panel.TILE_SIZE;
                if (playerTopRow >= 0 && playerTopRow < 16 && playerBottomRow < 16 && playerBottomRow >=0 && playerRightCol < 16 && playerRightCol >= 0) {
                    tile1 = TileManager.tiles[playerTopRow][playerRightCol];
                    tile2 = TileManager.tiles[playerBottomRow][playerRightCol];
                    if (tile1.hasCollision() || tile2.hasCollision()) {
                        p.setIsColliding(true);
                    }
                }
        } else if (p.getDirection().equals("left")) {
                playerLeftCol = (playerLeftWorldX - p.getPlayerSpeed()) / Panel.TILE_SIZE;
                if (playerTopRow >= 0 && playerTopRow < 16 && playerLeftCol < 16 && playerLeftCol >=0 && playerBottomRow < 16 && playerBottomRow >= 0) {
                    tile1 = TileManager.tiles[playerTopRow][playerLeftCol];
                    tile2 = TileManager.tiles[playerBottomRow][playerLeftCol];
                    if (tile1.hasCollision() || tile2.hasCollision()) {
                        p.setIsColliding(true);
                    }
                }
        }
    }
}
