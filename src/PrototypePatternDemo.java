
public class PrototypePatternDemo {
    public static void main(String[] args) {

        ShapeCache shapeCache = new ShapeCache();
        shapeCache.loadCache();

        Shape c1 = shapeCache.getShape("c000");
        System.out.println("\tCircle 1\nID: " + c1.getId() + ", type: " + c1.getType());

        Shape c2 = shapeCache.getShape("c001");
        System.out.println("\tCircle 2\nID: " + c2.getId() + ", type: " + c2.getType());

        Shape r1 = shapeCache.getShape("r000");
        System.out.println("\tRectangle 1\nID: " + r1.getId() + ", type: " + r1.getType());

        Shape r2 = shapeCache.getShape("r001");
        System.out.println("\tRectangle 2\nID: " + r2.getId() + ", type: " + r2.getType());

        Shape s1 = shapeCache.getShape("s000");
        System.out.println("\tSquare 1\nID: " + s1.getId() + ", type: " + s1.getType());

        Shape s2 = shapeCache.getShape("s001");
        System.out.println("\tSquare 2\nID: " + s2.getId() + ", type: " + s2.getType());
    }
}