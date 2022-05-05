package pro.sky.skyprospringcoursework1;

public class Employee {
    private String name;
    private String surname;

    public Employee (String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName () {
        return this.name;
    }

    public String getSurname () {
        return this.surname;
    }

    @Override
    public String toString () {
        return this.getName() + " " + this.getSurname();
    }

    public boolean equals (Employee temp) {
        if (this.name.equals(temp.name) && this.surname.equals(temp.surname)) {
            return true;
        } else {
            return false;
        }
    }
}
