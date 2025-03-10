import Facade.ShapeMaker;
import Facade.Shape;

public class FacadePatternDemo {
    public static void main(String[] args) {

        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.loadCache();

        Shape shape = shapeMaker.getShape("c001");

        shapeMaker.print(shape);

    }
}