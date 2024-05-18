package Arrays;

import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // taking an input from the user
        System.out.println("How many inputs do you want to compare? Enter the number: ");
        int numInput = scanner.nextInt();

        // prompting the user to enter all the inputs
        System.out.println("Enter " + numInput + " inputs: ");
        double[] temperatures = new double[numInput];
        double sum = 0;
        for (int i = 0; i < numInput; i++) {
            temperatures[i] = scanner.nextDouble();
            sum += temperatures[i];
        }

        // calculating the average temperature
        double averageTemp = (double) sum / numInput;

        // calculating the number of temperatures above average
        int aboveAverage = 0;
        for (double temperature : temperatures) {
            if (temperature > averageTemp) {
                aboveAverage++;
            }
        }

        // Give results
        System.out.println("The average temperature is " + averageTemp);
        System.out.println("The number of temperatures above average is " + aboveAverage);

        scanner.close();
    }
}