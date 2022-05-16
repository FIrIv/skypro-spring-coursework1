package pro.sky.skyprospringcoursework1.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringcoursework1.exception.BadRequestException;
import pro.sky.skyprospringcoursework1.data.Employee;
import pro.sky.skyprospringcoursework1.exception.EmployeeNotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class EmployeeService {
    private Map<String, Employee> employeeMap;

    public EmployeeService () {
        this.employeeMap = new HashMap<>();
        employeeMap.put("ИванИванов", new Employee("Иван", "Иванов"));
        employeeMap.put("ПетрПетров", new Employee("Петр", "Петров"));
        employeeMap.put("АнжеликаСидорова", new Employee("Анжелика", "Сидорова"));
    }

    public Employee addEmployee(String name, String surname) {
        Employee temp = new Employee(name, surname);
        if (employeeMap.containsValue(temp)) {
            System.out.println(name + " " + surname + " уже есть в мапе. ");
            throw new BadRequestException();
        } else {
            employeeMap.put(name+surname, temp);
            System.out.println(name + " " + surname + " добавлен в мапу с кодом " + name+surname);
        }
        return temp;
    }

    public Employee removeEmployee(String name, String surname) {
        Employee temp = new Employee(name, surname);
        if (employeeMap.containsValue(temp)) {
            employeeMap.remove(findEmployeeKey(name, surname));
            System.out.println(name + " " + surname + " исключен из мапы. ");
            return temp;
        } else {
            System.out.println(name + " " + surname + " не найден в мапе. ");
            throw new EmployeeNotFoundException();
        }
    }

    public String findEmployeeKey(String name, String surname) {
        Employee temp = new Employee(name, surname);
        if (employeeMap.containsValue(temp)) {
            for (Map.Entry <String,Employee> emp : employeeMap.entrySet()) {
                if (emp == null) continue;
                if (emp.getValue().equals(temp)) {
                    System.out.println(name + " " + surname + " найден в мапе. ");
                    return emp.getKey();
                }
            }
        } else {
            System.out.println(name + " " + surname + " не найден. ");
            throw new EmployeeNotFoundException();
        }
        return null;
    }

    public Map<String, Employee> printAllEmployees() {
        if (employeeMap.isEmpty()) return null;
        else return employeeMap;
    }
}