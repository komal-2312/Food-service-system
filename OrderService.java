import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderService {
    private List<Order> orders = new ArrayList<>();

    // Create new order
    public Order createOrder(Order order) {
        orders.add(order);
        return order;
    }

    // Read order by ID
    public Optional<Order> getOrderById(int id) {
        return orders.stream().filter(order -> order.getId() == id).findFirst();
    }

    // Update existing order
    public Optional<Order> updateOrder(int id, Order updatedOrder) {
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            if (order.getId() == id) {
                orders.set(i, updatedOrder);
                return Optional.of(updatedOrder);
            }
        }
        return Optional.empty();
    }

    // Delete order by ID
    public boolean deleteOrder(int id) {
        return orders.removeIf(order -> order.getId() == id);
    }

    // List all orders
    public List<Order> listOrders() {
        return new ArrayList<>(orders);
    }
}
