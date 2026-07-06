package week1.designpatterns.dependencyinjection;

public class CustomerService {
    // Service depends on abstraction (CustomerRepository interface), NOT concrete class
    private final CustomerRepository customerRepository;

    // Constructor Injection (Dependency injected from outside)
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void displayCustomerInfo(String customerId) {
        System.out.println("[SERVICE] Fetching customer details via injected repository...");
        String customerData = customerRepository.findCustomerById(customerId);
        System.out.println("------------------------------------------------");
        System.out.println("  Result: " + customerData);
        System.out.println("------------------------------------------------\n");
    }
}
