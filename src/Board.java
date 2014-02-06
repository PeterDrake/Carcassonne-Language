public class Board {

	public int CENTER = 72;

	private Tile[][] board;
	private Player[] players;

	public Board() {
		board = new Tile[CENTER * 2][CENTER * 2];
		board[CENTER][CENTER] = new Tile(CENTER, CENTER);

		players = new Player[5];
		for (int i = 0; i < players.length; i++) {
			players[i] = new Player(i);
		}
	}

	public void addTile(Tile tile, int x, int y) {
		board[x][y] = tile;
	}

	public void scoreRoads(int x, int y) {
		Tile tile = board[x][y];
		if (tile.hasRoad()) {
			ScoreTracker currentScore = new ScoreTracker();
			if (!tile.isEnd()) {
				currentScore.score += 1;
				if (tile.getFollower().getLocation() == 1) {
					// Watch for multiple roads
					currentScore.followers[tile.getFollower().getPlayer()] += 1;
				}
				for (int i = 0; i < tile.SIDES; i++) {
					if (tile.getSide(i) == tile.ROAD) {
						currentScore.score += roadScoreR(currentScore,
								getNeighbor(i, tile), opposite(i));
					}
				}
			} else {
				// TODO Write code for end points with multiple roads/follower
				// placement options
			}
			
			boolean[] owners = new boolean[5];
			int max = 1;
			for (int i = 0; i < currentScore.followers.length; i++) {
				if (currentScore.followers[i] == max) {
					owners[i] = true;
				} else if (currentScore.followers[i] > max) {
					max = currentScore.followers[i];
					for (int j = 0; j < owners.length; j++) {
						owners[j] = false;
					}
					owners[i] = true;
				}
			}
			for (int i = 0; i < owners.length; i++) {
				if (owners[i]) {
					addPlayerScore(i, currentScore.score);
				}
			}
			// Not sure if this is a good algorithm
		}
	}

	public int roadScoreR(ScoreTracker currentScore, Tile tile, int origin) {
		if (!tile.isEnd()) {
			if (tile.getFollower().getLocation() == 1) {
				// Watch for multiple roads
				currentScore.followers[tile.getFollower().getPlayer()] += 1;
			}
			for (int i = 0; i < tile.SIDES; i++) {
				if (!(origin == i) && tile.getSide(i) == tile.ROAD) {
					return currentScore.score += roadScoreR(currentScore,
							getNeighbor(i, tile), opposite(i));
				}
			}
			return -1;
		} else {
			// TODO Write code for end points with multiple roads/follower
			// placement options
			return -1;
		}

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

	public int getPlayerScore(int player) {
		return players[player].getScore();
	}
	
	public void addPlayerScore(int player, int score) {
		players[player].addScore(score);
	}

	public void placeFollower(int x, int y, int player, int location) {
		getTile(x, y).placeFollower(player, location);
	}

}