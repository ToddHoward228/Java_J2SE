import java.util.ArrayList;
import java.util.List;

public class Registry {
    private static Registry WorkersRegistry;

    private Registry() {}

    private List<Employee> workers = new ArrayList<Employee>();

    public static Registry getRegistry() {
        if (WorkersRegistry == null) {
            WorkersRegistry = new Registry();
        }
        return WorkersRegistry;
    }

    void addWorker(Employee emp) {
        if (workers.contains(emp)) {
            throw new EmployeeInRegistryException("Worker already in registry");
        }
        else
            workers.add(emp);
    }
    void removeWorker(Employee emp) {
        workers.remove(emp);
    }

    void printList() {
        for (Employee worker : workers) {
            System.out.println(worker.toString());
        }
    }
}

