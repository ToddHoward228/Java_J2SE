public class Circle extends Shape {
    private int radius;
    private int x;
    private int y;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public String draw() {
        return String.format("x = %d, y = %d, Radius = %d", x, y, radius);
    }
}
