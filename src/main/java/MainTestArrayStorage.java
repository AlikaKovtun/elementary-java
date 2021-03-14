package main.java;

/**
 * Test for your ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        Employee employee1 = new Employee();
        employee1.setUuid("uuid1");
        Employee employee2 = new Employee();
        employee2.setUuid("uuid2");
        Employee employee3 = new Employee();
        employee3.setUuid("uuid3");
        Employee employee4 = new Employee();
        employee4.setUuid("uuid4");
        Employee employee5 = new Employee();
        employee5.setUuid("uuid5");

        ARRAY_STORAGE.save(employee1);
        ARRAY_STORAGE.save(employee2);
        ARRAY_STORAGE.save(employee3);
        ARRAY_STORAGE.save(employee4);
        ARRAY_STORAGE.save(employee5);

        System.out.println("Get employee1: " + ARRAY_STORAGE.get(employee1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        printAll();
        ARRAY_STORAGE.delete(employee1.getUuid());
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Employee employee : ARRAY_STORAGE.getAll()) {
            System.out.println(employee);
        }
    }
}
