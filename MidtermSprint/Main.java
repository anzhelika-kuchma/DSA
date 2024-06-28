package MidtermSprint;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {

    private static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add User");
            System.out.println("2. Add Task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Print Tasks");
            System.out.println("5. Print Users");
            System.out.println("6. Exit \n");

            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number from 1 to 6. \n");
                scanner.next();
                continue;
            }
            scanner.nextLine();

            String userName;
            String description;

            switch (choice) {
                case 1:
                    System.out.print("Enter user name: ");
                    String name = scanner.nextLine();
                    createUser(name);
                    break;
                case 2:
                    System.out.print("Enter user name: ");
                    userName = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    description = scanner.nextLine();
                    addTask(userName, description);
                    break;
                case 3:
                    System.out.print("Enter user name: ");
                    userName = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    description = scanner.nextLine();
                    markTaskAsCompleted(userName, description);
                    break;
                case 4:
                    System.out.print("Enter user name: ");
                    userName = scanner.nextLine();
                    printUserTasks(userName);
                    break;
                case 5:
                    for (User user : users) {
                        System.out.print(user.getName() + ", ");
                    }
                    System.out.println();
                    break;
                case 6:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice - Enter number from 1 - 6");
            }
        }
    }

    public static void createUser(String name) {

        User existing = findUser(name);
        if (existing != null) {
            System.out.println("User already exists");
            return;
        }
        User user = new User(name);
        users.add(user);
    }

    public static User findUser(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public static void addTask(String userName, String description) {
        User user = findUser(userName);
        if (user == null) {
            System.out.println("User not found");
        } else {
            user.addTask(description);
        }
    }

    public static void markTaskAsCompleted(String userName, String description) {
        User user = findUser(userName);
        if (user == null) {
            System.out.println("User not found");
        } else {
            user.markAsCompleted(description);
        }
    }

    public static void printUserTasks(String userName) {
        User user = findUser(userName);
        if (user == null) {
            System.out.println("User not found");
        } else {
            user.printTasks();
        }
    }
}
