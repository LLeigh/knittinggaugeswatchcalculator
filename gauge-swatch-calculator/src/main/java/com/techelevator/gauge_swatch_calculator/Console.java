package com.techelevator.gauge_swatch_calculator;

import java.util.Scanner;

public class Console {
	
	private static Scanner knitterInput = new Scanner(System.in);
	public Pattern pattern = new Pattern();
	public Knitter knitter = new Knitter();
	
	public void printBannerStart() {
		System.out.println("┏┓┏━┓━━━━━━━┏┓━━┏┓━━━━━━━━━━━━━━━┏━━━┓━━━━━━━━━━━━━━━━━	┏━━━┓━━━━━┏┓━━━━━━━━━┏┓━━━━━━━┏┓━━━━━━━━");
		System.out.println("┃┃┃┏┛━━━━━━┏┛┗┓┏┛┗┓━━━━━━━━━━━━━━┃┏━┓┃━━━━━━━━━━━━━━━━━	┃┏━┓┃━━━━━┃┃━━━━━━━━━┃┃━━━━━━┏┛┗┓━━━━━━━");
		System.out.println("┃┗┛┛━┏━┓━┏┓┗┓┏┛┗┓┏┛┏┓┏━┓━┏━━┓━━━━┃┃━┗┛┏━━┓━┏┓┏┓┏━━┓┏━━┓	┃┃━┗┛┏━━┓━┃┃━┏━━┓┏┓┏┓┃┃━┏━━┓━┗┓┏┛┏━━┓┏━┓");
		System.out.println("┃┏┓┃━┃┏┓┓┣┫━┃┃━━┃┃━┣┫┃┏┓┓┃┏┓┃━━━━┃┃┏━┓┗━┓┃━┃┃┃┃┃┏┓┃┃┏┓┃	┃┃━┏┓┗━┓┃━┃┃━┃┏━┛┃┃┃┃┃┃━┗━┓┃━━┃┃━┃┏┓┃┃┏┛");
		System.out.println("┃┃┃┗┓┃┃┃┃┃┃━┃┗┓━┃┗┓┃┃┃┃┃┃┃┗┛┃━━━━┃┗┻━┃┃┗┛┗┓┃┗┛┃┃┗┛┃┃┃━┫	┃┗━┛┃┃┗┛┗┓┃┗┓┃┗━┓┃┗┛┃┃┗┓┃┗┛┗┓━┃┗┓┃┗┛┃┃┃━");
		System.out.println("┗┛┗━┛┗┛┗┛┗┛━┗━┛━┗━┛┗┛┗┛┗┛┗━┓┃━━━━┗━━━┛┗━━━┛┗━━┛┗━┓┃┗━━┛	┗━━━┛┗━━━┛┗━┛┗━━┛┗━━┛┗━┛┗━━━┛━┗━┛┗━━┛┗┛━");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━┏━┛┃━━━━━━━━━━━━━━━━━━┏━┛┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━┗━━┛━━━━━━━━━━━━━━━━━━┗━━┛━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println();
		System.out.println("Welcome! I am here to help you figure out what size to knit for your gauge and pattern!");
		System.out.println("");
		System.out.println("You will need: ");
		System.out.println("1. Your pattern.");
		System.out.println("2. Your 4 inch (or cm) by 4 inch gauge swatch measurements - length & rows");
		System.out.println("3. Your desired measurements for the garment.");
		System.out.println("");
		System.out.println("Now, let's get started!");
		System.out.println("");		
		
	}
	
	public void askPatternGauge() {
		//Ask for pattern gauge
		System.out.println("What is the pattern's gauge? Enter length: ");
		double patternGaugeLength = Double.parseDouble(knitterInput.nextLine());
				
		System.out.println("Now enter rows: ");
		double patternGaugeRows = Double.parseDouble(knitterInput.nextLine());
		
		//return gauge to user to verify
		System.out.println("The pattern's gauge is " + patternGaugeLength + " x " + patternGaugeRows + ", correct? (Type yes or no): ");
		String yesOrNo = knitterInput.nextLine().toLowerCase();
		
		//if yes - continue, if no , start again		
			if (!yesOrNo.equals("yes")) {
			System.out.println("Ok, let's start over...");
			System.out.println();
			askPatternGauge();
			}
			pattern.setPatternGaugeLength(patternGaugeLength);
			pattern.setPatternGaugeRows(patternGaugeRows);
			askKnittersGauge();	
	}
	
	public void askKnittersGauge() {
		System.out.println("What is your gauge? Enter length: ");
		double knittersGaugeLength = Double.parseDouble(knitterInput.nextLine());
	
		System.out.println("Now enter rows: ");
		double knittersGaugeRows = Double.parseDouble(knitterInput.nextLine());
	
		//verify their gauge
		System.out.println("Your gauge is " + knittersGaugeLength + " x " + knittersGaugeRows + ", correct? (Type yes or no): ");
		String yesOrNo = knitterInput.nextLine().toLowerCase();
	
			if (!yesOrNo.equals("yes")) {
				System.out.println("Let's try that again...");
				System.out.println();
				askKnittersGauge();
			} 
			knitter.setKnitterGaugeLength(knittersGaugeLength);
			knitter.setKnitterGaugeRows(knittersGaugeRows);
			calculateWithLength();
	}
	
	public void calculateWithLength() {
		System.out.print("Input a length measurement (bust, body circumference, etc) that is closest to your own measurement: ");
		double lengthMeasurement = Double.parseDouble(knitterInput.nextLine());
		
		//Time to calculate!
		
		//calculate sts per inch
		double patternStByInch = pattern.getPatternGaugeLength() / 4;		
		double knittersStByInch = knitter.getKnitterGaugeLength() / 4;
		double patternStsInMeasurement = lengthMeasurement * patternStByInch;
		double knittersStsInMeasurement = lengthMeasurement * knittersStByInch;
		
		System.out.println();
		System.out.println("░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄");
		System.out.println("░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░");
		System.out.println("░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░");
		System.out.println("░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄");
		System.out.println("░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░");
		System.out.println("░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░");
		System.out.println("░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄");
		System.out.println("░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░");
		System.out.println("░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░");
		System.out.println();
		System.out.println("The measurement with pattern gauge (" + pattern.getPatternGaugeLength() + " x " + pattern.getPatternGaugeRows() + ") would be " + patternStsInMeasurement + " stitches.");
		System.out.println();
		System.out.println("With your gauge (" + knitter.getKnitterGaugeLength() + " x " + knitter.getKnitterGaugeRows() + "), you end up with " + knittersStsInMeasurement + " stitches.");
		System.out.println();
		System.out.println("Look at your pattern. Find where they define final stitch counts for the final length of area you chose to measure.");
		System.out.println();
		System.out.println("Pick the size of the pattern that is closest to stitch count. Most patterns define their stitch counts throughout the pattern.");
		System.out.println();
		System.out.println("░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄");
		System.out.println("░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░");
		System.out.println("░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░");
		System.out.println("░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄");
		System.out.println("░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░");
		System.out.println("░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░");
		System.out.println("░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄░▄░░░▄");
		System.out.println("░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░░░█▄█░");
		System.out.println("░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░░░░▀░░");
		System.out.println();

		
		askContinueOrExit();
	}
	
	public void askContinueOrExit() {
		System.out.println("What would you like to do next? Press number to select option...");
		System.out.println();
		System.out.println("1 - Enter another measurement for the same pattern");
		System.out.println("2 - Check gauge on another pattern (Start at beginning)");
		System.out.println("3 - Exit Knitting Gauge Calculator");
		
		String option = knitterInput.nextLine();
		
		if(option.equals("1")) {
			calculateWithLength();
			} else if (option.equals("2")) {
				printBannerStart();
			} else {
				System.out.println("|_  _  _  _     |  _ o|_|_o _  _ "); 
				System.out.println("| )(_||_)|_)\\/  |<| )||_|_|| )(_)");
				System.out.println("      |  |  /                 _/ ");
						
				System.exit(0);
		}
		
	}
}
