// Matt Cohen
// Ian McCabe
// Tommy White

public class Model {
	
	Direction dir = Direction.SE;
	final int canvasCount = 10;
    int picInd = 0;
    int counter = 0;
    int rightSide;
    int bottom;
    int imageWidth;
    int imageHeight;
    int jump = 1; // 1 = run, 2 = jump
    double xloc = 0;
    double yloc = 0;
    final double xIncr = 8;
    final double yIncr = 2;
    final static int jumpCount = 13;
    final static int jumpReset = 14;
    final static int runCount = 20;
    final static int leftSide = 0;
    final static int top = 0;
    
    public Model(int rightSide, int bottom, int imageWidth, int imageHeight) {
    	this.rightSide = rightSide;
    	this.bottom = bottom;
    	this.imageWidth = imageWidth;
    	this.imageHeight = imageHeight;
    }
    
    public double getX() {
    	return xloc;
    }
    
    public double getY() {
    	return yloc;
    }
    
    public Direction getDirection() {
    	return dir;
    }
    
    public int getJump() {
    	return jump;
    }
    
    public int getPicInd() {
    	return picInd;
    }
    
    public void updateLocationandDirection() {
    	switch (dir) {
	    	case NW:
	    		xloc -= xIncr;
	    		yloc -= yIncr;
	    		// Orc hits left side
	            if (xloc <  leftSide)
	            	dir = Direction.NE;
	            // Orc hits top
	            if (yloc < top)
	            	dir = Direction.SW;
	            break;
	    	case SW:
	    		xloc -= xIncr;
	    		yloc += yIncr;
	    		// Orc hits left side
	            if (xloc <  leftSide)
	            	dir = Direction.SE;
	            // Orc hits bottom
	            if (yloc > bottom - imageHeight)
	            	dir = Direction.NW;
	            break;
	    	case SE:
	    		xloc += xIncr;
	            yloc += yIncr;
	            // Orc hits right side
	            if (xloc > rightSide - imageWidth)
	            	dir = Direction.SW;
	            // Orc hits bottom
	            if (yloc > bottom - imageHeight)
	            	dir = Direction.NE;
	            break;
	    	case NE:
	    		xloc += xIncr;
	    		yloc -= yIncr;
	    		// Orc hits right side
	            if (xloc >  rightSide - imageWidth)
	            	dir = Direction.NW;
	            // Orc hits top
	            if (yloc < top)
	            	dir = Direction.SE;
	            break;
    	}
    	picInd = (picInd + 1) % canvasCount;
    	// reset counter after it reaches runCount
    	counter = (counter + 1) % runCount;
    	// Jump after counter exceed jumpCount
		jump = counter > jumpCount ? 1 : 0;
		if (counter == jumpReset)
			picInd = 0; //reset jump animation to avoid image flickering
    }
 }
