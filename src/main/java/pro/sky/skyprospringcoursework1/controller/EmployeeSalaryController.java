package pro.sky.skyprospringcoursework1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringcoursework1.data.Employee;
import pro.sky.skyprospringcoursework1.service.EmployeeSalaryService;
import pro.sky.skyprospringcoursework1.service.EmployeeService;

import java.util.List;

@RestController
public class EmployeeSalaryController {
    private final EmployeeSalaryService employeeSalaryService;

    public EmployeeSalaryController (EmployeeSalaryService employeeSalaryService) {
        this.employeeSalaryService = employeeSalaryService;
    }

    @GetMapping("/employee/edit-salary-by-key")
    public Employee editEmployeeSalaryByKey (@RequestParam("key") String key, @RequestParam("salary") Integer salary) {
        return employeeSalaryService.editEmployeeSalaryByKey(key, salary);
    }

    @GetMapping(path ="/employee/count-salaries")
    public Integer countSalaries () {
        return employeeSalaryService.countSalaries();
    }

    @GetMapping(path ="/employee/count-salaries", params = {"departmentId"})
    public Integer countSalariesByDep (@RequestParam("departmentId") int dep) {
        return employeeSalaryService.countSalariesByDep(dep);
    }

    @GetMapping(path ="/departments/max-salary")
    public Employee findMaxSalaryEmployee () {
        return employeeSalaryService.findMaxSalaryEmployee();
    }

    @GetMapping(path ="/departments/max-salary", params = {"departmentId"})
    public Employee findMaxSalaryEmployeeByDep (@RequestParam("departmentId") int dep) {
        return employeeSalaryService.findMaxSalaryEmployeeByDep(dep);
    }

    @GetMapping(path ="/departments/min-salary")
    public Employee findMinSalaryEmployee () {
        return employeeSalaryService.findMinSalaryEmployee();
    }

    @GetMapping(path ="/departments/min-salary", params = {"departmentId"})
    public Employee findMinSalaryEmployeeByDep (@RequestParam("departmentId") int dep) {
        return employeeSalaryService.findMinSalaryEmployeeByDep(dep);
    }

    @GetMapping(path ="/employee/count-employees")
    public Long countEmployees () {
        return employeeSalaryService.countEmployees();
    }

    @GetMapping(path ="/employee/count-employees", params = {"departmentId"})
    public Long countEmployeesByDep (@RequestParam("departmentId") int dep) {
        return employeeSalaryService.countEmployeesByDep(dep);
    }

    @GetMapping(path ="/employee/count-average-salary")
    public Double countAverageSalary () {
        return employeeSalaryService.countAverageSalary();
    }

    @GetMapping(path ="/employee/count-average-salary", params = {"departmentId"})
    public Double countEmployeescountAverageSalaryByDep (@RequestParam("departmentId") int dep) {
        return employeeSalaryService.countAverageSalaryByDep(dep);
    }

    @GetMapping(path ="/employee/index-salary", params = {"index"})
    public List<Employee> indexSalary (@RequestParam("index") float index) {
        return employeeSalaryService.indexSalary(index);
    }

    @GetMapping(path ="/employee/index-salary", params = {"index", "departmentId"})
    public List<Employee> indexSalaryByDep (@RequestParam("index") float index, @RequestParam("departmentId") int dep) {
        return employeeSalaryService.indexSalaryByDep(index, dep);
    }

    @GetMapping(path ="/employee/findEmployeesWithSalaryBelowInDep", params = {"maxsalary", "departmentId"})
    public List<Employee> findEmployeesWithSalaryBelowInDep (@RequestParam("maxsalary") int maxsalary, @RequestParam("departmentId") int dep) {
        return employeeSalaryService.findEmployeesWithSalaryBelowInDep(maxsalary, dep);
    }

    @GetMapping(path ="/employee/findEmployeesWithSalaryAboveOrEqualInDep", params = {"minsalary", "departmentId"})
    public List<Employee> findEmployeesWithSalaryAboveOrEqualInDep (@RequestParam("minsalary") int minsalary, @RequestParam("departmentId") int dep) {
        return employeeSalaryService.findEmployeesWithSalaryAboveOrEqualInDep(minsalary, dep);
    }
}
