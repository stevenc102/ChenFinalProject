public class CollisionManager {

    public void checkCollision(Player p) {
        int playerLeftWorldX = p.getXPos() + p.getHitBox().x;
        int playerRightWorldX = p.getXPos() + p.getHitBox().x + p.getHitBox().width;
        int playerTopWorldY = p.getYPos() + p.getHitBox().y;
        int playerBottomWorldY = p.getYPos() + p.getHitBox().y + p.getHitBox().height;

        int playerLeftCol = playerLeftWorldX / (Panel.TILE_SIZE );
        int playerRightCol = playerRightWorldX / (Panel.TILE_SIZE );
        int playerTopRow = playerTopWorldY / (Panel.TILE_SIZE ) ;
        int playerBottomRow = playerBottomWorldY / (Panel.TILE_SIZE);

        Tile tile1, tile2;
        if (p.getDirection().equals("up")) {
            playerTopRow = (playerTopWorldY - p.getPlayerSpeed()) / Panel.TILE_SIZE;
            System.out.println(playerLeftCol);
            System.out.println(playerRightCol);
            System.out.println(playerTopRow);
            System.out.println(playerBottomRow);
            tile1 = TileManager.tiles[playerLeftCol][playerTopRow];
            tile2 = TileManager.tiles[playerRightCol][playerTopRow];
            if (tile1.hasCollision() || tile2.hasCollision()) {
                p.setIsColliding(true);
            }
        } else if (p.getDirection().equals("down")) {
            playerBottomRow = (playerBottomWorldY - p.getPlayerSpeed()) / Panel.TILE_SIZE;
            System.out.println(playerLeftCol);
            System.out.println(playerRightCol);
            System.out.println(playerTopRow);
            System.out.println(playerBottomRow);
            tile1 = TileManager.tiles[playerLeftCol][playerBottomRow];
            tile2 = TileManager.tiles[playerRightCol][playerBottomRow];
            if (tile1.hasCollision() || tile2.hasCollision()) {
                p.setIsColliding(true);
            }
        } else if (p.getDirection().equals("right")) {
            playerRightCol = (playerRightWorldX - p.getPlayerSpeed()) / Panel.TILE_SIZE;
            System.out.println(playerLeftCol);
            System.out.println(playerRightCol);
            System.out.println(playerTopRow);
            System.out.println(playerBottomRow);
            tile1 = TileManager.tiles[playerRightCol][playerTopRow];
            tile2 = TileManager.tiles[playerRightCol][playerBottomRow];
            if (tile1.hasCollision() || tile2.hasCollision()) {
                p.setIsColliding(true);
            }
        } else if (p.getDirection().equals("left")) {
            playerLeftCol = (playerLeftWorldX - p.getPlayerSpeed()) / Panel.TILE_SIZE;
            System.out.println(playerLeftCol);
            System.out.println(playerRightCol);
            System.out.println(playerTopRow);
            System.out.println(playerBottomRow);
            tile1 = TileManager.tiles[playerLeftCol][playerTopRow];
            tile2 = TileManager.tiles[playerLeftCol][playerBottomRow];
            if (tile1.hasCollision() || tile2.hasCollision()) {
                p.setIsColliding(true);
            }
        }
    }
}
