
public class BridgePatternDemo {
    public static void main(String[] args) {

        Circle circle = new Circle(7, 8, 9);
        Rectangle rectangle = new Rectangle(4, 5, 6, 7);

        RedPen redPen = new RedPen();
        GreenPen greenPen = new GreenPen();

        redPen.drawCircle(circle.draw());
        greenPen.drawCircle(circle.draw());

        redPen.drawRectangle(rectangle.draw());

    }
}