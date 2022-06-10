package pro.sky.skyprospringcoursework1;

import org.junit.jupiter.api.Test;
import pro.sky.skyprospringcoursework1.data.Employee;
import pro.sky.skyprospringcoursework1.exception.BadRequestException;
import pro.sky.skyprospringcoursework1.exception.EmployeeNotFoundException;
import pro.sky.skyprospringcoursework1.service.EmployeeService;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {

    private final EmployeeService out = new EmployeeService();

/*       List<Employee> emps = new ArrayList<> ();
        emps.add(new Employee("Дмитрий","Амагаев", 1, 50_000));
        emps.add(new Employee("Елена","Белобородова", 2, 100_000));
        emps.add(new Employee("Андрей","Волков", 2, 75_000));
        emps.add(new Employee("Андрей","Губин", 5, 40_000));
        emps.add(new Employee("Артем","Донской", 2, 60_000));
        emps.add(new Employee("Екатерина","Ефимова", 3, 80_000));
        emps.add(new Employee("Александр","Жанчипов", 3, 80_000));
        emps.add(new Employee("Александр","Зяблов", 4, 100_000));
        emps.add(new Employee("Сергей","Иванов", 1, 70_000));
        emps.add(new Employee("Анна","Кукушина", 2, 50_000)); */

    @Test
    public void addNewEmployee () {
        Map<String, Employee> employeeExpectedMap = new HashMap<>();
        employeeExpectedMap.put("ДмитрийАмагаев",new Employee("Дмитрий","Амагаев", 1, 50_000));
        employeeExpectedMap.put("ЕленаБелобородова",new Employee("Елена","Белобородова", 2, 100_000));
        employeeExpectedMap.put("АндрейВолков",new Employee("Андрей","Волков", 2, 75_000));

        out.addEmployee("Дмитрий","Амагаев", 1, 50_000);
        out.addEmployee("Елена","Белобородова", 2, 100_000);
        out.addEmployee("Андрей","Волков", 2, 75_000);
        Map<String, Employee> result = out.getEmployeeMap();

        assertEquals(employeeExpectedMap, result);
    }

    @Test
    public void shouldBadRequestExceptionIfEmployeeExisted () {
        assertThrows(BadRequestException.class, () -> {
            out.addEmployee("Андрей","Волков", 2, 75_000);
            out.addEmployee("Андрей","Волков", 2, 75_000);
        });
    }

    @Test
    public void removeExistedEmployee () {
        Map<String, Employee> employeeExpectedMap = new HashMap<>();
        employeeExpectedMap.put("ДмитрийАмагаев",new Employee("Дмитрий","Амагаев", 1, 50_000));
        employeeExpectedMap.put("ЕленаБелобородова",new Employee("Елена","Белобородова", 2, 100_000));

        out.addEmployee("Дмитрий","Амагаев", 1, 50_000);
        out.addEmployee("Елена","Белобородова", 2, 100_000);
        out.addEmployee("Андрей","Волков", 2, 75_000);
        out.removeEmployee("Андрей", "Волков");
        Map<String, Employee> result = out.getEmployeeMap();

        assertEquals(employeeExpectedMap, result);
    }

    @Test
    public void shouldEmployeeNotFoundExceptionIfEmployeeNotExisted () {
        assertThrows(EmployeeNotFoundException.class, () -> {
            out.addEmployee("Дмитрий","Амагаев", 1, 50_000);
            out.addEmployee("Елена","Белобородова", 2, 100_000);
            out.removeEmployee("Андрей", "Волков");
        });
    }

    @Test
    public void removeExistedEmployeeByKey () {
        Map<String, Employee> employeeExpectedMap = new HashMap<>();
        employeeExpectedMap.put("ДмитрийАмагаев",new Employee("Дмитрий","Амагаев", 1, 50_000));
        employeeExpectedMap.put("ЕленаБелобородова",new Employee("Елена","Белобородова", 2, 100_000));

        out.addEmployee("Дмитрий","Амагаев", 1, 50_000);
        out.addEmployee("Елена","Белобородова", 2, 100_000);
        out.addEmployee("Андрей","Волков", 2, 75_000);
        out.removeEmployeeByKey ("АндрейВолков");
        Map<String, Employee> result = out.getEmployeeMap();

        assertEquals(employeeExpectedMap, result);
    }

    @Test
    public void shouldEmployeeNotFoundExceptionIfEmployeeNotExistedByKey () {
        assertThrows(EmployeeNotFoundException.class, () -> {
            out.addEmployee("Дмитрий","Амагаев", 1, 50_000);
            out.addEmployee("Елена","Белобородова", 2, 100_000);
            out.removeEmployeeByKey("АндрейВолков");
        });
    }

    @Test
    public void FindEmployeeKeyByNameAndSurname () {
        out.addEmployee("Дмитрий","Амагаев", 1, 50_000);
        out.addEmployee("Елена","Белобородова", 2, 100_000);
        out.addEmployee("Андрей","Волков", 2, 75_000);
        String result = out.findEmployeeKey ("Андрей", "Волков");

        assertEquals("АндрейВолков", result);
    }

    @Test
    public void shouldEmployeeNotFoundExceptionIfEmployeeKeyNotFoundByNameAndSurname () {
        assertThrows(EmployeeNotFoundException.class, () -> {
            out.addEmployee("Дмитрий","Амагаев", 1, 50_000);
            out.addEmployee("Елена","Белобородова", 2, 100_000);
            out.findEmployeeKey("Андрей", "Волков");
        });
    }

    @Test
    public void printAllEmptyEmployees () {
        EmployeeService temp = new EmployeeService();
        Map<String, Employee> result = temp.printAllEmployees();
        assertNull(result);
    }

    @Test
    public void editEmployeeDepartmentByGoodDepByKey () {
       int expectedDep = 2;

        out.addEmployee("Дмитрий","Амагаев", 1, 50_000);
        Employee temp = out.editEmployeeDepartmentByKey("ДмитрийАмагаев", 2);

        assertEquals(expectedDep, temp.getDepartment());
    }

    @Test
    public void editEmployeeDepartmentByGoodDepByBadKey () {
        out.addEmployee("Дмитрий","Амагаев", 1, 50_000);
        Employee temp = out.editEmployeeDepartmentByKey("АлисаАмагаева", 2);

        assertNull(temp);
    }

    @Test
    public void editEmployeeDepartmentByBadDepByKey () {
        out.addEmployee("Дмитрий","Амагаев", 1, 50_000);
        Employee temp = out.editEmployeeDepartmentByKey("ДмитрийАмагаев", 10);

        assertNull(temp);
    }

    @Test
    public void editEmployeeSalaryByGoodSalaryByKey () {
        int expectedSalary = 110_000;

        out.addEmployee("Дмитрий","Амагаев", 1, 50_000);
        Employee temp = out.editEmployeeSalaryByKey("ДмитрийАмагаев", 110_000);

        assertEquals(expectedSalary, temp.getSalary());
    }

    @Test
    public void editEmployeeSalaryByGoodSalaryByBadKey () {
        out.addEmployee("Дмитрий","Амагаев", 1, 50_000);
        Employee temp = out.editEmployeeSalaryByKey("АлисаАмагаева", 20_000);

        assertNull(temp);
    }
}
