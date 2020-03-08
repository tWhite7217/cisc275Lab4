// Matt Cohen
// Ian McCabe
// Tommy White

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class View {
	
	final static int canvasWidth = 500;
    final static int canvasHeight = 300;
    final static int imgWidth = 165;
    final static int imgHeight = 165;
    Image currentImg;
    
    Image[] images = new Image[8];
    
    GraphicsContext gc;
    
    public View(Stage theStage) {	
    	theStage.setTitle("Orc");

        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);

        Canvas canvas = new Canvas(canvasWidth, canvasHeight);
        root.getChildren().add(canvas);
        gc = canvas.getGraphicsContext2D();
        
        
        Direction[] dirs = Direction.values();
        for (Direction dir: dirs) {
        	images[dir.ordinal()] = createImage("orc_forward_" + dir.getName());
        }
        for (Direction dir: dirs) {
        	images[dir.ordinal()+4] = createImage("orc_jump_" + dir.getName());
        }
    }
	
	public int getHeight() {
		return canvasHeight;
	}
	
	public int getWidth() {
		return canvasWidth;
	}
	
	public int getImageHeight() {
		return imgHeight;
	}
	
	public int getImageWidth() {
		return imgWidth;
	}
	
	public void update(double xloc, double yloc, Direction dir, int jump, int picInd) {
		currentImg = images[dir.ordinal() + (4 * jump)];
		// Clear the canvas
        gc.clearRect(0, 0, canvasWidth, canvasHeight);

        // draw the subimage from the original png to animate the orc's motion
        gc.drawImage(currentImg, imgWidth*picInd, 0, imgWidth, imgHeight,
                            xloc, yloc, imgWidth, imgHeight);
	}
	
	//Read image from file and return
    private Image createImage(String imgName) {
        Image img = new Image("images/orc/" + imgName + ".png");
        return img;
    }
	
}
