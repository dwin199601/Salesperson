import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;

public class DemoSalesperson {
    public static void main(String[] args) {

        double[] arrayforpersonOne = { 1200.6, 3200, 2300.9, 5090 };
        Salesperson demosalespersonOne = new Salesperson(0010, "Steve", "Jobs", arrayforpersonOne);

        double[] arrayforpersonTwo = { 2200.4, 1200, 3300.9, 2090 };
        Salesperson demosalespersonTwo = new Salesperson(0005, "Bill", "Gates", arrayforpersonTwo);

        double[] arrayforpersonThree = { 2700.4, 1280, 7300.9, 1090 };
        Salesperson demosalespersonThree = new Salesperson(1201, "Elon", "Mask", arrayforpersonThree);

        Scanner input = new Scanner(System.in);
        int ID;
        System.out.print("Enter your id pls: ");
        ID = input.nextInt();
        input.nextLine();
        System.out.print("Enter the first name : ");
        String fisrName = input.nextLine();

        System.out.print("Enter the last name: ");
        String lastName = input.nextLine();

        double[] QuarterlySalesAmount = new double[4];
        for (int i = 0; i < QuarterlySalesAmount.length; i++) {
            System.out.print("Enter the first sale amount for the " + (i + 1) + " quarter: ");
            QuarterlySalesAmount[i] = input.nextDouble();
        }
        Salesperson salespersonFromUserInput = new Salesperson(ID, fisrName, lastName, QuarterlySalesAmount);

        /* METHOD CALL TO FIND AVERAGE ANNUAL SALES AMOUNT */
        double average = AverageSalesAmount(demosalespersonOne.getAnualAmount(), demosalespersonTwo.getAnualAmount(),
                demosalespersonThree.getAnualAmount(), salespersonFromUserInput.getAnualAmount());
        System.out.println("Average annual amount among four salers: " + average);

        double numberOfSalesPerson = numberOfSales(average, demosalespersonOne.getAnualAmount(),
                demosalespersonTwo.getAnualAmount(), demosalespersonThree.getAnualAmount(),
                salespersonFromUserInput.getAnualAmount());
        System.out.println("The number of salesperson whose sales amount less than average: " + numberOfSalesPerson);

        Salesperson[] allpersons = { demosalespersonOne, demosalespersonTwo, demosalespersonThree,
                salespersonFromUserInput };

        sortAnnualSales(allpersons);
        for (int i = 0; i < allpersons.length; i++) {
            System.out.println(allpersons[i]);
        }

    }

    public static double AverageSalesAmount(double firstperson, double secondperson, double thirdperson,
            double lastpersn) {
        double avg;
        avg = (firstperson + secondperson + thirdperson + lastpersn) / 4;
        return avg;
    }

    public static double numberOfSales(double avg, double firstPer, double secondPer, double thirdPer,
            double lastPers) {
        int number = 0;
        if (firstPer < avg) {
            number++;
        }
        if (secondPer < avg) {
            number++;
        }
        if (thirdPer < avg) {
            number++;
        }
        if (lastPers < avg) {
            number++;
        }
        return number;
    }

    public static void sortAnnualSales(Salesperson[] newsalesperson) {
        Salesperson temp = new Salesperson();
        for (int i = 0; i < newsalesperson.length; i++) {
            for (int j = 0; j < newsalesperson.length - 1; j++) {
                if (newsalesperson[j].getAnualAmount() > newsalesperson[j + 1].getAnualAmount()) {
                    temp = newsalesperson[j];
                    newsalesperson[j] = newsalesperson[j + 1];
                    newsalesperson[j + 1] = temp;
                }
            }
        }

    }

}
