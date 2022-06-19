import java.text.NumberFormat;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR  = 12;
        final byte PERCENT = 100;

        int principle = 0;
        float monthlyInterest = 0;
        int numberOfPayments = 0;

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("Principle: ");
            principle = scanner.nextInt();
            if (principle >= 1000 && principle <= 1000000)
                break;
            System.out.println("Enter a value between 1000 and 1,000,000");
        }

        while(true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterestRate = scanner.nextFloat();
            if (annualInterestRate >= 0.1 && annualInterestRate <= 99.9) {
                monthlyInterest = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
                break;
            }
        }
        System.out.println("Enter a value between 0 and 100");

        while (true) {
            System.out.print("Period in Years: ");
            byte years = scanner.nextByte();
            if (years >= 1 && years <= 40) {
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 40");
        }

        double mortgage = principle * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
        / (Math.pow(1+ monthlyInterest, numberOfPayments)-1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}
