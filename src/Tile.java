
public class Tile {
	
	private String ID;
	private int x;
	private int y;
	
	public Tile(String ID){
		this.ID = ID;
	}
	
	public void setCoords(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public String getID(){
		return ID;
	}
	
}
