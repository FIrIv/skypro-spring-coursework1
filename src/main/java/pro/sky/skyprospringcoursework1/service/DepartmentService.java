package pro.sky.skyprospringcoursework1.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringcoursework1.data.Employee;
import pro.sky.skyprospringcoursework1.exception.EmployeeNotFoundException;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Map<Integer,List<Employee>> printAllEmployeesByDepartments () {
        return employeeService.getEmployeeMap().values()
                .stream()
                .sorted()
                .collect(Collectors.groupingBy(e -> e.getDepartment()));
    }

    public List <Employee> printEmployeesByDep (int dep) {
        return employeeService.getEmployeeMap().values()
                .stream()
                .filter(e -> e.getDepartment() == dep)
                .collect(Collectors.toList());
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
                .min(Comparator.comparingInt(employee -> employee.getSalary()))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee findMinSalaryEmployeeByDep (int dep) {
        return employeeService.getEmployeeMap().values()
                .stream()
                .filter(e -> e.getDepartment() == dep)
                .min(Comparator.comparingInt(employee -> employee.getSalary()))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee findMaxSalaryEmployee () {
        return employeeService.getEmployeeMap().values()
                .stream()
                .max(Comparator.comparingInt(employee -> employee.getSalary()))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee findMaxSalaryEmployeeByDep (int dep) {
        return employeeService.getEmployeeMap().values()
                .stream()
                .filter(e -> e.getDepartment() == dep)
                .max(Comparator.comparingInt(employee -> employee.getSalary()))
                .orElseThrow(EmployeeNotFoundException::new);
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
                .peek(e -> e.setSalary((int) ((float)e.getSalary()*(1.0+index))))
                .collect(Collectors.toList());
    }

    public List<Employee> indexSalaryByDep (float index, int dep) {
        return employeeService.getEmployeeMap().values()
                .stream()
                .filter(e -> e.getDepartment() == dep)
                .peek(e -> e.setSalary((int) ((float)e.getSalary()*(1.0+index))))
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
