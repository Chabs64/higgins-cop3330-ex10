package org.example;

/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 Chad Higgins
 */

/*
Working with multiple inputs and currency can introduce some tricky precision issues.

Create a simple self-checkout system. Prompt for the prices and quantities of three items.
Calculate the subtotal of the items. Then calculate the tax using a tax rate of 5.5%.
Print out the line items with the quantity and total, and then print out the subtotal, tax amount, and total.

Example Output
Enter the price of item 1: 25
Enter the quantity of item 1: 2
Enter the price of item 2: 10
Enter the quantity of item 2: 1
Enter the price of item 3: 4
Enter the quantity of item 3: 1
Subtotal: $64.00
Tax: $3.52
Total: $67.52

Constraints
Keep the input, processing, and output parts of your program separate.
Collect the input, then do the math operations and string building, and then print out the output.
Be sure you explicitly convert input to numerical data before doing any calculations.
 */

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the price of item 1: ");
        double cost1 = in.nextDouble();
        System.out.println("Enter the quantity of item 1: ");
        int amount1 = in.nextInt();

        System.out.println("Enter the price of item 2: ");
        double cost2 = in.nextDouble();
        System.out.println("Enter the quantity of item 2: ");
        int amount2 = in.nextInt();

        System.out.println("Enter the price of item 3: ");
        double cost3 = in.nextDouble();
        System.out.println("Enter the quantity of item 3: ");
        int amount3 = in.nextInt();

        double subtotal = getSubtotal(cost1, amount1, cost2, amount2, cost3, amount3);
        double taxRate = 0.055;
        double taxTotal = getTaxTotal(subtotal, taxRate);
        double total = getTotal(subtotal, taxRate);

        printTotals(subtotal, taxTotal, total);

    }

    private static void printTotals(double subtotal, double taxTotal, double total) {
        System.out.printf("Subtotal: $%.2f\nTax: $%.2f\nTotal: $%.2f", subtotal, taxTotal, total);
    }

    private static double getTaxTotal(double subtotal, double taxRate) {
        return subtotal * taxRate;
    }

    private static double getTotal(double subtotal, double taxRate) {
        return subtotal + (getTaxTotal(subtotal, taxRate));
    }

    private static double getSubtotal(double cost1, int amount1, double cost2, int amount2, double cost3, int amount3) {
        return cost1 * amount1 + cost2 * amount2 + cost3 * amount3;
    }
}
