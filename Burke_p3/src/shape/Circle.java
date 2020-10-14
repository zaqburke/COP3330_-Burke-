package shape;

public class Circle extends Shape2D {
	protected double radius;
    protected String name;
	public Circle(double r) {
		this.radius = r;
        this.name = "circle";
	}@Override
	public String getName(){
        return name;
    }@Override
	public double getArea(){
        return (double) Math.PI * radius * radius;
    }
}
