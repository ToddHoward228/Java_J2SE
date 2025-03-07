public class Employee {

    public Employee(String name, String department, double salary, int ID, int managerID) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.ID = ID;
        this.managerID = managerID;
    }

    private String name;
    private String department;
    private double salary;
    private int ID;
    private int managerID;

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getID() {
        return ID;
    }

    public int getManagerID() {
        return managerID;
    }

    public String toString() {
        return "Employee {" + "name='" + name + "', department='" + department +
                "', salary=" + salary + ", ID=" + ID +
                (managerID != -1 ? ", ManagerID=" + managerID : "") + "}";
    }
}
