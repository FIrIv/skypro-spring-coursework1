package pro.sky.skyprospringcoursework1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringcoursework1.data.Employee;
import pro.sky.skyprospringcoursework1.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path ="/all")
    public Map<Integer,List<Employee>> printByDepartment () {
        return departmentService.printAllEmployeesByDepartments();
    }

    @GetMapping(path ="/all", params = {"departmentId"})
    public List<Employee> printByDepartment (@RequestParam("departmentId") int dep) {
        return departmentService.printEmployeesByDep(dep);
    }

    @GetMapping(path ="/count-salaries")
    public Integer countSalaries () {
        return departmentService.countSalaries();
    }

    @GetMapping(path ="/count-salaries", params = {"departmentId"})
    public Integer countSalariesByDep (@RequestParam("departmentId") int dep) {
        return departmentService.countSalariesByDep(dep);
    }

    @GetMapping(path ="/max-salary")
    public Employee findMaxSalaryEmployee () {
        return departmentService.findMaxSalaryEmployee();
    }

    @GetMapping(path ="/max-salary", params = {"departmentId"})
    public Employee findMaxSalaryEmployeeByDep (@RequestParam("departmentId") int dep) {
        return departmentService.findMaxSalaryEmployeeByDep(dep);
    }

    @GetMapping(path ="/min-salary")
    public Employee findMinSalaryEmployee () {
        return departmentService.findMinSalaryEmployee();
    }

    @GetMapping(path ="/min-salary", params = {"departmentId"})
    public Employee findMinSalaryEmployeeByDep (@RequestParam("departmentId") int dep) {
        return departmentService.findMinSalaryEmployeeByDep(dep);
    }

    @GetMapping(path ="/count-employees")
    public Long countEmployees () {
        return departmentService.countEmployees();
    }

    @GetMapping(path ="/count-employees", params = {"departmentId"})
    public Long countEmployeesByDep (@RequestParam("departmentId") int dep) {
        return departmentService.countEmployeesByDep(dep);
    }

    @GetMapping(path ="/count-average-salary")
    public Double countAverageSalary () {
        return departmentService.countAverageSalary();
    }

    @GetMapping(path ="/count-average-salary", params = {"departmentId"})
    public Double countEmployeescountAverageSalaryByDep (@RequestParam("departmentId") int dep) {
        return departmentService.countAverageSalaryByDep(dep);
    }

    @GetMapping(path ="/index-salary", params = {"index"})
    public List<Employee> indexSalary (@RequestParam("index") float index) {
        return departmentService.indexSalary(index);
    }

    @GetMapping(path ="/index-salary", params = {"index", "departmentId"})
    public List<Employee> indexSalaryByDep (@RequestParam("index") float index, @RequestParam("departmentId") int dep) {
        return departmentService.indexSalaryByDep(index, dep);
    }

    @GetMapping(path ="/findEmployeesWithSalaryBelowInDep", params = {"maxsalary", "departmentId"})
    public List<Employee> findEmployeesWithSalaryBelowInDep (@RequestParam("maxsalary") int maxsalary, @RequestParam("departmentId") int dep) {
        return departmentService.findEmployeesWithSalaryBelowInDep(maxsalary, dep);
    }

    @GetMapping(path ="/findEmployeesWithSalaryAboveOrEqualInDep", params = {"minsalary", "departmentId"})
    public List<Employee> findEmployeesWithSalaryAboveOrEqualInDep (@RequestParam("minsalary") int minsalary, @RequestParam("departmentId") int dep) {
        return departmentService.findEmployeesWithSalaryAboveOrEqualInDep(minsalary, dep);
    }
}
