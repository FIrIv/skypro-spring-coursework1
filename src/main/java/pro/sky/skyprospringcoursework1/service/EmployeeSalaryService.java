package pro.sky.skyprospringcoursework1.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringcoursework1.data.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeSalaryService {

    private final EmployeeService employeeService;

    public EmployeeSalaryService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee editEmployeeSalaryByKey (String key, int newSalary) {
        if (employeeService.getEmployeeMap().containsKey(key)) {
            Employee temp = employeeService.getEmployeeMap().get(key);
            employeeService.getEmployeeMap().get(key).setSalary(newSalary);
            System.out.println("Зарплата сотрудника изменена с " + temp.getSalary() + " на " + newSalary + " руб.");
        } else {
            System.out.println("Сотрудник не найден! ");
        }
        return employeeService.getEmployeeMap().get(key);
    }

    public int countSalaries () {
        return employeeService.getEmployeeMap().values()
                .stream()
                .mapToInt(employee -> employee.getSalary()).sum();
    }

    public int countSalariesByDep (int dep) {
        return employeeService.getEmployeeMap().values()
                .stream()
                .filter(e -> e.getDepartment() == dep)
                .mapToInt(employee -> employee.getSalary()).sum();
    }

    public Employee findMinSalaryEmployee () {
        return employeeService.getEmployeeMap().values()
                .stream()
                .min(Comparator.comparingInt(employee -> employee.getSalary())).get();
    }

    public Employee findMinSalaryEmployeeByDep (int dep) {
        return employeeService.getEmployeeMap().values()
                .stream()
                .filter(e -> e.getDepartment() == dep)
                .min(Comparator.comparingInt(employee -> employee.getSalary())).get();
    }

    public Employee findMaxSalaryEmployee () {
        return employeeService.getEmployeeMap().values()
                .stream()
                .max(Comparator.comparingInt(employee -> employee.getSalary())).get();
    }

    public Employee findMaxSalaryEmployeeByDep (int dep) {
        return employeeService.getEmployeeMap().values()
                .stream()
                .filter(e -> e.getDepartment() == dep)
                .max(Comparator.comparingInt(employee -> employee.getSalary())).get();
    }

    public long countEmployees () {
        return employeeService.getEmployeeMap().values()
                .stream()
                .count();
    }

    public long countEmployeesByDep (int dep) {
        return employeeService.getEmployeeMap().values()
                .stream()
                .filter(e -> e.getDepartment() == dep)
                .count();
    }

    public Double countAverageSalary () {
        return employeeService.getEmployeeMap().values()
                .stream()
                .mapToInt(employee -> employee.getSalary()).average().getAsDouble();
    }

    public Double countAverageSalaryByDep (int dep) {
        return employeeService.getEmployeeMap().values()
                .stream()
                .filter(e -> e.getDepartment() == dep)
                .mapToInt(employee -> employee.getSalary()).average().getAsDouble();
    }

    public List<Employee> indexSalary (float index) {
        return employeeService.getEmployeeMap().values()
                .stream()
                .map(e ->
                {e.setSalary((int) ((float)e.getSalary()*(1.0+index)));
                    return e;})
                .collect(Collectors.toList());
    }

    public List<Employee> indexSalaryByDep (float index, int dep) {
        return employeeService.getEmployeeMap().values()
                .stream()
                .filter(e -> e.getDepartment() == dep)
                .map(e ->
                        {e.setSalary((int) ((float)e.getSalary()*(1.0+index)));
                            return e;})
                .collect(Collectors.toList());
    }

    public List<Employee> findEmployeesWithSalaryBelowInDep (int salaryMax, int dep) {
        return employeeService.getEmployeeMap().values()
                .stream()
                .filter(e -> e.getDepartment() == dep)
                .filter(e -> e.getSalary() < salaryMax)
                .collect(Collectors.toList());
    }

    public List<Employee> findEmployeesWithSalaryAboveOrEqualInDep (int salaryMin, int dep) {
        return employeeService.getEmployeeMap().values()
                .stream()
                .filter(e -> e.getDepartment() == dep)
                .filter(e -> e.getSalary() >= salaryMin)
                .collect(Collectors.toList());
    }
}
