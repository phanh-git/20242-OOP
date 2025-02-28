import java.util.Scanner;

public class Calculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        String strNum1 = scanner.nextLine();

        System.out.print("Enter the second number: ");
        String strNum2 = scanner.nextLine();

        double num1 = Double.parseDouble(strNum1); // convert from string to double
        double num2 = Double.parseDouble(strNum2);

        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;

        System.out.println("The sum of two numbers is " + sum);
        System.out.println("The difference of two numbers is " + difference);
        System.out.println("The product of two numbers is " + product);

        if(num2 != 0){
            double quotient = num1 / num2;
            System.out.println("The quotient of two numbers is " + quotient);
        }else {
            System.out.println("Division by zero is undefined.");
        }
    }
}