package lab1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Function that returns the square of a number
    public static int square(int number) {
        return number * number;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();

        try {
            System.out.print("How many names do you want to enter? ");
            int count = Integer.parseInt(input.nextLine());

            for (int i = 0; i < count; i++) {
                System.out.print("Enter a name: ");
                String name = input.nextLine();

                if (!name.isEmpty()) {
                    names.add(name);
                } else {
                    System.out.println("Name cannot be empty.");
                }
            }

            // Print names and length of each name
            for (String name : names) {
                System.out.println(name + " has " + name.length() + " letters.");
            }

            // Write names to a file
            FileWriter file = new FileWriter("names.txt");
            for (String name : names) {
                file.write(name + "\n");
            }
            file.close();

            // Use a simple function
            System.out.print("Enter a number to square: ");
            int number = Integer.parseInt(input.nextLine());
            System.out.println("Square is: " + square(number));

        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }

        input.close();
    }
}
