package bmi;

import bmi.BodyMassIndex;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	public static double getUserWeight() {
		
		double weight = 0;
		while(weight > 0) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Please enter your weight in pounds: ");
			weight = scan.nextDouble();
			
		}
		return weight;
	
	}
	
	public static double getUserHeight() {
		
		double height = 0;
		while(height > 0) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Please enter your height in inches: ");
			height = scan.nextDouble();
			scan.nextLine();
		}
		return height;
	
	}
	
	public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
		
		bmiData.addAll(10, bmiData);
		bmiData.addAll(15, bmiData);
		bmiData.addAll(20, bmiData);
		int total = 0;
		int avg;
		for(int i = 0; i < bmiData.size(); i++)
		{
		    total = bmiData.get(i);
		    avg = total / bmiData.size();
		    System.out.println("The Average BMI score:" + avg);
		}
	
		
	}

	private static void displayBmiInfo(BodyMassIndex bmi) {
		
		System.out.println("Your BMI is: " + BodyMassIndex.bmi);
		System.out.println(BodyMassIndex.Category);
		
	}



	public static boolean moreInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like to continue? (Enter 'y' for yes, and 'n' for no) ");
		String choice = scan.nextLine();
		if(choice.equals("y") ) {
			return true;
		} else {
		return false;
		}
		
	}




	
	









	
	



}
