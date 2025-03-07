public class Manager extends Employee {

    public Manager(String name, String department, double salary, int ID, double bonus) {
        super(name, department, salary, ID, -1);
        this.bonus = bonus;
    }

    private double bonus;

    public double getBonus() {
        return bonus;
    }
    public double getIncome() {
        return bonus + getSalary();
    }

    @Override
    public String toString() {
        return "Manager {" + "name='" + getName() + "', department='" + getDepartment() +
                "', salary=" + getSalary() + ", ID=" + getID() + ", bonus=" + bonus + "}";
    }
}
