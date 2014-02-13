import java.util.*;


public class TileBag {

	private ArrayList<Tile> tiles;
	public ArrayList<Tile> getTiles() { return tiles; }
	
	
	public TileBag(){
		tiles = new ArrayList<Tile>();
		
		int i = 0;
		for(i = 0; i < 8; i++){
			tiles.add(new Tile("00"));
		}
		for(i = 8; i < 17; i++){
			tiles.add(new Tile("01"));
		}
		for(i = 17; i < 21; i++){
			tiles.add(new Tile("02"));
		}
		for(i = 21; i < 22; i++){
			tiles.add(new Tile("03"));
		}
		for(i = 22; i < 25; i++){
			tiles.add(new Tile("04"));
		}
		for(i = 25; i < 30; i++){
			tiles.add(new Tile("10"));
		}
		for(i = 30; i < 33; i++){
			tiles.add(new Tile("11"));
		}
		for(i = 33; i < 36; i++){
			tiles.add(new Tile("12"));
		}
		for(i = 36; i < 39; i++){
			tiles.add(new Tile("13"));
		}
		for(i = 39; i < 41; i++){
			tiles.add(new Tile("20"));
		}
		for(i = 41; i < 42; i++){
			tiles.add(new Tile("21"));
		}
		for(i = 42; i < 44; i++){
			tiles.add(new Tile("22"));
		}
		for(i = 44; i < 46; i++){
			tiles.add(new Tile("23"));
		}
		for(i = 46; i < 49; i++){
			tiles.add(new Tile("24"));
		}
		for(i = 49; i < 50; i++){
			tiles.add(new Tile("30"));
		}
		for(i = 50; i < 52; i++){
			tiles.add(new Tile("31"));
		}
		for(i = 52; i < 55; i++){
			tiles.add(new Tile("32"));
		}
		for(i = 55; i < 57; i++){
			tiles.add(new Tile("33"));
		}
		for(i = 57; i < 60; i++){
			tiles.add(new Tile("34"));
		}
		for(i = 60; i < 64; i++){
			tiles.add(new Tile("40"));
		}
		for(i = 64; i < 66; i++){
			tiles.add(new Tile("41"));
		}
		for(i = 66; i < 67; i++){
			tiles.add(new Tile("42"));
		}
		for(i = 67; i < 70; i++){
			tiles.add(new Tile("43"));
		}
		for(i = 70; i < 71; i++){
			tiles.add(new Tile("44"));
		}
	}
	
	public Tile getTile(String tileID){
		for(int i = 0; i < tiles.size(); i++){
			if (tiles.get(i) != null && tiles.get(i).getID().equals(tileID)){
				return tiles.get(i);
			}
		}
		return null;
	}
	
	public Tile getRandomTile(){
		Random random = new Random();
		return tiles.remove(random.nextInt(tiles.size()));
	}
	
}
