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

        subordinates = new ArrayList<>();
    }

    public void addSub(Employee e) {
        subordinates.add(e);
    }
    public void removeSub(Employee e) {
        subordinates.remove(e);
    }
    public static void RecursiveShow(Employee emp){
        System.out.println(emp);
        for (int i = 0; i < emp.getSubordinates().size(); i++) {

            System.out.println("\t" + emp.getSubordinates().get(i));
            RecursiveShow(emp.getSubordinates().get(i), 2);

        }
    }
    private static void RecursiveShow(Employee emp, int level) {

        for (int i = 0; i < emp.getSubordinates().size(); i++) {

            System.out.println("\t".repeat(level) + emp.getSubordinates().get(i));
            RecursiveShow(emp.getSubordinates().get(i), level + 1);

        }
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    @Override
    public String toString() {
        return String.format("Employee{Name=%s, Dept=%s, Salary=%d}", name, dept, salary);
    }
}
