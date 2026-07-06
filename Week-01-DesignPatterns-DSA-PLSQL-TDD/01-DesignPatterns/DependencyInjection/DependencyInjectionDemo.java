package week1.designpatterns.dependencyinjection;

public class DependencyInjectionDemo {
    public static void main(String[] args) {
        System.out.println("=== Exercise 11: Testing Dependency Injection with Customer Management System ===");

        // 1. Instantiate Concrete Repository (The Dependency)
        CustomerRepository repository = new CustomerRepositoryImpl();

        // 2. Inject Repository into CustomerService via Constructor Injection
        CustomerService service = new CustomerService(repository);

        // 3. Execute business logic
        System.out.println("\n--- Querying Valid Customer ---");
        service.displayCustomerInfo("CUST-1001");

        System.out.println("--- Querying Another Customer ---");
        service.displayCustomerInfo("CUST-1002");

        System.out.println("--- Querying Non-Existent Customer ---");
        service.displayCustomerInfo("CUST-9999");
    }
}
