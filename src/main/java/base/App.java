package base;

import java.util.Scanner;

/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright Marc-Anthony Cross
 */

/*
 * You don’t always need a complex control structure to solve simple problems. Sometimes a program requires an extra
 * step in one case, but in all other cases there’s nothing to do.
 *
 *         Write a simple program to compute the tax on an order amount. The program should prompt for the order
 *         amount and the state. If the state is “WI,” then the order must be charged 5.5% tax. The program should
 *         display the subtotal, tax, and total for Wisconsin residents but display just the total for non-residents.
 *         Example Output
 *
 *         What is the order amount? 10
 *         What is the state? WI
 *         The subtotal is $10.00.
 *         The tax is $0.55.
 *         The total is $10.55.
 *
 *         Or
 *
 *         What is the order amount? 10
 *         What is the state? MN
 *         The total is $10.00
 *         Constraints
 *
 *         Implement this program using only a simple if statement—don’t use an else clause.
 *         Ensure that all money is rounded up to the nearest cent.
 *         Use a single output statement at the end of the program to display the program results.
 *
 *         Challenges
 *
 *         Allow the user to enter a state abbreviation in upper, lower, or mixed case.
 *         Also allow the user to enter the state’s full name in upper, lower, or mixed case.
 */

public class App {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String orderAmt = getOrderAmt();
        String state = getState();
        String subtotal = convertToSubtotal(orderAmt);
        String tax = calcTax(orderAmt, state);
        String total = calcTotal(subtotal, tax);
        String outputString = generateOutput(subtotal, tax, total);
        System.out.println(outputString);
    }

    public static String getOrderAmt() {
        System.out.print("What is the order amount? ");
        return in.nextLine();
    }

    public static String getState() {
        System.out.print("What is the state? ");
        return in.nextLine();
    }

    public static String convertToSubtotal(String orderAmount) {
        Double subtotal = Double.parseDouble(orderAmount);
        return String.valueOf(subtotal);
    }

    public static String calcTotal(String subtotal, String tax) {
        if (tax.equals(""))
            return subtotal;
        double total = Double.parseDouble(subtotal) + Double.parseDouble(tax);
        return String.valueOf(total);
    }

    public static String calcTax(String orderAmount, String state) {
        if (state.equals("WI")) {
            double tax = Integer.parseInt(orderAmount) * 0.055;
            return String.valueOf(tax);
        }
        return "";
    }

    public static String generateOutput(String subtotal, String tax, String total) {
        if (tax.equals(""))
            return String.format("The total is %.2f", Double.parseDouble(total));
        return String.format("The subtotal is %.2f.\nThe tax is %.2f.\nThe total is %.2f.",
                                    Double.parseDouble(subtotal), Double.parseDouble(tax), Double.parseDouble(total));
    }
}
