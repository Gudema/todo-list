import java.util.ArrayList;
import java.util.Scanner;

public class TodoApp {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = getChoice();
            switch (choice) {
                case 1 -> addTask();
                case 2 -> listTasks();
                case 3 -> markTaskDone();
                case 4 -> deleteTask();
                case 5 -> running = false;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\nTODO MENU:");
        System.out.println("1. Add Task");
        System.out.println("2. List Tasks");
        System.out.println("3. Mark Task as Done");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit");
        System.out.print("Enter choice: ");
    }

    private static int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void addTask() {
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();
        System.out.print("Enter priority (High/Medium/Low): ");
        String priority = scanner.nextLine();
        tasks.add(new Task(name, priority));
        System.out.println("Task added.");
    }

    private static void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private static void markTaskDone() {
        listTasks();
        System.out.print("Enter task number to mark as done: ");
        int index = getChoice() - 1;
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markDone();
            System.out.println("Task marked as done.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void deleteTask() {
        listTasks();
        System.out.print("Enter task number to delete: ");
        int index = getChoice() - 1;
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task deleted.");
        } else {
            System.out.println("Invalid task number.");
        }
    }
}
