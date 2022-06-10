package pro.sky.skyprospringcoursework1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.skyprospringcoursework1.data.Employee;
import pro.sky.skyprospringcoursework1.service.DepartmentService;
import pro.sky.skyprospringcoursework1.service.EmployeeService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @Mock
    private EmployeeService empService;

    @InjectMocks
    private DepartmentService depService;

    @Test
    public void printAllEmployeesByDepartments () {
        assertNotNull(empService);

        Map<Integer,List<Employee>> expectedDeps = new HashMap<>();
        List <Employee> list1 = new ArrayList<>();
        list1.add(new Employee("Дмитрий","Амагаев", 1, 50_000));
        list1.add(new Employee("Сергей","Иванов", 1, 70_000));
        list1.sort(Comparator.naturalOrder());
        expectedDeps.put(1,list1);
        List <Employee> list2 = new ArrayList<>();
        list2.add(new Employee("Елена","Белобородова", 2, 100_000));
        list2.add(new Employee("Андрей","Волков", 2, 75_000));
        list2.add(new Employee("Анна","Кукушина", 2, 50_000));
        list2.add(new Employee("Артем","Донской", 2, 60_000));

        list2.sort(Comparator.naturalOrder());
        expectedDeps.put(2,list2);

        Map<String, Employee> emps = new HashMap<>();

        emps.put("АндрейВолков", new Employee("Андрей","Волков", 2, 75_000));
        emps.put("АннаКукушина", new Employee("Анна","Кукушина", 2, 50_000));
        emps.put("АртемДонской", new Employee("Артем","Донской", 2, 60_000));
        emps.put("ДмитрийАмагаев", new Employee("Дмитрий","Амагаев", 1, 50_000));
        emps.put("ЕленаБелобородова", new Employee("Елена","Белобородова", 2, 100_000));
        emps.put("СергейИванов", new Employee("Сергей","Иванов", 1, 70_000));

        Mockito.when(empService.getEmployeeMap()).thenReturn(emps);
        Map<Integer,List<Employee>> result = depService.printAllEmployeesByDepartments();

        assertEquals(expectedDeps, result);
    }
    @Test
    public void printEmployeesByDep() {
        List<Employee> expectedList = new ArrayList<>();
        expectedList.add(new Employee("Андрей", "Волков", 2, 75_000));
        expectedList.add(new Employee("Анна", "Кукушина", 2, 50_000));
        expectedList.add(new Employee("Артем", "Донской", 2, 60_000));
        expectedList.add(new Employee("Елена", "Белобородова", 2, 100_000));
        expectedList.sort(Comparator.naturalOrder());

        Map<String, Employee> emps = new HashMap<>();

        emps.put("АндрейВолков", new Employee("Андрей", "Волков", 2, 75_000));
        emps.put("АннаКукушина", new Employee("Анна", "Кукушина", 2, 50_000));
        emps.put("АртемДонской", new Employee("Артем", "Донской", 2, 60_000));
        emps.put("ДмитрийАмагаев", new Employee("Дмитрий", "Амагаев", 1, 50_000));
        emps.put("ЕленаБелобородова", new Employee("Елена", "Белобородова", 2, 100_000));
        emps.put("СергейИванов", new Employee("Сергей", "Иванов", 1, 70_000));

        Mockito.when(empService.getEmployeeMap()).thenReturn(emps);
        List<Employee> result = depService.printEmployeesByDep(2);
        result.sort(Comparator.naturalOrder());

        assertEquals(expectedList, result);
    }

    @Test
    public void countSalaries() {
        int expectedCount = 405_000;

        Map<String, Employee> emps = new HashMap<>();

        emps.put("АндрейВолков", new Employee("Андрей", "Волков", 2, 75_000));
        emps.put("АннаКукушина", new Employee("Анна", "Кукушина", 2, 50_000));
        emps.put("АртемДонской", new Employee("Артем", "Донской", 2, 60_000));
        emps.put("ДмитрийАмагаев", new Employee("Дмитрий", "Амагаев", 1, 50_000));
        emps.put("ЕленаБелобородова", new Employee("Елена", "Белобородова", 2, 100_000));
        emps.put("СергейИванов", new Employee("Сергей", "Иванов", 1, 70_000));

        Mockito.when(empService.getEmployeeMap()).thenReturn(emps);
        int result = depService.countSalaries();
        assertEquals(expectedCount, result);
    }

    @Test
    public void countSalariesByDep() {
        int expectedCount = 285_000;

        Map<String, Employee> emps = new HashMap<>();

        emps.put("АндрейВолков", new Employee("Андрей", "Волков", 2, 75_000));
        emps.put("АннаКукушина", new Employee("Анна", "Кукушина", 2, 50_000));
        emps.put("АртемДонской", new Employee("Артем", "Донской", 2, 60_000));
        emps.put("ДмитрийАмагаев", new Employee("Дмитрий", "Амагаев", 1, 55_000));
        emps.put("ЕленаБелобородова", new Employee("Елена", "Белобородова", 2, 100_000));
        emps.put("СергейИванов", new Employee("Сергей", "Иванов", 1, 70_000));

        Mockito.when(empService.getEmployeeMap()).thenReturn(emps);
        int result = depService.countSalariesByDep(2);
        assertEquals(expectedCount, result);
    }

    @Test
    public void findMinSalaryEmployee() {
        Employee expectedEmployee = new Employee("Анна", "Кукушина", 2, 50_000);

        Map<String, Employee> emps = new HashMap<>();

        emps.put("АндрейВолков", new Employee("Андрей", "Волков", 2, 75_000));
        emps.put("АннаКукушина", new Employee("Анна", "Кукушина", 2, 50_000));
        emps.put("АртемДонской", new Employee("Артем", "Донской", 2, 60_000));
        emps.put("ДмитрийАмагаев", new Employee("Дмитрий", "Амагаев", 1, 55_000));
        emps.put("ЕленаБелобородова", new Employee("Елена", "Белобородова", 2, 100_000));
        emps.put("СергейИванов", new Employee("Сергей", "Иванов", 1, 70_000));

        Mockito.when(empService.getEmployeeMap()).thenReturn(emps);
        Employee result = depService.findMinSalaryEmployee();

        assertEquals(expectedEmployee, result);
    }

    @Test
    public void findMaxSalaryEmployee() {
        Employee expectedEmployee = new Employee("Елена", "Белобородова", 2, 100_000);

        Map<String, Employee> emps = new HashMap<>();

        emps.put("АндрейВолков", new Employee("Андрей", "Волков", 2, 75_000));
        emps.put("АннаКукушина", new Employee("Анна", "Кукушина", 2, 50_000));
        emps.put("АртемДонской", new Employee("Артем", "Донской", 2, 60_000));
        emps.put("ДмитрийАмагаев", new Employee("Дмитрий", "Амагаев", 1, 55_000));
        emps.put("ЕленаБелобородова", new Employee("Елена", "Белобородова", 2, 100_000));
        emps.put("СергейИванов", new Employee("Сергей", "Иванов", 1, 70_000));

        Mockito.when(empService.getEmployeeMap()).thenReturn(emps);
        Employee result = depService.findMaxSalaryEmployee();

        assertEquals(expectedEmployee, result);
    }

    @Test
    public void findMinSalaryEmployeeByDep() {
        Employee expectedEmployee = new Employee("Дмитрий", "Амагаев", 1, 55_000);

        Map<String, Employee> emps = new HashMap<>();

        emps.put("АндрейВолков", new Employee("Андрей", "Волков", 2, 75_000));
        emps.put("АннаКукушина", new Employee("Анна", "Кукушина", 2, 50_000));
        emps.put("АртемДонской", new Employee("Артем", "Донской", 2, 60_000));
        emps.put("ДмитрийАмагаев", new Employee("Дмитрий", "Амагаев", 1, 55_000));
        emps.put("ЕленаБелобородова", new Employee("Елена", "Белобородова", 2, 100_000));
        emps.put("СергейИванов", new Employee("Сергей", "Иванов", 1, 70_000));

        Mockito.when(empService.getEmployeeMap()).thenReturn(emps);
        Employee result = depService.findMinSalaryEmployeeByDep(1);

        assertEquals(expectedEmployee, result);
    }

    @Test
    public void findMaxSalaryEmployeeByDep() {
        Employee expectedEmployee = new Employee("Сергей", "Иванов", 1, 70_000);

        Map<String, Employee> emps = new HashMap<>();

        emps.put("АндрейВолков", new Employee("Андрей", "Волков", 2, 75_000));
        emps.put("АннаКукушина", new Employee("Анна", "Кукушина", 2, 50_000));
        emps.put("АртемДонской", new Employee("Артем", "Донской", 2, 60_000));
        emps.put("ДмитрийАмагаев", new Employee("Дмитрий", "Амагаев", 1, 55_000));
        emps.put("ЕленаБелобородова", new Employee("Елена", "Белобородова", 2, 100_000));
        emps.put("СергейИванов", new Employee("Сергей", "Иванов", 1, 70_000));

        Mockito.when(empService.getEmployeeMap()).thenReturn(emps);
        Employee result = depService.findMaxSalaryEmployeeByDep(1);

        assertEquals(expectedEmployee, result);
    }

    @Test
    public void countEmployees() {
        long expectedCount = 6L;

        Map<String, Employee> emps = new HashMap<>();

        emps.put("АндрейВолков", new Employee("Андрей", "Волков", 2, 75_000));
        emps.put("АннаКукушина", new Employee("Анна", "Кукушина", 2, 50_000));
        emps.put("АртемДонской", new Employee("Артем", "Донской", 2, 60_000));
        emps.put("ДмитрийАмагаев", new Employee("Дмитрий", "Амагаев", 1, 50_000));
        emps.put("ЕленаБелобородова", new Employee("Елена", "Белобородова", 2, 100_000));
        emps.put("СергейИванов", new Employee("Сергей", "Иванов", 1, 70_000));

        Mockito.when(empService.getEmployeeMap()).thenReturn(emps);
        long result = depService.countEmployees();
        assertEquals(expectedCount, result);
    }

    @Test
    public void countEmployeesByDep() {
        long expectedCount = 4L;

        Map<String, Employee> emps = new HashMap<>();

        emps.put("АндрейВолков", new Employee("Андрей", "Волков", 2, 75_000));
        emps.put("АннаКукушина", new Employee("Анна", "Кукушина", 2, 50_000));
        emps.put("АртемДонской", new Employee("Артем", "Донской", 2, 60_000));
        emps.put("ДмитрийАмагаев", new Employee("Дмитрий", "Амагаев", 1, 55_000));
        emps.put("ЕленаБелобородова", new Employee("Елена", "Белобородова", 2, 100_000));
        emps.put("СергейИванов", new Employee("Сергей", "Иванов", 1, 70_000));

        Mockito.when(empService.getEmployeeMap()).thenReturn(emps);
        long result = depService.countEmployeesByDep(2);
        assertEquals(expectedCount, result);
    }

    @Test
    public void countAverageSalary () {
        Double expectedSalary = 60000.0D;

        Map<String, Employee> emps = new HashMap<>();

        emps.put("АндрейВолков", new Employee("Андрей", "Волков", 2, 75_000));
        emps.put("АннаКукушина", new Employee("Анна", "Кукушина", 2, 50_000));
        emps.put("АртемДонской", new Employee("Артем", "Донской", 2, 55_000));

        Mockito.when(empService.getEmployeeMap()).thenReturn(emps);
        Double result = depService.countAverageSalary();
        assertEquals(expectedSalary, result);
    }

    @Test
    public void countAverageSalaryByDep () {
        Double expectedSalary = 65000.0D;

        Map<String, Employee> emps = new HashMap<>();

        emps.put("АндрейВолков", new Employee("Андрей", "Волков", 2, 75_000));
        emps.put("АннаКукушина", new Employee("Анна", "Кукушина", 1, 50_000));
        emps.put("АртемДонской", new Employee("Артем", "Донской", 2, 55_000));

        Mockito.when(empService.getEmployeeMap()).thenReturn(emps);
        Double result = depService.countAverageSalaryByDep(2);
        assertEquals(expectedSalary, result);
    }

    @Test
    public void indexSalary () {
        List<Employee> expectedList = new ArrayList<>();
        expectedList.add(new Employee("Андрей", "Волков", 2, 78_750));
        expectedList.add(new Employee("Анна", "Кукушина", 2, 52_500));
        expectedList.add(new Employee("Артем", "Донской", 1, 63_000));
        expectedList.add(new Employee("Дмитрий", "Амагаев", 1, 57_750));
        expectedList.add(new Employee("Елена", "Белобородова", 2, 105_000));
        expectedList.add(new Employee("Сергей", "Иванов", 1, 73_500));
        expectedList.sort(Comparator.naturalOrder());

        Map<String, Employee> emps = new HashMap<>();

        emps.put("АндрейВолков", new Employee("Андрей", "Волков", 2, 75_000));
        emps.put("АннаКукушина", new Employee("Анна", "Кукушина", 2, 50_000));
        emps.put("АртемДонской", new Employee("Артем", "Донской", 2, 60_000));
        emps.put("ДмитрийАмагаев", new Employee("Дмитрий", "Амагаев", 1, 55_000));
        emps.put("ЕленаБелобородова", new Employee("Елена", "Белобородова", 2, 100_000));
        emps.put("СергейИванов", new Employee("Сергей", "Иванов", 1, 70_000));

        Mockito.when(empService.getEmployeeMap()).thenReturn(emps);
        List<Employee> result = depService.indexSalary(0.05F);
        result.sort(Comparator.naturalOrder());

        assertEquals(expectedList, result);
    }

    @Test
    public void indexSalaryByDep () {
        List<Employee> expectedList = new ArrayList<>();
        expectedList.add(new Employee("Дмитрий", "Амагаев", 1, 57_750));
        expectedList.add(new Employee("Сергей", "Иванов", 1, 73_500));
        expectedList.sort(Comparator.naturalOrder());

        Map<String, Employee> emps = new HashMap<>();

        emps.put("АндрейВолков", new Employee("Андрей", "Волков", 2, 75_000));
        emps.put("АннаКукушина", new Employee("Анна", "Кукушина", 2, 50_000));
        emps.put("АртемДонской", new Employee("Артем", "Донской", 2, 60_000));
        emps.put("ДмитрийАмагаев", new Employee("Дмитрий", "Амагаев", 1, 55_000));
        emps.put("ЕленаБелобородова", new Employee("Елена", "Белобородова", 2, 100_000));
        emps.put("СергейИванов", new Employee("Сергей", "Иванов", 1, 70_000));

        Mockito.when(empService.getEmployeeMap()).thenReturn(emps);
        List<Employee> result = depService.indexSalaryByDep(0.05F, 1);
        result.sort(Comparator.naturalOrder());

        assertEquals(expectedList, result);
    }

    @Test
    public void findEmployeesWithSalaryBelowInDep (){
        List<Employee> expectedList = new ArrayList<>();
        expectedList.add(new Employee("Анна", "Кукушина", 2, 50_000));
        expectedList.add(new Employee("Артем", "Донской", 2, 60_000));
        expectedList.sort(Comparator.naturalOrder());

        Map<String, Employee> emps = new HashMap<>();

        emps.put("АндрейВолков", new Employee("Андрей", "Волков", 2, 75_000));
        emps.put("АннаКукушина", new Employee("Анна", "Кукушина", 2, 50_000));
        emps.put("АртемДонской", new Employee("Артем", "Донской", 2, 60_000));
        emps.put("ДмитрийАмагаев", new Employee("Дмитрий", "Амагаев", 1, 55_000));
        emps.put("ЕленаБелобородова", new Employee("Елена", "Белобородова", 2, 100_000));
        emps.put("СергейИванов", new Employee("Сергей", "Иванов", 1, 70_000));

        Mockito.when(empService.getEmployeeMap()).thenReturn(emps);
        List<Employee> result = depService.findEmployeesWithSalaryBelowInDep(70_000, 2);
        result.sort(Comparator.naturalOrder());

        assertEquals(expectedList, result);
    }

    @Test
    public void findEmployeesWithSalaryAboveOrEqualInDep (){
        List<Employee> expectedList = new ArrayList<>();
        expectedList.add(new Employee("Андрей", "Волков", 2, 75_000));
        expectedList.add(new Employee("Елена", "Белобородова", 2, 100_000));
        expectedList.sort(Comparator.naturalOrder());

        Map<String, Employee> emps = new HashMap<>();

        emps.put("АндрейВолков", new Employee("Андрей", "Волков", 2, 75_000));
        emps.put("АннаКукушина", new Employee("Анна", "Кукушина", 2, 50_000));
        emps.put("АртемДонской", new Employee("Артем", "Донской", 2, 60_000));
        emps.put("ДмитрийАмагаев", new Employee("Дмитрий", "Амагаев", 1, 55_000));
        emps.put("ЕленаБелобородова", new Employee("Елена", "Белобородова", 2, 100_000));
        emps.put("СергейИванов", new Employee("Сергей", "Иванов", 1, 70_000));

        Mockito.when(empService.getEmployeeMap()).thenReturn(emps);
        List<Employee> result = depService.findEmployeesWithSalaryAboveOrEqualInDep(70_000, 2);
        result.sort(Comparator.naturalOrder());

        assertEquals(expectedList, result);
    }
}
