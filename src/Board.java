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
				if (tile.getFollower().location == 1) {
					// watchout for multiple roads, this so far does not account
					// for it
					currentScore.followers[tile.getFollower().player] += 1;
				}
				for (int i = 0; i < tile.SIDES; i++) {
					if (tile.getSide(i) == tile.ROAD) {
						currentScore.score += roadScore(currentScore,
								getNeighbor(i, tile), opposite(i));
					}
				}
			}
			// updatePlayerScore(score)
		}
		// If it scores a road, add it to the player
	}

	public int roadScore(ScoreTracker currentScore, Tile tile, int origin) {
		if (!tile.isEnd()) {
			for (int i = 0; i < tile.SIDES; i++) {
				if (!(origin == i) && tile.getSide(i) == tile.ROAD) {
					return currentScore.score += roadScore(currentScore,
							getNeighbor(i, tile), opposite(i));
				}
			}
		}
		return 1;
	}

	public int opposite(int i) {
		if (i == 0) {
			return 2;
		}
		if (i == 1) {
			return 3;
		}
		if (i == 2) {
			return 0;
		}
		if (i == 3) {
			return 1;
		}

		return -1;
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