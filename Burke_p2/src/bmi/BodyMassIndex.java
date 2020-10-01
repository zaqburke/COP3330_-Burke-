package bmi;



public class BodyMassIndex {
	
	private double Height;
	private double Weight;
	static double bmi;
	static String Category;
	
	public BodyMassIndex(double Height, double Weight) {
		
		this.Height = Height;
		this.Weight = Weight;
		
	}


	public double getBmi() {
		bmi = (Weight * 703) / (Height * Height);
		return bmi;
	}


	public String getCategory() {
		if(bmi < 18.5) {
			System.out.println("You are underweight.");
		} else if(bmi < 24.91) {
			System.out.println("You are normal weight.");
		} else if(bmi < 29.91) {
			System.out.println("You are overweight.");
		} else {
			System.out.println("You are obese.");
		}
		
		return Category;
	}






	
}
