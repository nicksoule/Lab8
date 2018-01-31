
/*
 * Nicholas Soule
 * Lab 8 - calculate batting averages
 */

import java.util.Arrays;
import java.util.Scanner;

public class BattingAverageCalculator {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numBats;
		int result;
		double bases = 0.0;
		double basesEarned = 0.0;
		double battingAvg;
		double sluggingAvg;
		String cont = "Y";

		System.out.println("Welcome to the Batting Average Calculator!");

		while (cont == "Y") {
			// prompts user to enter number of times at bat and validates that the entry is
			// a number
			numBats = Validator.getInt(scan, "\n" + "Please enter number of times at bat:");
			// integer array that can store date for the number of times at bat
			int[] stats = new int[numBats];
			System.out.println("0 = out, 1 = single, 2 = double, 3 = triple, 4 = home run");
			// for loop that cycles through each index and asks for the at-bat results
			for (int i = 0; i < stats.length; i++) {
				result = Validator.getInt(scan, "Result for at-bat " + (i + 1) + ":", 0, 4);
				stats[i] = result;
				// assigns bases and basesEarned with information needed to do future
				// calculations
				if (result >= 1) {
					bases = bases + 1;
					basesEarned = basesEarned + result;
				}
			}
			// calculate averages then print them and ask if the user wants to continue
			battingAvg = bases / numBats;
			sluggingAvg = basesEarned / numBats;
			System.out.println("Batting average: " + String.format("%.3f", battingAvg));
			System.out.println("Slugging Percentage: " + String.format("%.3f", sluggingAvg));
			cont = Validator.getString(scan, "Another Batter? y/n", "Y", "N");
		}
		System.out.println("Goodbye!");
	}

}
