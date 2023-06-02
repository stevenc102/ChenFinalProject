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
            if (playerTopWorldY - p.getPlayerSpeed() > 3) {
                playerTopRow = (playerTopWorldY - p.getPlayerSpeed()) / Panel.TILE_SIZE;
                tile1 = TileManager.tiles[playerTopRow][playerLeftCol];
                tile2 = TileManager.tiles[playerTopRow][playerRightCol];
                if (tile1.hasCollision() || tile2.hasCollision()) {
                    p.setIsColliding(true);
                }
            } else {
                p.setIsColliding(true);
            }
        } else if (p.getDirection().equals("down")) {
            if (playerBottomWorldY + p.getPlayerSpeed() < 765) {
                playerBottomRow = (playerBottomWorldY + p.getPlayerSpeed()) / Panel.TILE_SIZE;

                tile1 = TileManager.tiles[playerBottomRow][playerLeftCol];
                tile2 = TileManager.tiles[playerBottomRow][playerRightCol];
                if (tile1.hasCollision() || tile2.hasCollision()) {
                    p.setIsColliding(true);
                }
            } else {
                p.setIsColliding(true);
            }
        } else if (p.getDirection().equals("right")) {
            if (playerRightWorldX + p.getPlayerSpeed() < 765) {
                playerRightCol = (playerRightWorldX + p.getPlayerSpeed()) / Panel.TILE_SIZE;

                tile1 = TileManager.tiles[playerTopRow][playerRightCol];
                tile2 = TileManager.tiles[playerBottomRow][playerRightCol];
                if (tile1.hasCollision() || tile2.hasCollision()) {
                    p.setIsColliding(true);
                }
            } else {
                p.setIsColliding(true);
            }
        } else if (p.getDirection().equals("left")) {
            if (playerLeftWorldX - p.getPlayerSpeed() > 3) {
                playerLeftCol = (playerLeftWorldX - p.getPlayerSpeed()) / Panel.TILE_SIZE;

                tile1 = TileManager.tiles[playerTopRow][playerLeftCol];
                tile2 = TileManager.tiles[playerBottomRow][playerLeftCol];
                if (tile1.hasCollision() || tile2.hasCollision()) {
                    p.setIsColliding(true);
                }
            } else {
                p.setIsColliding(true);
            }
        }
    }
}
