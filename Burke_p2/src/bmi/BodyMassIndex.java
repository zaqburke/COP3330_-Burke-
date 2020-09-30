package bmi;



public class BodyMassIndex {
	
	private double Height;
	private double Weight;
	private double bmi;
	
	
	public BodyMassIndex(double Height, double Weight) {
		
		this.Height = Height;
		this.Weight = Weight;
		bmi = (Weight * 703) / (Height * Height);
	}


	public double getBmi() {
		return bmi;
	}






	
}
