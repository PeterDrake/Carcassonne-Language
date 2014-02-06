
public class Player {
	
	private int playerNumber;
	private int score;
	
	public Player(int playerNumber) {
		this.playerNumber = playerNumber;
		score = 0;
	}
	
	public void addScore(int score) {
		this.score += score;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getPlayerNumber() {
		return playerNumber;
	}

}
