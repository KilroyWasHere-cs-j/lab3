import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.layout.Pane;
import javafx.scene.shape.StrokeType;

public class MyTriangle extends MyShape {

    private Polygon triangle;

    public MyTriangle(double x, double y) {
        super(x, y);
    }

    @Override
    public void draw(Pane pane) {
        triangle = new Polygon();
        triangle.getPoints().addAll(
                x, y,
                x + 40, y + 60,
                x - 40, y + 60
        );
        triangle.setFill(Color.TOMATO);
        pane.getChildren().add(triangle);
    }

    @Override
    public void highlight(Pane pane) {
        triangle.setStroke(Color.YELLOW);
        triangle.setStrokeWidth(3);
        triangle.setStrokeType(StrokeType.OUTSIDE);
    }

    public void removeHighlight() {
        triangle.setStroke(null);
    }
}