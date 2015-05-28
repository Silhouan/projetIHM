package application;

import javafx.beans.binding.When;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class WormView {
	Worm worm;
	SimpleIntegerProperty xPos;
	SimpleIntegerProperty yPos;
	SimpleIntegerProperty life;
	ImageView pic;
	
	public WormView(Worm w, Map map) {
		worm = w;
		xPos = new SimpleIntegerProperty();
		xPos.bindBidirectional(worm.xPosProperty());
		yPos = new SimpleIntegerProperty();
		yPos.bindBidirectional(worm.yPosProperty());
		life = new SimpleIntegerProperty();
		life.bindBidirectional(worm.lifeProperty());
		pic = new ImageView(new Image("Images/Worms/im1.png"));
		pic.setViewport(new Rectangle2D(15, 15, 30, 30));
		pic.scaleXProperty().bind(new When(w.isOnRight()).then(-1).otherwise(1));
		while ((map.getMap()[yPos.get() + 5][xPos.get() + 2]) == '1') {
			yPos.set(yPos.get() - 1);
		}
		while ((map.getMap()[yPos.get() + 6][xPos.get() + 2]) == '0') {
			yPos.set(yPos.get() + 1);
		}
		//Rectangle lifeBg= new Rectangle(30,3, Color.BLACK);
		//Rectangle lifeValue= new Rectangle(30,3, Color.GREEN);
	}
	
	public ImageView getPic() {
		return pic;
	}

	public Worm getWorm() {
		return worm;
	}

	public SimpleIntegerProperty xProperty() {
		return xPos;
	}
	
	public SimpleIntegerProperty yProperty() {
		return yPos;
	}
}
