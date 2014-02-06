public class Tile {

	public final int SIDES = 4;
	public final int FIELD = 0;
	public final int ROAD = 1;
	private int[] sides;
	private boolean isEnd;
	private int x;
	private int y;
	private Follower follower;

	public Tile(int x, int y) {
		// Make this a method when merging
		sides = new int[] { 0, 1, 0, 1 };
		this.x = x;
		this.y = y;
	}
	
	public void makeEnd() {
		isEnd = true;
	}
	
	public void makeNotEnd() {
		isEnd = false;
	}
	
	public void setFollower(int player, int location){
		follower = new Follower(player, location);
		
	}
	
	public Follower getFollower(){
		return follower;
		
	}

	public boolean isEnd() {
		return isEnd;
	}

	public int getSide(int i) {
		return sides[i];
	}

	public boolean hasRoad() {
		for (int i = 0; i < SIDES; i++) {
			if (getSide(i) == ROAD) {
				return true;
			}
		}
		return false;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void placeFollower(int player, int location) {
		follower = new Follower(player, location);
	}
	
	public void removeFollower() {
		follower = null;
	}

}
