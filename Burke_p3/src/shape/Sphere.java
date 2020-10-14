package shape;

public class Sphere extends Shape3D {
	protected double radius;
    protected String name;
	public Sphere(double r) {
		 this.radius = r;
	     this.name = "sphere";
	}@Override
	public String getName(){
        return name;
    }@Override
	 public double getArea(){
	        return (double) 4 * Math.PI * Math.pow(radius,2);
	    }@Override
	 public double getVolume(){
	        return (double) ((4.0 * Math.PI * Math.pow(radius,3))/3);
	    }

}
