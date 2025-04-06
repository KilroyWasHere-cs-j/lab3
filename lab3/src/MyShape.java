import javafx.scene.layout.Pane;

public abstract class MyShape {

    protected double x, y;

    public MyShape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract void draw(Pane pane);

    public abstract void highlight(Pane pane);
}