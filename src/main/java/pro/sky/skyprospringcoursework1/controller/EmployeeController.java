package pro.sky.skyprospringcoursework1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringcoursework1.data.Employee;
import pro.sky.skyprospringcoursework1.service.EmployeeService;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController (EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee/add")
    public Employee add (@RequestParam("firstName") String name, @RequestParam("lastName")  String surname,
                         @RequestParam("department") Integer department, @RequestParam("salary")  Integer salary) {
        return employeeService.addEmployee(name, surname, department, salary);
    }

    @GetMapping("/employee/remove")
    public Employee remove (@RequestParam("firstName") String name, @RequestParam("lastName")  String surname) {
        return employeeService.removeEmployee(name, surname);
    }

    @GetMapping("/employee/remove-by-key")
    public Employee removeByKey (@RequestParam("key") String key) {
        return employeeService.removeEmployeeByKey(key);
    }

    @GetMapping("/employee/find-key")
    public String findKey (@RequestParam("firstName") String name, @RequestParam("lastName")  String surname) {
        return employeeService.findEmployeeKey(name, surname);
    }

    @GetMapping("/employee/printall")
    public Map<String, Employee> printAll () {
        return employeeService.printAllEmployees();
    }

    @GetMapping("/employee/edit-dep-by-key")
    public Employee editEmployeeDepartmentByKey (@RequestParam("key") String key, @RequestParam("dep") Integer dep) {
        return employeeService.editEmployeeDepartmentByKey(key, dep);
    }

    @GetMapping(path ="/departments/all")
    public Map<Integer,List<Employee>> printByDepartment () {
        return employeeService.printAllEmployeesByDepartments();
    }

    @GetMapping(path ="/departments/all", params = {"departmentId"})
    public List<Employee> printByDepartment (@RequestParam("departmentId") int dep) {
        return employeeService.printEmployeesByDep(dep);
    }
}
