/*
 * This progam uses the Triangle class to give the user information about the
 * triangle they have inputted.
 *
 * @author  Ryan Chung
 * @version 1.0
 * @since   2022-01-06
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/** This is a stub program for the Vehicle subclasses. */
final class Main {

    /**
     * Prevents instantiation.
     * Throw an exception IllegalStateException when called.
     *
     * @throws IllegalStateException shouldn't be instantiated
     */
    private Main() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * Reusable user input catcher.
    *
    * @param prompt prompt to display to the user
    * @return input as an int
    * @throws IOException if anything unexpected happens
    */
    private static double userInput(final String prompt) throws IOException {
        System.out.print(prompt);

        final String inputString = new BufferedReader(
                new InputStreamReader(System.in)
        ).readLine();

        return Double.parseDouble(inputString);
    }

    /**
     * Gets user input for the 3 sides and displays info about the triangle.
     *
     * @param args No args will be used.
     */
    public static void main(final String[] args) {
        try {
            final Triangle triangle = new Triangle(
                userInput("Side 1: "),
                userInput("Side 2: "),
                userInput("Side 3: ")
            );

            System.out.println(
                "\nType: " + triangle.getName()
                + "\nArea: " + triangle.getArea()
                + "\nPerimeter: " + triangle.getPerimeter()
                + "\nSemiperimeter: " + triangle.getSemiperimeter()
                + "\nAngles (in order): "
                + Arrays.toString(triangle.getAngles())
                + "\nHeights (in order): "
                + Arrays.toString(triangle.getHeights())
                + "\nIncircle Radius: " + triangle.getIncircleRadius()
                + "\nCircumcircle Area: " + triangle.getCircumcircleArea()
            );

        } catch (IOException | NumberFormatException exception) {
            System.out.println("Please enter a valid input.");
        } catch (ArithmeticException exception) {
            System.out.println("Please enter a valid triangle.");
        } finally {
            System.out.println("\nDone.");
        }
    }
}

