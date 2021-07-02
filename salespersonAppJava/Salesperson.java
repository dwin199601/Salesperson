import java.text.DecimalFormat;
import java.util.ArrayList;

//import jdk.javadoc.internal.doclets.toolkit.resources.doclets;

public class Salesperson {
    private int digitalNumber;
    private String firstName;
    private String lastName;
    private double[] quarterlSalesAmount;
    private double anual;
    double array = 0;
    ArrayList<String> quarterList = new ArrayList<String>();

    public Salesperson(int IDnumber, String Fname, String Lname, double[] QuartSalaM) {
        digitalNumber = IDnumber;
        firstName = Fname;
        lastName = Lname;
        quarterlSalesAmount = QuartSalaM;

        for (double anualamount : QuartSalaM) {
            anual += anualamount;
        }

    }

    public Salesperson() {
        digitalNumber = 0000;
        firstName = "NONE";
        lastName = "NONE";
        anual = 0.0;

    }

    public double calculAnualSalesAmount() {

        double result = 0;
        for (int i = 0; i < quarterlSalesAmount.length; i++) {
            result += quarterlSalesAmount[i];
        }
        anual = result;

        return anual;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int GetDigitalNumber() {
        return digitalNumber;
    }

    public void setDigitalNumber(int DigNumber) {
        digitalNumber = DigNumber;
    }

    public void setquarterlSalesAmount(int arraydata, double salesamount) {
        quarterlSalesAmount[arraydata] = salesamount;
    }

    public double getquarterlSalesAmount(int data) {
        return quarterlSalesAmount[data];
    }

    public void setAnualAmount(double anual) {
        this.anual = anual;

    }

    public double getAnualAmount() {
        return anual;
    }

    public String toString() {

        for (int i = 0; i < quarterlSalesAmount.length; i++) {
            quarterList.add(" " + quarterlSalesAmount[i]);
        }

        // DecimalFormat df = new DecimalFormat("####");
        String padded = String.format("%04d", digitalNumber);

        return "ID " + padded + "\tName: " + firstName + " " + lastName + "\tQuarterly Sales Amount " + quarterList
                + "\tAnual amount: " + anual;
    }
}
