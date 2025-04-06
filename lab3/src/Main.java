import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main extends Application {

    private List<MyShape> shapes = new ArrayList<>();
    private Map<String, MyShape> shapeMap = new HashMap<>();
    private Pane canvas = new Pane();
    private ListView<String> shapeListView = new ListView<>();
    private ComboBox<String> filterComboBox = new ComboBox<>();
    private int shapeCount = 1;
    private MyShape highlightedShape = null;

    @Override
    public void start(Stage primaryStage) {
        Button addShapeBtn = new Button("Add Random Shape");
        addShapeBtn.setOnAction(e -> addRandomShape());

        filterComboBox.getItems().addAll("All", "Circle", "Rectangle", "Triangle");
        filterComboBox.setValue("All");
        filterComboBox.setOnAction(e -> filterShapes());

        shapeListView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        highlightShape(newValue);
                    }
                });

        HBox controls = new HBox(10, addShapeBtn, filterComboBox);
        VBox leftPanel = new VBox(10, new Label("Shape List"), shapeListView);
        leftPanel.setPrefWidth(200);

        BorderPane layout = new BorderPane();
        layout.setTop(controls);
        layout.setCenter(canvas);
        layout.setLeft(leftPanel);
        layout.setStyle("-fx-padding: 20");

        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setTitle("Shape Gallery - Polymorphism Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addRandomShape() {
        double x = Math.random() * 500;
        double y = Math.random() * 300;
        int r = (int) (Math.random() * 3);

        MyShape shape;
        String shapeName;

        switch (r) {
            case 0:
                shape = new MyCircle(x, y);
                shapeName = "Circle " + shapeCount++;
                break;
            case 1:
                shape = new MyRectangle(x, y);
                shapeName = "Rectangle " + shapeCount++;
                break;
            default:
                shape = new MyTriangle(x, y);
                shapeName = "Triangle " + shapeCount++;
                break;
        }

        shapes.add(shape);
        shapeMap.put(shapeName, shape);
        shape.draw(canvas);
        updateShapeList();
    }

    private void updateShapeList() {
        shapeListView.getItems().clear();
        shapeListView.getItems().addAll(shapeMap.keySet());
    }

    private void highlightShape(String shapeName) {
        if (highlightedShape != null) {
            highlightedShape.removeHighlight();
        }
        MyShape shape = shapeMap.get(shapeName);
        if (shape != null) {
            shape.highlight(canvas);
            highlightedShape = shape;
        }
    }

    private void filterShapes() {
        String filter = filterComboBox.getValue();
        shapeListView.getItems().clear();
        for (Map.Entry<String, MyShape> entry : shapeMap.entrySet()) {
            if (filter.equals("All") || entry.getKey().startsWith(filter)) {
                shapeListView.getItems().add(entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}