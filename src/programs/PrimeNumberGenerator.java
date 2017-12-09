/*
 * PrimeNumberGenerator Class
 * Samuel Biondolillo
 * CIS210M:ZZ Data Structures and Elementary Algorithms
 * Goal: To print a list of all prime numbers from zero up to a given number
 * Version  0.0.1 - 9/10/17
 * 			0.0.2 - 9/21/17 	Adjusted program to run from menu. System.in does not close() from here anymore
 * 								Placed the logic to build the initial boolean[] into its own method
 * 								Added logic to avoid creating boolean[] with size <= 0
 */

package programs;
import java.util.Scanner;

public class PrimeNumberGenerator {

	/*
	 * Use the Seive of Eratosthenes to iterate over an array and identify composite numbers
	 * composite numbers set to false, primes left as true
	 */
	public static void identifyComposites(boolean[] numbers) {
		// outer loop counts one-by-one over the array elements
		for (int i = 0; i < numbers.length; i++) {
			
			// inner loop skip counts based on the index of the outer loop
			for (int j = i; j < numbers.length;) {
				
				// 0, 1 are not prime nor useful for skip counting
				if (j < 2) {
					numbers[j] = false;
					break;
				}
				
				// skip count to the next multiple
				j += i;
				
				// stop if we've counted too far
				if (j >= numbers.length) 
					break;
				else
					numbers[j] = false;
				
			}
		}
		
	}
	
	/*
	 * Traverse our array and print out all the prime indexes
	 * primes are true while composites are false
	 */
	public static void printPrimes(boolean[] primes) {
		for (int i = 0; i < primes.length; i++) {
			if (primes[i]) {
				System.out.println(i);
			}
		}
	}
	
	/* 
	 * Builds an array of booleans, all initially set to true
	 * @param count - the total number of booleans to allocate
	 */
	public static boolean[] buildArray(int count) {
		boolean[] boolArray = new boolean[count];
		for (int i = 0; i < boolArray.length; i++) {
			boolArray[i] = true;
		}
		return boolArray;
	}
	
	/*
	 * Main - gets a number from the user, produces a list of primes
	 * 		  the given number is not included in the list
	 */
	public static void main(String[] args) {
		// allow the user to specify how high to count
		Scanner input = new Scanner(System.in);
		System.out.println("This program will print all of the prime numbers counting up from zero to n, excluding n.");
		int primeCount = 0;
		System.out.println("How high would you like to count?");
		// force positive input
		while (primeCount <= 0) {
			System.out.print("Please enter a positive integer: ");
			primeCount = input.nextInt();
		}
		// input.close(); // uncomment this line if running this program stand-alone
		
		// create an array for seeding our methods
		boolean[] baseArray = buildArray(primeCount);
		
		// generate and display the prime numbers
		identifyComposites(baseArray);
		printPrimes(baseArray);
		System.out.println("These are all of the prime numbers from zero to " + primeCount + ".");

	}

}