import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Pane;
import javafx.scene.shape.StrokeType;

public class MyRectangle extends MyShape {

    private Rectangle rectangle;

    public MyRectangle(double x, double y) {
        super(x, y);
    }

    @Override
    public void draw(Pane pane) {
        rectangle = new Rectangle(x, y, 60, 40);
        rectangle.setFill(Color.FORESTGREEN);
        pane.getChildren().add(rectangle);
    }

    @Override
    public void highlight(Pane pane) {
        rectangle.setStroke(Color.YELLOW);
        rectangle.setStrokeWidth(3);
        rectangle.setStrokeType(StrokeType.OUTSIDE);
    }

    public void removeHighlight() {
        rectangle.setStroke(null);
    }
}