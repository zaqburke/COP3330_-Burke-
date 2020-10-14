package shape;

public class Square extends Shape2D {
	
	protected double length;
    protected String name;
    public Square(double x){
        this.length = x;
        this.name = "square";
    }@Override
    public String getName(){
        return name;
    }@Override
    public double getArea(){
        return length * length;
    }
}
