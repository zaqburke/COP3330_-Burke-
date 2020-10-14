package shape;

public class Pyramid extends Shape3D {
	 protected double base, width, height;
	 protected String name;
	public Pyramid(double base, double height, double width) {
		 this.base = base;
	     this.width = width;
	     this.height = height;
	     this.name = "pyramid";
	}
	@Override
	 public String getName(){
	        return name;
	    }
	@Override
	 public double getArea(){
	        return (double) (base * width) + base * Math.sqrt(Math.pow((width/2), 2) + Math.pow(height,2)) + width * Math.sqrt(Math.pow((base/2), 2) + Math.pow(height,2));
	    }
	@Override
	 public double getVolume(){
	        return (double)(base * width * height) / 3;
	    }
}
