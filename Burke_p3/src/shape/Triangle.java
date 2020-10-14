package shape;

public class Triangle extends Shape2D {
	protected double base;
	protected double height;
    protected String name;
    public Triangle(double base, double height){
        this.base = base;
        this.height = height;
        this.name = "triangle";
    }@Override
    public String getName(){
        return name;
    }@Override
    public double getArea(){
        return (base * height * 0.5);
    }
}
