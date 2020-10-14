package shape;

public class Cube extends Shape3D{
	protected double base;
    protected String name;
	public Cube(double base) {
		this.base = base;
        this.name = "cube";
    }@Override
	 public String getName(){
	        return name;
	}@Override
	 public double getArea(){
	        return (double) 6 * base * base;
	    }@Override
	 public double getVolume(){
	        return (double) base * base * base;
	    }
}



