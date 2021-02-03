package com.techelevator.gauge_swatch_calculator;

import java.util.Scanner;

public class GaugeSwatchCalculator {
	
	private static Scanner knitterInput = new Scanner(System.in);
		
	public static void main(String[] args) {
		
	System.out.println("************************************");
	System.out.println("*                                  *");
	System.out.println("*     Knitting Gauge Calculator    *");
	System.out.println("*                                  *");
	System.out.println("************************************");
		
	//Ask user for what kind of pattern they are using?	
	
		
		
	//Ask for pattern gauge
	System.out.println("What is the pattern's gauge? Enter length: ");
	double patternGaugeLength = Double.parseDouble(knitterInput.nextLine());
	
	
	System.out.println("Now enter rows: ");
	double patternGaugeRows = Double.parseDouble(knitterInput.nextLine());
	
	//return gauge to user to verify
	System.out.println("The pattern's gauge is " + patternGaugeLength + " x " + patternGaugeRows + ", correct? (Type yes or no): ");
	String yesOrNo = knitterInput.nextLine();
	//if yes - continue, if no , start again
	if (yesOrNo.equals("no") || yesOrNo.equals("No") || yesOrNo.equals("NO")) {
		System.out.println("Start Over");
	} 
		//Ask for users gauge
	System.out.println("What is your gauge? Enter length: ");
	double knittersGaugeLength = Double.parseDouble(knitterInput.nextLine());
	
	System.out.println("Now enter rows: ");
	double knittersGaugeRows = Double.parseDouble(knitterInput.nextLine());
	
	//verify their gauge
	System.out.println("Your gauge is " + knittersGaugeLength + " x " + knittersGaugeRows + ", correct? (Type yes or no): ");
	yesOrNo = knitterInput.nextLine();
	
	if (yesOrNo.equals("no") || yesOrNo.equals("No") || yesOrNo.equals("NO")) {
		System.out.println("Start Over");
	} 
	
	System.out.print("Input a length measurement (bust, body circumference, etc) that is closest to your own measurement: ");
	double lengthMeasurement = Double.parseDouble(knitterInput.nextLine());
	
	//Time to calculate!
	
	//calculate sts per inch
	double patternStByInch = patternGaugeLength / 4;		
	double knittersStByInch = knittersGaugeLength / 4;
	
	//calculate st per measurement
	double patternStsInMeasurement = lengthMeasurement * patternStByInch;
	double knittersStsInMeasurement = lengthMeasurement * knittersStByInch;
	
	System.out.println("The measurement with pattern gauge(" + patternGaugeLength + " x " + patternGaugeRows + ") would be " + patternStsInMeasurement + " stitches.");
	System.out.println();
	System.out.println("With your gauge (" + knittersGaugeLength + " x " + knittersGaugeRows+ "), you end up with " + knittersStsInMeasurement + " stitches.");
	System.out.println();
	System.out.println("Pick the size of the pattern that is closest to stitch count. If you need to check another length measurement, start program over to do so.");
	
	//Ask for a length measurement that is closest to their measurement
		//will need kind of measurement (bust, sleeve, body circumference)
	
	
	//Calculate pattern gauge stitch count vs User stitch count so they can pick what size to knit
//	System.out.println("You should knit the pattern with the closest stitch count to " + knittersLengthStitchCount + ".");
	}
}
