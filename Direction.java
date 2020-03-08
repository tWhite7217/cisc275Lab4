// Matt Cohen
// Ian McCabe
// Tommy White

public enum Direction {

	NE("northeast"),
	SE("southeast"),
	SW("southwest"),
	NW("northwest");
	
	private String name = null;
	
	private Direction(String s){
		name = s;
	}
	public String getName() {
		return name;
	}


}
