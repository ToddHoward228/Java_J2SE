import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private String dept;
    private int salary;
    private List<Employee> subordinates;

    public Employee(String name, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public void addSub(Employee e) {
        if (subordinates == null) {
            subordinates = new ArrayList<>();
        }

        subordinates.add(e);
    }
    public void removeSub(Employee e) {
        subordinates.remove(e);
    }
    public List<Employee> getSubordinates() {
        return subordinates;
    }

    @Override
    public String toString() {
        return String.format("Employee{Name=%s, Dept=%s, Salary=%d}", name, dept, salary);
    }
}
