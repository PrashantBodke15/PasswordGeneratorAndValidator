package PasswordGeneratorAndValidator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PasswordGenerator generator = new PasswordGenerator();

        int choice;

        do {
            System.out.println("\n===== PASSWORD GENERATOR =====");
            System.out.println("1. Generate Password");
            System.out.println("2. Validate Password");
            System.out.println("3. Show Password History");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        System.out.print("Enter password length: ");
                        int length = Integer.parseInt(sc.nextLine());

                        String password =
                            generator.generatePassword(length);

                        System.out.println(
                            "Generated Password: " + password);
                        break;

                    case 2:
                        System.out.print("Enter password: ");
                        String input = sc.nextLine();

                        PasswordValidator.validate(input);
                        break;

                    case 3:
                        generator.showHistory();
                        break;

                    case 4:
                        System.out.println("Thank you!");
                        break;

                    default:
                        System.out.println("Invalid menu choice.");
                }

            } catch (WeakPasswordException e) {
                System.out.println("Error: " + e.getMessage());

                choice = 0;

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                choice = 0;

            } catch (Exception e) {
                System.out.println("Unexpected error: "
                    + e.getMessage());
                choice = 0;
            }

        } while (choice != 4);

        sc.close();
    }
}


