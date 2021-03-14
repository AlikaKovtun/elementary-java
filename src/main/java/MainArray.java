package main.java;

import java.util.Scanner;

public class MainArray {
    static final ArrayStorage ARRAY_STORAGE_2 = new ArrayStorage();

    public static void main(String[] args) {
        System.out.print("Введите одну из команд - (list | save uuid | delete uuid | get uuid | size | clear | exit): ");
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        while (!command.equals("exit")) {
            switch (command) {
                case "list":
                    printALL();
                    break;
                case "save uuid":
                    Employee e = new Employee();
                    e.setUuid(enterUuid());
                    ARRAY_STORAGE_2.save(e);
                    break;
                case "delete uuid":
                    ARRAY_STORAGE_2.delete(enterUuid());
                    printALL();
                    break;
                case "get uuid":
                    System.out.println(ARRAY_STORAGE_2.get(enterUuid()));
                    break;
                case "size":
                    System.out.println(ARRAY_STORAGE_2.size());
                    break;
                case "clear":
                    ARRAY_STORAGE_2.clear();
                    printALL();
                    break;
                default:
                    System.out.println("Неверная команда!");
            }
            System.out.print("Введите одну из команд - (list | save uuid | delete uuid | get uuid | size | clear | exit): ");
            command = scan.nextLine();
        }
    }

    private static void printALL() {
        Employee[] employees = ARRAY_STORAGE_2.getAll();
        for (int i = 0; i < employees.length; i++) {
            if (i == employees.length - 1) {
                System.out.println(employees[i]);
            }
            else {
                System.out.print(employees[i] + ", ");
            }
        }
    }

    private static String enterUuid() {
        System.out.print("Введите uuid: ");
        Scanner scan = new Scanner(System.in);
        String uuid = scan.nextLine();
        return uuid;
    }
}
