
public class Main {
    public static void main(String[] args) {

        Registry reg = Registry.getRegistry();

        Employee e1 = new Employee("Alice", "IT", 50000, 1, 101);
        Employee e2 = new Employee("Bob", "IT", 55000, 2, 101);
        Employee e3 = new Employee("Charlie", "HR", 48000, 3, 102);
        Employee e4 = new Employee("David", "HR", 47000, 4, 102);
        Employee e5 = new Employee("Eve", "Sales", 51000, 5, 101);
        Employee e6 = new Employee("Frank", "Sales", 53000, 6, 101);
        Employee e7 = new Employee("Grace", "Marketing", 49000, 7, 102);
        Employee e8 = new Employee("Hank", "Marketing", 52000, 8, 102);

        Manager m1 = new Manager("Mike", "IT", 80000, 101, 10000);
        Manager m2 = new Manager("Nancy", "HR", 85000, 102, 12000);

        reg.addWorker(m1);
        reg.addWorker(m2);
        reg.addWorker(e1);
        reg.addWorker(e2);
        reg.addWorker(e3);
        reg.addWorker(e4);
        reg.addWorker(e5);
        reg.addWorker(e6);
        reg.addWorker(e7);
        reg.addWorker(e8);

        reg.printList();
    }
}