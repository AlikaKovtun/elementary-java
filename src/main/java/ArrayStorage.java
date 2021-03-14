package main.java;

/**
 * Array based storage for Employees
 */
public class ArrayStorage {
    private Employee[] storage = new Employee[10000];
    private int empCounter = 0;

    void clear() {
        //Получаем количество сохраненных работников и обнуляем их в массиве
        int numberOfEmp = size();
        for (int i = 0; i < numberOfEmp; i++) {
            storage[i] = null;
        }
        empCounter = 0;
        System.out.println("The list is clear!");
    }

    void save(Employee employee) {
        //Проверяем нет ли такого работника уже в списке
        for (Employee e : storage) {
            if (e != null && e.getUuid().equals(employee.getUuid())) {
                System.out.println("Employee " + employee + " is already saved");
                return;
            }
        }
        //Если количество сотрудников равно длине массива, то выводим сообщение о заполнении списка
        int numberOfEmp = size();
        if (numberOfEmp == storage.length) {
            System.out.println("Cannot be saved. The list is full!");
            return;
        }
        //Сохраняем сотрудника в первой пустой ячейке
        //Выводим сообщение об удачном сохранении и выходим из метода
        storage[numberOfEmp] = employee;
        empCounter++;
        System.out.println("Employee " + employee + " saved!");
    }

    Employee get(String uuid) {
        int index = equalsEmpUuid(uuid);
        Employee temp = null;
        if (index != -1) {
            temp = storage[index];
        }
        if (temp == null) {
            System.out.println("The list doesn't contain an employee with such uuid");
            return null;
        }
        return temp;
    }

    //Так как сортировка не нужна, делаем максимально не затратно:
    //Находим нужного работника на удаление и помещаем в эту ячейку последнего работника в списке
    //Если работника с таким uuid нет, выводим сообщение об ошибке
    void delete(String uuid) {
        int index = equalsEmpUuid(uuid);
        int numberOfEmp = size();
        if (index != -1) {
            storage[index] = storage[numberOfEmp - 1];
            storage[numberOfEmp - 1] = null;
            System.out.println("Employee " + uuid + " deleted");
            empCounter--;
            return;
        }
        System.out.println("The list doesn't contain an employee with such uuid");
    }

    /**
     * @return array, contains only Employees in storage (without null)
     */
    Employee[] getAll() {
        //Создаем новый массив под количество сохраненных работников и копируем их из основного массива
        int numberOfEmp = size();
        Employee[] newEmp = new Employee[numberOfEmp];
        for (int i = 0; i < numberOfEmp; i++) {
            newEmp[i] = storage[i];
        }
        //Возвращаем новый массив без null
        return newEmp;
    }

    int size() {
        return empCounter;
    }

    private int equalsEmpUuid(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
