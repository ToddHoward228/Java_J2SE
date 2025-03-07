import java.util.HashMap;

public class ShapeCache {

    HashMap<String, Shape> shapeMap;

    public Shape getShape(String key){
        Shape shit = shapeMap.get(key);
        return (Shape) shit.clone();
    }

    public void loadCache(){
        shapeMap = new HashMap<>();

        Circle circle0 = new Circle();
        circle0.setId("c000");
        Circle circle1 = new Circle();
        circle1.setId("c001");
        Square square0 = new Square();
        square0.setId("s000");
        Square square1 = new Square();
        square1.setId("s001");
        Rectangle rectangle0 = new Rectangle();
        rectangle0.setId("r000");
        Rectangle rectangle1 = new Rectangle();
        rectangle1.setId("r001");

        shapeMap.put(circle0.getId(), circle0);
        shapeMap.put(circle1.getId(), circle1);
        shapeMap.put(square0.getId(), square0);
        shapeMap.put(square1.getId(), square1);
        shapeMap.put(rectangle0.getId(), rectangle0);
        shapeMap.put(rectangle1.getId(), rectangle1);
    }
}
