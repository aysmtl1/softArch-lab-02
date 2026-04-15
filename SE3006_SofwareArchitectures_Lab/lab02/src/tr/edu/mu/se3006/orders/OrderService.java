package tr.edu.mu.se3006.orders;

import tr.edu.mu.se3006.catalog.CatalogService;

class OrderService {

    // TODO: Define CatalogService and OrderRepository dependencies
    private final CatalogService catalogService;
    private final OrderRepository orderRepository;

    // TODO: Implement Constructor Injection
    OrderService(CatalogService catalogService, OrderRepository orderRepository) {
        this.catalogService = catalogService;
        this.orderRepository = orderRepository;
    }

    void placeOrder(Long productId, int quantity) {
        // TODO 1: Call catalogService to check and reduce stock
        // Eğer stok yetersizse CatalogServiceImpl hata fırlatacak ve işlem burada kesilecektir.
        catalogService.checkAndReduceStock(productId, quantity);

        // TODO 2: If successful, create a new Order and save it via OrderRepository
        Order newOrder = new Order(productId, quantity);
        orderRepository.save(newOrder);

        System.out.println("Order processed successfully for Product ID: " + productId);
    }
}
