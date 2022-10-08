package CurrencyConverter;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Double.parseDouble;

public class Main {

    public static void main (String[] args) {
        ArrayList<Results> valueList = new ArrayList<Results>();

        String StartOver = "y";

        String amount, choose;
        Coin coin;
        Scanner scanner = new Scanner(System.in);
        Coins typeToConvert = null;

        System.out.println("\nWelcome to currency converter");

        double amt = 0.0, value;
        boolean stopRun = false;

        // A loop that makes us start over whenever the user requests
        while (StartOver.charAt(0) == 'y' || StartOver.charAt(0) == 'Y') {
            typeToConvert = null;
            stopRun = false;
            System.out.println("\nPlease choose an option (1/2):\n" +
                    " 1. Dollars to Shekels\n 2. Shekels to Dollars");

            // Gets the type to convert
            while (typeToConvert == null) {

                choose = scanner.nextLine();
                if (choose.equals("1")) {
                    typeToConvert = Coins.USD;
                } else if (choose.equals("2")) {
                    typeToConvert = Coins.ILS;
                } else {
                    System.out.println("Invalid Choice, please try again");
                }
            }

            // Gets the amount to convert
            while (stopRun == false) {
                System.out.println("\nPlease enter an amount to convert");
                amount = scanner.nextLine();
                try {
                    amt = parseDouble(amount);
                    stopRun = true;
                } catch (Exception invalidString) {
                    System.out.println("\nInvalid Choice, please try again");
                }
            }

            // Computes the results and adds them to the list
            coin = CoinFactory.getCoinsInstance(typeToConvert);
            value = coin.calculate(amt);
            Results result = new Results(typeToConvert, value);
            valueList.add(result);
            System.out.printf("\nThe value is: %.2f\n", value);
            System.out.print("\nWould you like to start over?\n");
            StartOver = scanner.nextLine();

            // Prints error message if the input is invalid
            while (StartOver.length()==0){
                System.out.println("\nInvalid Choice, please try again");
                StartOver = scanner.nextLine();
            }

            // Prints error message if the input is invalid
            while (StartOver.charAt(0) != 'y' && StartOver.charAt(0) != 'Y' && StartOver.charAt(0) != 'n' &&
                    + StartOver.charAt(0) != 'N'){
                System.out.println("\nInvalid Choice, please try again");
                StartOver = scanner.nextLine();
            }
        }

        // End screen
        System.out.println("\nThanks for using our currency converter");
        for (Results result : valueList){
            System.out.println(result.convertToString());
        }
        // Writes to txt file
        File output = new File("results.txt");
        try{
            FileWriter fileWriter = new FileWriter("results.txt");
            for (Results result : valueList){
                fileWriter.write(result.convertToString()+"\n");
            }
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("Error while writing to file");
        }
    }
}
