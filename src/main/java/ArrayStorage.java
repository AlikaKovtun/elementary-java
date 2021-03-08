package main.java;

/**
 * Array based storage for Employees
 */
public class ArrayStorage {
    Employee[] storage = new Employee[10000];

    void clear() {
        //Получаем количество сохраненных работников и обнуляем их в массиве
        int numberOfEmp = size();
        for (int i = 0; i < numberOfEmp; i++) {
            storage[i] = null;
        }
        System.out.println("The list is clear!");
    }

    void save(Employee employee) {
        //Проверяем нет ли такого работника уже в списке
        for (Employee e : storage) {
            if (e != null && e.uuid.equals(employee.uuid)) {
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
        System.out.println("Employee " + employee + " saved!");
    }

    Employee get(String uuid) {
        int numberOfEmp = size();
        Employee temp = null;
        for (int i = 0; i < numberOfEmp; i++) {
            if (storage[i].uuid.equals(uuid)) {
                temp = storage[i];
                break;
            }
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
        int numberOfEmp = size();
        for (int i = 0; i < numberOfEmp; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[numberOfEmp - 1];
                storage[numberOfEmp - 1] = null;
                System.out.println("Employee " + uuid + " deleted");
                return;
            }
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
        int numberOfEmp = 0;
        for (Employee e : storage) {
            if (e == null) break;
            numberOfEmp++;
        }
        return numberOfEmp;
    }
}
