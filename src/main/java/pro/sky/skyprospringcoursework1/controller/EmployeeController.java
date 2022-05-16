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
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController (EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add (@RequestParam("firstName") String name, @RequestParam("lastName")  String surname) {
        return employeeService.addEmployee(name, surname);
    }

    @GetMapping("/remove")
    public Employee remove (@RequestParam("firstName") String name, @RequestParam("lastName")  String surname) {
        return employeeService.removeEmployee(name, surname);
    }

    @GetMapping("/findkey")
    public String findkey (@RequestParam("firstName") String name, @RequestParam("lastName")  String surname) {
        return employeeService.findEmployeeKey(name, surname);
    }

    @GetMapping("/printall")
    public Map<String, Employee> printAll () {
        return employeeService.printAllEmployees();
    }
}
