public class Rectangle extends Shape{
    private int width, height;
    private int x, y;

    public Rectangle(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public String draw(){
        return String.format("x = %d, y = %d, width = %d, height = %d", x, y, width, height);
    }
}
