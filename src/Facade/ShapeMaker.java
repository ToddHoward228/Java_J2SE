package Facade;

public class ShapeMaker {

    public ShapeMaker() {
        shapeCache = new ShapeCache();
    }

    public void loadCache() {
        shapeCache.loadCache();
    }

    ShapeCache shapeCache;

    public Shape getShape(String id) {
        return shapeCache.getShape(id);
    }

    public void print(Shape shape) {
        System.out.println("\nID: " + shape.getId() + ", type: " + shape.getType());
    }
}
