package pro.sky.skyprospringcoursework1;

public class Employee {
    private String name;
    private String surname;

    public Employee (String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName () {
        return this.name + " " + this.surname;
    }

    @Override
    public String toString () {
        return this.getName();
    }

    public boolean equals(Employee emp) {
        if (this.name == emp.name && this.surname == emp.surname) {
            return true;
        } else {
            return false;
        }
    }
}
