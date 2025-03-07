
public class CompositePatternDemo {
    public static void main(String[] args) {

        Employee root = new Employee("Alexander Carter", "Accounting", 50000);

        Employee mgr1 = new Employee("Olivia Reynolds", "IT", 45000);
        Employee mgr2 = new Employee("Benjamin Harrison", "Sales1", 24690);
        Employee mgr3 = new Employee("Sophia Mitchell", "Research", 32000);
        Employee mgr4 = new Employee("Daniel Cooper", "Sales2", 25000);

        root.addSub(mgr1);
        root.addSub(mgr2);
        root.addSub(mgr3);
        root.addSub(mgr4);

        mgr1.addSub(new Employee("Emily Thompson", "IT", 24000));
        mgr1.addSub(new Employee("Nathaniel Brooks", "IT", 23000));
        mgr1.addSub(new Employee("Isabella Scott", "IT", 21000));
        mgr1.addSub(new Employee("William Bennett", "IT", 22000));

        mgr2.addSub(new Employee("Charlotte Hayes", "Sales1", 12000));
        mgr2.addSub(new Employee("Christopher Sullivan", "Sales1", 11000));
        mgr2.addSub(new Employee("Amelia Parker", "Sales1", 15000));

        mgr3.addSub(new Employee("Jonathan Wright", "Research", 12000));
        mgr3.addSub(new Employee("Victoria Adams", "Research", 12000));

        mgr4.addSub(new Employee("Samuel Richardson", "Sales2", 13680));
        mgr4.addSub(new Employee("Grace Morgan", "Sales2", 14890));
        mgr4.addSub(new Employee("Elijah Foster", "Sales2", 12000));

        Employee.RecursiveShow(root);

    }
}