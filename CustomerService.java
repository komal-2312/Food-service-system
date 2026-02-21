import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerService {
    private List<Customer> customers;

    public CustomerService() {
        customers = new ArrayList<>();
    }

    // Create
    public Customer createCustomer(Customer customer) {
        customers.add(customer);
        return customer;
    }

    // Read
    public Optional<Customer> getCustomerById(int id) {
        return customers.stream().filter(c -> c.getId() == id).findFirst();
    }

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers);
    }

    // Update
    public Optional<Customer> updateCustomer(int id, Customer updatedCustomer) {
        Optional<Customer> existingCustomerOpt = getCustomerById(id);
        existingCustomerOpt.ifPresent(existingCustomer -> {
            existingCustomer.setName(updatedCustomer.getName());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            // Update other fields as necessary
        });
        return existingCustomerOpt;
    }

    // Delete
    public boolean deleteCustomer(int id) {
        return customers.removeIf(c -> c.getId() == id);
    }
}