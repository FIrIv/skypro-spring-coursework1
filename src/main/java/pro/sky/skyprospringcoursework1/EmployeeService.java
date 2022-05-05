package pro.sky.skyprospringcoursework1;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
public class EmployeeService {
    private Employee[] employees = new Employee[5];

    public Employee addEmployee(String name, String surname) {
        try {
            findEmployee(name, surname);
            System.out.println(name + " " + surname + " уже есть в массиве. ");
            throw new BadRequestException();
        } catch (EmployeeNotFoundException e) {
            Employee temp = new Employee(name, surname);
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] == null) {
                    employees[i] = temp;
                    System.out.println(name + " " + surname + " добавлен в массив под номером " + i);
                    return temp;
                }
            }
            System.out.println("Нет места для добавления. ");
            throw new ArrayIsFullException();
        }
    }

    public Employee removeEmployee(String name, String surname) {
        Employee temp = new Employee(name, surname);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].equals(temp)) {
                employees[i] = null;
                System.out.println(name + " " + surname + " исключен из массива. ");
                return temp;
            }
        }
        System.out.println(name + " " + surname + " не найден. ");
        throw new EmployeeNotFoundException();
    }

    public Employee findEmployee(String name, String surname) {
        Employee temp = new Employee(name, surname);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].equals(temp)) {
                System.out.println(name + " " + surname + " найден в массиве под номером " + i);
                return employees[i];
            }
        }
        System.out.println(name + " " + surname + " не найден. ");
        throw new EmployeeNotFoundException();
    }
}