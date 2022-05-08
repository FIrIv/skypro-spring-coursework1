package pro.sky.skyprospringcoursework1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private List <Employee> employeeList = new ArrayList <> ();

    public Employee addEmployee(String name, String surname) {
        try {
            findEmployee(name, surname);
            System.out.println(name + " " + surname + " уже есть в массиве. ");
            throw new BadRequestException();
        } catch (EmployeeNotFoundException e) {
            Employee temp = new Employee(name, surname);
            for (int i = 0; i < employeeList.size(); i++) {
                if (employeeList.get(i) == null) {
                    employeeList.set(i,temp);
                    System.out.println(name + " " + surname + " добавлен на пустое место в массив под номером " + i);
                    return temp;
                }
            }
            // если в массиве не нашлось пустого места, добавляем в конец
            System.out.println(name + " " + surname + " добавлен в конец массива");
            employeeList.add(temp);
            return temp;
        }
    }

    public Employee removeEmployee(String name, String surname) {
        Employee temp = new Employee(name, surname);
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i) == null) continue;
            if (employeeList.get(i).equals(temp)) {
                employeeList.set(i, null);
                System.out.println(name + " " + surname + " исключен из массива. ");
                return temp;
            }
        }
        System.out.println(name + " " + surname + " не найден. ");
        throw new EmployeeNotFoundException();
    }

    public Employee findEmployee(String name, String surname) {
        Employee temp = new Employee(name, surname);
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i) == null) continue;
            if (employeeList.get(i).equals(temp)) {
                System.out.println(name + " " + surname + " найден в массиве под номером " + i);
                return employeeList.get(i);
            }
        }
        System.out.println(name + " " + surname + " не найден. ");
        throw new EmployeeNotFoundException();
    }

    public List <Employee> findAllEmployees() {
        if (employeeList.isEmpty()) return null;
        else return employeeList;
    }
}