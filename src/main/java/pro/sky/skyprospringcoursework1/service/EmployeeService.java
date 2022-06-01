package pro.sky.skyprospringcoursework1.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringcoursework1.exception.BadRequestException;
import pro.sky.skyprospringcoursework1.data.Employee;
import pro.sky.skyprospringcoursework1.exception.EmployeeNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private Map<String, Employee> employeeMap;

    public Map<String, Employee> getEmployeeMap() {
        return employeeMap;
    }

    public EmployeeService () {
        this.employeeMap = new HashMap<>();
        employeeMap.put("ДмитрийАмагаев", new Employee("Дмитрий", "Амагаев",generateFromToRandom(1,5),generateFromToRandom(50_000,100_000)));
        employeeMap.put("ЕленаБелобородова", new Employee("Елена","Белобородова",generateFromToRandom(1,5),generateFromToRandom(50_000,100_000)));
        employeeMap.put("АндрейВолков", new Employee("Андрей","Волков",generateFromToRandom(1,5),generateFromToRandom(50_000,100_000)));
        employeeMap.put("АндрейГубин", new Employee("Андрей","Губин",generateFromToRandom(1,5),generateFromToRandom(50_000,100_000)));
        employeeMap.put("АртемДонской", new Employee("Артем","Донской",generateFromToRandom(1,5),generateFromToRandom(50_000,100_000)));
        employeeMap.put("ЕкатеринаЕфимова", new Employee("Екатерина","Ефимова",generateFromToRandom(1,5),generateFromToRandom(50_000,100_000)));
        employeeMap.put("АлександрЖанчипов", new Employee("Александр","Жанчипов",generateFromToRandom(1,5),generateFromToRandom(50_000,100_000)));
        employeeMap.put("АлександрЗяблов", new Employee("Александр","Зяблов",generateFromToRandom(1,5),generateFromToRandom(50_000,100_000)));
        employeeMap.put("СергейИванов", new Employee("Сергей","Иванов",generateFromToRandom(1,5),generateFromToRandom(50_000,100_000)));
        employeeMap.put("АннаКукушина", new Employee("Анна","Кукушина",generateFromToRandom(1,5),generateFromToRandom(50_000,100_000)));
    }

    public static int generateFromToRandom (int min, int max) {
        java.util.Random random = new java.util.Random();
        int elem;
        elem = random.nextInt(max-min+1) + min;
        return elem;
    }

    public Employee addEmployee(String name, String surname, int department, int salary) {
        Employee temp = new Employee(name, surname, department, salary);
        if (employeeMap.containsValue(temp)) {
            System.out.println(temp.getName() + " " + temp.getSurname() + " уже есть в мапе. ");
            throw new BadRequestException();
        } else {
            employeeMap.put(temp.getName()+temp.getSurname(), temp);
            System.out.println(temp.getName() + " " + temp.getSurname() + " добавлен в мапу с кодом " + temp.getName()+temp.getSurname());
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
    
    public Employee removeEmployeeByKey(String key) {
        if (employeeMap.containsKey(key)) {
            Employee temp = employeeMap.get(key);
            System.out.println("Сотрудник с кодом " + key + " исключен из мапы. ");
            employeeMap.remove(key);
            return temp;
        } else {
            System.out.println("Сотрудник с кодом " + key + " не найден в мапе. ");
            throw new EmployeeNotFoundException();
        }
    }

    public String findEmployeeKey(String name, String surname) {
        Employee temp = new Employee(name, surname);
        if (employeeMap.containsValue(temp)) {
            for (Map.Entry <String,Employee> emp : employeeMap.entrySet()) {
                if (emp == null) {
                    continue;
                }
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
        if (employeeMap.isEmpty()) {
            return null;
        }
        else {
            return employeeMap;
        }
    }

    public Employee editEmployeeDepartmentByKey (String key, int newDep) {
        if (newDep <1 || newDep >5) {
            System.out.println("Номера отделов должны быть от 1 до 5. Отдел не изменен. ");
            return null;
        }
        if (employeeMap.containsKey(key)) {
            Employee temp = employeeMap.get(key);
            employeeMap.get(key).setDepartment(newDep);
            System.out.println("Номер отдела изменен с " + temp.getDepartment() + " на " + newDep);
        } else {
            System.out.println("Сотрудник не найден! ");
        }
        return employeeMap.get(key);
    }

    public Employee editEmployeeSalaryByKey (String key, int newSalary) {
        if (employeeMap.containsKey(key)) {
            Employee temp = employeeMap.get(key);
            employeeMap.get(key).setSalary(newSalary);
            System.out.println("Зарплата сотрудника изменена с " + temp.getSalary() + " на " + newSalary + " руб.");
        } else {
            System.out.println("Сотрудник не найден! ");
        }
        return employeeMap.get(key);
    }
}