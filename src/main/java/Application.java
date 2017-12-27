import com.codeforart.DDDEngine.Shape;

public class Application {
    public static void main(String[] args) {
        Shape shapeA = new Shape.Builder().build();

        System.out.println(shapeA);
    }
}