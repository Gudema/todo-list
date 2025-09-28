package com.mycompany.exapp;

import java.util.ArrayList;
import java.util.Scanner;

public class ExApp {

    public static void main(String[] args) {
        ArrayList<String> taskNames = new ArrayList<>();
        ArrayList<String> taskPriorities = new ArrayList<>();
        ArrayList<Boolean> taskCompleted = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        OUTER:
        while (true) {
            System.out.println("\n=== TODO APP ===");
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Mark Task as Done");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter task name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter priority (low, medium, high): ");
                    String priority = sc.nextLine();

                    taskNames.add(name);
                    taskPriorities.add(priority);
                    taskCompleted.add(false);

                    System.out.println("Task added.");
                    break;

                case "2":
                    if (taskNames.isEmpty()) {
                        System.out.println("No tasks.");
                    } else {
                        for (int i = 0; i < taskNames.size(); i++) {
                            String status = taskCompleted.get(i) ? "Done" : "Pending";
                            System.out.println((i + 1) + ". " + taskNames.get(i)
                                    + " (" + taskPriorities.get(i) + ") - " + status);
                        }
                    }
                    break;

                case "3":
                    System.out.print("Enter task number to mark done: ");
                    try {
                        int idx = Integer.parseInt(sc.nextLine()) - 1;
                        if (idx >= 0 && idx < taskCompleted.size()) {
                            taskCompleted.set(idx, true);
                            System.out.println("Task marked as done.");
                        } else {
                            System.out.println("Invalid task number.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number.");
                    }
                    break;

                case "4":
                    System.out.print("Enter task number to delete: ");
                    try {
                        int idx = Integer.parseInt(sc.nextLine()) - 1;
                        if (idx >= 0 && idx < taskNames.size()) {
                            taskNames.remove(idx);
                            taskPriorities.remove(idx);
                            taskCompleted.remove(idx);
                            System.out.println("Task deleted.");
                        } else {
                            System.out.println("Invalid task number.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number.");
                    }
                    break;

                case "5":
                    System.out.println("Goodbye!");
                    break OUTER;

                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }

        sc.close();
    }
}
