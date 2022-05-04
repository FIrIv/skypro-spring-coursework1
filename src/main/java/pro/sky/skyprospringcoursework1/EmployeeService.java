package pro.sky.skyprospringcoursework1;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private Employee[] employees;

    public Employee addEmployee(String name, String surname) {
        if (findEmployee(name, surname) == null) {
            Employee temp = new Employee(name, surname);
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] == null) {
                    employees[i] = temp;
                    System.out.println(name + " " + surname + " добавлен в массив под номером " + i);
                    return temp;
                }
            }
            System.out.println("Нет места для добавления. ");
            throw new RuntimeException("500 Internal Server Error");
        } else {
            System.out.println(name + " " + surname + " уже есть в массиве. ");
            throw new RuntimeException("400 Bad Request");
        }
    }

    public Employee removeEmployee(String name, String surname) {
        Employee temp = new Employee(name, surname);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].equals(temp)) {
                employees[i] = null;
                System.out.println(name + " " + surname + " исключен из массива. ");
                return temp;
            }
        }
        System.out.println(name + " " + surname + " не найден. ");
        throw new RuntimeException("404 Not Found");
    }

    public Employee findEmployee(String name, String surname) {
        Employee temp = new Employee(name, surname);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].equals(temp)) {
                System.out.println(name + " " + surname + " найден в массиве под номером " + i);
                return employees[i];
            }
        }
        System.out.println(name + " " + surname + " не найден. ");
        throw new RuntimeException("404 Not Found");
    }
}