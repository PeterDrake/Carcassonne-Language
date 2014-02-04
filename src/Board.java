public class Board {

	private Tile[][] board;

	public Board(int size) {
		board = new Tile[size][size];
		board[size / 2][size / 2] = new Tile(size / 2, size / 2);
	}

	public void addTile(Tile tile, int x, int y) {
		board[x][y] = tile;
	}

	public void scoreRoads(int x, int y) {
		Tile tile = board[x][y];
		if (tile.hasRoad()) {
			if (tile.isEnd()) {
				// if it is an endpoint then check for multiple roads

			} else {
				ScoreTracker currentScore = new ScoreTracker();
				currentScore.score += 1;
				if(tile.getFollower().location == 1){
					//watchout for multiple roads
					currentScore.followers[tile.getFollower().player] += 1;
				}
				for (int i = 0; i < tile.SIDES; i++) {
					if (tile.getSide(i) == tile.ROAD) {
						currentScore.score += roadScore(getNeighbor(i, tile));
					}
				}
			}
			// updatePlayerScore(score)
		}
		// If it scores a road, add it to the player
	}

	public int roadScore(ScoreTracker score, Tile tile) {

		return 0;
	}

	public Tile getNeighbor(int x, Tile tile) {

		if (x == 0) {
			return board[tile.getX()][tile.getY() + 1];
		}
		if (x == 1) {
			return board[tile.getX() + 1][tile.getY()];
		}
		if (x == 2) {
			return board[tile.getX()][tile.getY() - 1];
		}
		if (x == 3) {
			return board[tile.getX() - 1][tile.getY()];
		}
		return null;

	}

	public Tile getTile(int x, int y) {
		return board[x][y];
	}

}