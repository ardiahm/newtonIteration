// this is part 4 (and final one) of the assignment

import java.util.ArrayList;

import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 ** Program which prompts user to enter a double 'epsilon' to dictate relative
 * error, and another double to see it's computed SQRT through Newton Iteration.
 *
 * @author Ardi Ahmed
 *
 */
public final class Newton4 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Newton4() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        // initialize SimpleReader
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        // pre-initialize variables outside of while loop so they can be accessible
        boolean loggedOut = false;
        char logPrompt;

        // prompt user to input epsilon outside of loop so we never have to ask again
        out.print("Input a value of epsilon (like 0.0001) to dictate relative error: ");
        final double epsilon = in.nextDouble();

        // while loggedOut hasn't changed
        while (!loggedOut) {
            // prompt user to enter a double and record their input
            out.print("Enter a double: ");
            double num = in.nextDouble();
            // immediately check if user inputs negative, in that case quit.
            if (num < 0) {
                loggedOut = true;
                out.print("Goodbye!");
                break;
            }

            // output calculated square root through calling sqrt() function
            out.print("The square root of " + num + " is: " + sqrt(num, epsilon) + "\n");
            // prompt user if they would like to continue and capture character input
            out.print("Would you like to continue? (input 'y' to continue) ");
            logPrompt = in.nextLine().charAt(0);
            // if they input anything but 'y', change value of loggedOut and break loop
            if (logPrompt != 'y') {
                out.print("Goodbye!");
                loggedOut = true;
            }

        }

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            - positive number, or ZERO, to compute square root of
     * @param epsilon
     *            - positive number (like 0.0001) which dictates relative error.
     *
     * @return estimate of square root
     *
     */
    private static double sqrt(double x, double epsilon) {

        // pre-initialize variables outside of loop
        boolean sqrtFound = false;
        double guess = 0;
        double estimate = 0;
        final double oneHalf = 0.5;

        // using an ArrayList here so we don't have to determine a size for the array
        // ... I find it more convenient to utilize dynamic sizing
        ArrayList<Double> listOfGuesses = new ArrayList<Double>();

        // first establish the first guess
        guess = x / 2;

        // immediately check if guess is equal to 0,
        // as that means the user inputed '0.0'
        if (guess == 0) {
            return guess;
        }

        // and estimate (second guess),
        // and add them to ArrayList
        listOfGuesses.add(guess);
        estimate = (guess + x / guess) * (oneHalf);
        listOfGuesses.add(estimate);

        // continue looping until the provided condition is met
        while (!sqrtFound) {

            if (Math.abs(listOfGuesses.getLast() * listOfGuesses.getLast() - x)
                    / x < (epsilon * epsilon)) {
                sqrtFound = true;
            } else {
                // if sqrt has not been found yet, replace guess
                // with the value of estimate
                // and calculate again
                guess = estimate;
                estimate = (guess + x / guess) * (oneHalf);
                listOfGuesses.add(estimate);
            }
        }

        // return the last value of listOfGuesses arrayList
        return listOfGuesses.get(listOfGuesses.size() - 1);

    }

}
