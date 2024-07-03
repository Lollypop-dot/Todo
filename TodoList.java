package Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoList {
    private List<String> tasks;

    public TodoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Задача добавлена: " + task);
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            String removedTask = tasks.remove(index);
            System.out.println("Задача удалена: " + removedTask);
        } else {
            System.out.println("Некорректный индекс задачи");
        }
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст");
        } else {
            System.out.println("Список задач:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        Scanner scanner = new Scanner(System.in);
        String command;

        do {
            System.out.println("Введите команду (add, remove, display, exit):");
            command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "add":
                    System.out.println("Введите задачу:");
                    String task = scanner.nextLine();
                    todoList.addTask(task);
                    break;
                case "remove":
                    System.out.println("Введите индекс задачи для удаления:");
                    int index = scanner.nextInt();
                    scanner.nextLine(); // очистка буфера после ввода числа
                    todoList.removeTask(index - 1);
                    break;
                case "display":
                    todoList.displayTasks();
                    break;
                case "exit":
                    System.out.println("Программа завершена");
                    break;
                default:
                    System.out.println("Некорректная команда");
                    break;
            }
        } while (!command.equalsIgnoreCase("exit"));

        scanner.close();
    }
}
