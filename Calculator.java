import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {

    // History list to store all calculations
    static ArrayList<String> history = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("==========================================");
        System.out.println("   WELCOME TO CALCULATOR WITH HISTORY    ");
        System.out.println("          Made by BCA Student             ");
        System.out.println("==========================================");

        do {
            System.out.println("\n-------- MAIN MENU --------");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Modulus (%)");
            System.out.println("6. View History");
            System.out.println("7. Clear History");
            System.out.println("0. Exit");
            System.out.println("---------------------------");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    performOperation(sc, "+");
                    break;
                case 2:
                    performOperation(sc, "-");
                    break;
                case 3:
                    performOperation(sc, "*");
                    break;
                case 4:
                    performOperation(sc, "/");
                    break;
                case 5:
                    performOperation(sc, "%");
                    break;
                case 6:
                    viewHistory();
                    break;
                case 7:
                    clearHistory();
                    break;
                case 0:
                    System.out.println("\nThank you for using the Calculator! Bye :)");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 0);

        sc.close();
    }

    // Method to perform arithmetic operations
    static void performOperation(Scanner sc, String operator) {
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

        double result = 0;
        boolean valid = true;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    System.out.println("Error: Division by zero is not allowed!");
                    valid = false;
                } else {
                    result = num1 / num2;
                }
                break;
            case "%":
                if (num2 == 0) {
                    System.out.println("Error: Modulus by zero is not allowed!");
                    valid = false;
                } else {
                    result = num1 % num2;
                }
                break;
        }

        if (valid) {
            // Format result: show integer if no decimal part
            String resultStr = (result == (long) result)
                    ? String.valueOf((long) result)
                    : String.valueOf(result);

            String record = num1 + " " + operator + " " + num2 + " = " + resultStr;
            System.out.println("Result: " + record);
            history.add(record);
        }
    }

    // Method to view all history
    static void viewHistory() {
        System.out.println("\n-------- CALCULATION HISTORY --------");
        if (history.isEmpty()) {
            System.out.println("No history yet. Start calculating!");
        } else {
            for (int i = 0; i < history.size(); i++) {
                System.out.println((i + 1) + ". " + history.get(i));
            }
        }
        System.out.println("-------------------------------------");
    }

    // Method to clear history
    static void clearHistory() {
        history.clear();
        System.out.println("History cleared successfully!");
    }
}