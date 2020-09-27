/**
 * This is the driver class to create a game for users to guess random numbers using the methods of 
 * RandomNumberGuesser class.
 * 
 * @author Derya O. Kurin
 */

package o_Kurin_D_Assignment2;

import java.util.Scanner;

public class RandomNumberGuesser {
	//Data field 
	public static Boolean repeat = true;
	//store the random number in secretNumber
	public static int secretNumber = RNG.rand();
	public static int guess;
	//Initializing lowGuess and highGuess
	public static int lowGuess = 1;
	public static int highGuess = 100;

	
	
	public static void main(String[] args) {
		
      // Create an instance of Scanner class
		Scanner stdin = new Scanner(System.in);
		// Program header
		    System.out.println("-------Random Number Guesser------\n\n");
		
			System.out.println("Enter your first guess between 0 and 100");
			guess = stdin.nextInt();
			/**
			 * A do/while loop for iterating the games as long as user want to do so
			 */
			do {
				/**
				 * getCount from RNG and print it out
				 */
				System.out.println("Number of guesses is " + RNG.getCount());
				/**
				 * if/else block to evaluate how the program will react to user guesses
				 */
				if(guess > secretNumber) {
					/**
					 * A nested if/else statement calling inputValidation for checking 
					 * if guess value is within the boundaries 
					 */
				    if(RNG.inputValidation(guess, lowGuess, highGuess) == false) {
				    	guess = stdin.nextInt();
				    	continue;
				    }
					System.out.println("Your guess is too high");	
					// Setting the highGuess to guess if the guess is high
					highGuess = guess;
					System.out.println("Enter your guess between "+lowGuess+" and "+highGuess+ ".");
				    
				} else if(guess < secretNumber) {
					if(RNG.inputValidation(guess, lowGuess, highGuess) == false) {
				    	guess = stdin.nextInt();
				    	continue;
				    }
					System.out.println("Your guess is too low");
					// Setting the lowGuess to guess if the guess is low
					lowGuess = guess;
					System.out.println("Enter your guess between "+lowGuess+" and "+highGuess+ ".");
					// If the user guesses random number correctly prints it out 
					//and ask if the user want to play again
				} else {
					System.out.println("Congratulations, you guessed correctly");
					System.out.println("Try again? (yes or no)");
					if(stdin.next().equals("no")) {
						System.out.println("Thanks for playing...");
						//Setting repeat to false to terminate the loop
						repeat = false;
					// Otherwise rest the game count, highGuess, lowGuess and prompt use to enter 1st guess
					} else {
						RNG.resetCount();
						repeat = true;
						lowGuess = 0;
						highGuess = 0;
						System.out.println("Enter your first guess between 0 and 100");
					}
				}
	            //Storing user input in guess
				guess = stdin.nextInt();

			} while(repeat);

		System.out.println("\n\nProgrammer Name: Derya O. Kurin");

	}
}



