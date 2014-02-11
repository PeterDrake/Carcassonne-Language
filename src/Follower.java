
public class Follower {

	private int player;
	private int locationType;
	private int location;
	
	
	public Follower(int player, int locationType, int location){
		this.player = player;
		this.locationType = locationType;
		this.location = location;
	}

	public int getPlayer() {
		return player;
	}

	public void setPlayer(int player) {
		this.player = player;
	}

	public int getLocationType() {
		return locationType;
	}

	public void setLocationType(int locationType) {
		this.locationType = locationType;
	}
	
	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.locationType = location;
	}
	
	
}
