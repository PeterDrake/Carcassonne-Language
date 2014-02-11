public class Board {

	public int CENTER = 72;

	private Tile[][] board;
	private Player[] players;

	public Board() {
		board = new Tile[CENTER * 2][CENTER * 2];
		board[CENTER][CENTER] = new Tile(CENTER, CENTER, new int[] { 0, 1, 0, 1, 1 });

		players = new Player[5];
		for (int i = 0; i < players.length; i++) {
			players[i] = new Player(i);
		}
	}

	public void addTile(Tile tile, int r, int c) {
		board[r][c] = tile;
	}

	public void scoreTile(int r, int c) {
		Tile tile = getTile(r, c);
		// scoreCity
		// scoreField
		if (tile.hasRoad()) {
			scoreRoad(tile);
		}
	}

	public void scoreRoad(Tile tile) {
		Follower follower = tile.getFollower();
		if (!tile.isEnd()) {
			ScoreTracker currentScore = new ScoreTracker();
			currentScore.score += 1;
			
			if ((follower != null) && (follower.getLocationType() == 1)) {
				// Watch for multiple roads
				currentScore.followers[follower.getPlayer()] += 1;
			}
			
			for (int i = 0; i < tile.SIDES; i++) {
				if (tile.getSideType(i) == tile.ROAD) {
					Tile neighbor = getNeighbor(i, tile);
					if (neighbor != null) {
						currentScore.score += roadScoreR(currentScore,
								neighbor, opposite(i));
					}
				}
			}
			
			divyScore(currentScore);
		} else {
			for (int i = 0; i < tile.SIDES; i++) {
				ScoreTracker currentScore = new ScoreTracker();
				currentScore.score += 1;
				
				if (follower != null && follower.getLocation() == i && follower.getLocationType() == 1) {
					currentScore.followers[follower.getPlayer()] += 1;
				}
				
				Tile neighbor = getNeighbor(i, tile);
				if (neighbor != null) {
					currentScore.score += roadScoreR(currentScore,
							neighbor, opposite(i));
				}
				
				divyScore(currentScore);
			}
		}
	}

	public int roadScoreR(ScoreTracker currentScore, Tile tile, int origin) {
		Follower follower = tile.getFollower();
		if (!tile.isEnd()) {
			if (follower.getLocationType() == 1) {
				// Watch for multiple roads
				currentScore.followers[follower.getPlayer()] += 1;
			}
			for (int i = 0; i < tile.SIDES; i++) {
				if (origin != i && tile.getSideType(i) == tile.ROAD) {
					Tile neighbor = getNeighbor(i, tile);
					if (neighbor != null) {
						return currentScore.score += roadScoreR(currentScore,
								getNeighbor(i, tile), opposite(i));
					}
				}
			}
			return -1;
			// -1 because if there is no road, then the tile must be illegal
		} else {
			if (follower.getLocation() == origin
					&& follower.getLocationType() == 1) {
				// Should we check location type here or assume it's legal
				currentScore.followers[follower.getPlayer()] += 1;
			}
			return 1;
		}
	}
	
	public void divyScore(ScoreTracker score) {
		boolean[] owners = new boolean[5];
		int max = 1;
		for (int i = 0; i < score.followers.length; i++) {
			if (score.followers[i] == max) {
				owners[i] = true;
			} else if (score.followers[i] > max) {
				max = score.followers[i];
				for (int j = 0; j < owners.length; j++) {
					owners[j] = false;
				}
				owners[i] = true;
			}
		}
		for (int i = 0; i < owners.length; i++) {
			if (owners[i]) {
				addPlayerScore(i, score.score);
			}
		}
		// Not sure if this is a good algorithm
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

	public Tile getNeighbor(int i, Tile tile) {

		if (i == 0) {
			return board[tile.getRow()][tile.getCol() + 1];
		}
		if (i == 1) {
			return board[tile.getRow() + 1][tile.getCol()];
		}
		if (i == 2) {
			return board[tile.getRow()][tile.getCol() - 1];
		}
		if (i == 3) {
			return board[tile.getRow() - 1][tile.getCol()];
		}
		return null;

	}

	public Tile getTile(int r, int c) {
		return board[r][c];
	}

	public int getPlayerScore(int player) {
		return players[player].getScore();
	}

	public void addPlayerScore(int player, int score) {
		players[player].addScore(score);
	}

	public void placeFollower(int r, int c, int player, int location) {
		Tile tile = getTile(r, c);
		tile.placeFollower(player, tile.getSideType(location), location);
	}

}