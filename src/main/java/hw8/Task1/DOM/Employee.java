package hw8.Task1.DOM;

public class Employee {
    private String name, position, department;
    private int term;

    public Employee(String name, String position, String department, int term) {
        this.name = name;
        this.position = position;
        this.department = department;
        this.term = term;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public int getTerm() {
        return term;
    }
}
