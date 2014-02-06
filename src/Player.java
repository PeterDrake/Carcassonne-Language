
public class Player {
	
//	public final int BLUE = ;
//	public final int GREEN = ;
//	public final int BLACK = ;
//	public final int RED = ;
//	public final int YELLOW = ;
	
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

}
