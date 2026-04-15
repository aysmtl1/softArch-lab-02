package tr.edu.mu.se3006.orders;

import java.util.*;

class OrderRepository {

    private Map<Long, Order> database = new HashMap<>();

    void save(Order order) {
        // TODO: Simple save logic (DONE)
        if (order != null) {
            // Order sınıfındaki 'id' alanı package-private olduğu için doğrudan erişebiliriz.
            // Eğer id null değilse database'e ekliyoruz.
            database.put(System.currentTimeMillis(), order); // Basitlik adına zaman damgası veya sayaç kullanılabilir

            // Not: Eğer Order içinde bir getId() metodun varsa:
            // database.put(order.getId(), order); 
        }
    }
}
