public class Tile {

	public final int SIDES = 4;
	public final int FIELD = 0;
	public final int ROAD = 1;
	private int[] sides;
	private boolean isEnd;
	private int r;
	private int c;
	private Follower follower;

	public Tile(int r, int c, int[] sides, boolean isEnd) {
		// Make this a method when merging
		this.sides = sides;
		this.r = r;
		this.c = c;
		this.isEnd = isEnd;
	}
	
	public void makeEnd() {
		isEnd = true;
	}
	
	public void makeNotEnd() {
		isEnd = false;
	}
	
	public void setFollower(int player, int locationType, int location){
		follower = new Follower(player, locationType, location);
		
	}
	
	public Follower getFollower(){
		return follower;
		
	}

	public boolean isEnd() {
		return isEnd;
	}

	public int getSideType(int i) {
		return sides[i];
	}

	public boolean hasRoad() {
		for (int i = 0; i < SIDES; i++) {
			if (getSideType(i) == ROAD) {
				return true;
			}
		}
		return false;
	}

	public int getRow() {
		return r;
	}

	public int getCol() {
		return c;
	}

	public void placeFollower(int player, int locationType, int location) {
		follower = new Follower(player, locationType, location);
	}
	
	public void removeFollower() {
		follower = null;
	}

}
