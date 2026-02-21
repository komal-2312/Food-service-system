import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private List<Order> orders = new ArrayList<>();

    // Create Order
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        orders.add(order);
        return order;
    }

    // Read Order
    @GetMapping("/{id}")
    public Order getOrder(@PathVariable int id) {
        return orders.stream().filter(o -> o.getId() == id).findFirst().orElse(null);
    }

    // Update Order
    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable int id, @RequestBody Order updatedOrder) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() == id) {
                orders.set(i, updatedOrder);
                return updatedOrder;
            }
        }
        return null;
    }

    // Delete Order
    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable int id) {
        orders.removeIf(o -> o.getId() == id);
        return "Order deleted successfully!";
    }

    // List all Orders
    @GetMapping
    public List<Order> getAllOrders() {
        return orders;
    }
}

class Order {
    private int id;
    private String name;
    private int quantity;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}