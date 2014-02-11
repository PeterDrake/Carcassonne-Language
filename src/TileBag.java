
public class TileBag {

	private Tile[] tiles;
	
	public TileBag(){
		tiles = new Tile[71];
		
		tiles[0] = new Tile("03");
		tiles[1] = new Tile("00");
		tiles[2] = new Tile("01");
		tiles[3] = new Tile("02");
		
	}
	
	public Tile getTile(String tileID){
		for(int i = 0; i < tiles.length; i++){
			if (tiles[i] != null && tiles[i].getID().equals(tileID)){
				return tiles[i];
			}
		}
		return null;
	}
	
	public Tile getRandomTile(){
		return null;
	}
	
}
