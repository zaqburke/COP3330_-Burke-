package bmi;

import bmi.BodyMassIndex;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
	
	public static void main(String[] args) {
		
	    ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

	    while (moreInput()) {
	        double height = getUserHeight();
	        double weight = getUserWeight();

	        BodyMassIndex bmi = new BodyMassIndex(height, weight);
	        bmiData.add(bmi);

	        displayBmiInfo(bmi);
	    }

	    displayBmiStatistics(bmiData);
	}
	private static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
		// TODO Auto-generated method stub
		
	}
	private static boolean moreInput() {
		// TODO Auto-generated method stub
		return false;
	}
	public static void displayBmiInfo(BodyMassIndex bmi) {
		
		
	}

	public static double getUserWeight() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your Weight: ");
		scanner.nextDouble();
		return getUserWeight();
	}
	public static double getUserHeight() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your Height: ");
		scanner.nextDouble();
		return getUserHeight();
	}












	
	



}
