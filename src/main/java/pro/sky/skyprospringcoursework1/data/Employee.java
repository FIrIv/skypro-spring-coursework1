package pro.sky.skyprospringcoursework1.data;

import org.apache.commons.lang3.StringUtils;
import pro.sky.skyprospringcoursework1.exception.BadRequestException;

import java.util.Objects;

public class Employee {
    private String name;
    private String surname;
    private int department; // значения отделов - от 1 до 5
    private int salary;

    public Employee (String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.department = 0;
        this.salary = 0;
    }

    public Employee (String name, String surname, int department, int salary) {
        this.name = name;
        this.surname = surname;
        if (department >=1 && department <= 5) {
            this.department = department;
        } else {
            this.department = 0;
        }
        this.salary = salary;
    }

    public String getName () {
        return this.name;
    }

    public String getSurname () {
        return this.surname;
    }

    public int getDepartment () {
        return this.department;
    }

    public int getSalary () {
        return this.salary;
    }

    public void setDepartment (int department) {
        if (department >=1 && department <= 5) this.department = department;
    }

    public void setSalary (int salary) {
        this.salary = salary;
    }

    @Override
    public String toString () {
        return this.getName() + " " + this.getSurname()+ ", отдел №" + this.getDepartment() + ", оклад " + this.getSalary() + " руб.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return name.equals(employee.name) && surname.equals(employee.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}
