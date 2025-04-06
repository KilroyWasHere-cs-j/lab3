import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.layout.Pane;
import javafx.scene.shape.StrokeType;

public class MyCircle extends MyShape {

    private Circle circle;

    public MyCircle(double x, double y) {
        super(x, y);
    }

    @Override
    public void draw(Pane pane) {
        circle = new Circle(x, y, 30, Color.DODGERBLUE);
        pane.getChildren().add(circle);
    }

    @Override
    public void highlight(Pane pane) {
        circle.setStroke(Color.YELLOW);
        circle.setStrokeWidth(3);
        circle.setStrokeType(StrokeType.OUTSIDE);
    }

    public void removeHighlight() {
        circle.setStroke(null);
    }
}