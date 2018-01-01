import com.codeforart.DDDEngine.primitives.Point;
import com.codeforart.DDDEngine.primitives.Shape;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MyApplication extends Application {

    private final String OUTSIDE_TEXT = "HI";
    Shape shape;

    public MyApplication() {
        shape = new Shape.Builder().defaultTestShape();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Hello World");

        Canvas c = new Canvas(800, 600);
        GraphicsContext gc = c.getGraphicsContext2D();
        drawShapes(gc);

        Scene scene = new Scene(createLayout(new Label(), c));

        stage.setTitle("My JavaFX Application");
        stage.setScene(scene);
        stage.show();
    }

    private void drawShapes(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        shape.getEdges().forEach(e -> gc.strokeLine(e.getP().x, e.getP().y, e.getQ().x, e.getQ().y));

//        gc.strokeLine(40, 10, 10, 40);
//        gc.fillOval(10, 60, 30, 30);
//        gc.strokeOval(60, 60, 30, 30);
//        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
//        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
//        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
//        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
//        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
//        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
//        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
//        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
//        gc.fillPolygon(new double[]{10, 40, 10, 40},
//                new double[]{210, 210, 240, 240}, 4);
//        gc.strokePolygon(new double[]{60, 90, 60, 90},
//                new double[]{210, 210, 240, 240}, 4);
//        gc.strokePolyline(new double[]{110, 140, 110, 140},
//                new double[]{210, 210, 240, 240}, 4);
    }

    private Pane createLayout(final Label reporter, final Canvas canvas) {
        final Pane monitored = new Pane(reporter, canvas);

        monitored.setStyle("-fx-background-color: forestgreen; -fx-text-fill: white; -fx-font-size: 20px;");

        monitored.setOnMouseMoved(event -> {

            Point p = new Point(event.getX(), event.getY());
            String msg =
                    "(x: " + p.x + ", y: " + p.y + ") \n" +
                            "(sceneX: " + event.getSceneX() + ", sceneY: " + event.getSceneY() + ") \n" +
                            "(screenX: " + event.getScreenX() + ", screenY: " + event.getScreenY() + ")" + "\n" +
                            shape.contains(p);

            reporter.setText(msg);
        });

        monitored.setOnMouseClicked(event -> {
            System.out.println(event);
            shape.contains(new Point(event.getX(), event.getY()));
        });

//        monitored.setOnMouseExited(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                reporter.setText(OUTSIDE_TEXT);
//            }
//        });


        return monitored;
    }
}