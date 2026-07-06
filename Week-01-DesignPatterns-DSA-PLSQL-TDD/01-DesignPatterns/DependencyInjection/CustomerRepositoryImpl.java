package week1.designpatterns.dependencyinjection;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private final Map<String, String> customerDatabase = new HashMap<>();

    public CustomerRepositoryImpl() {
        customerDatabase.put("CUST-1001", "Ashish Kumar Chahar (GenC Next Candidate)");
        customerDatabase.put("CUST-1002", "Priya Verma (Enterprise Architect)");
        customerDatabase.put("CUST-1003", "Rahul Sharma (Cloud DevOps Lead)");
    }

    @Override
    public String findCustomerById(String id) {
        System.out.println("[REPOSITORY] Querying database for Customer ID: " + id);
        return customerDatabase.getOrDefault(id, "Customer Not Found!");
    }
}
