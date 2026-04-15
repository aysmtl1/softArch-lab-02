package tr.edu.mu.se3006.orders;

// PUBLIC: Entry point for the Orders context.
public class OrderController {

    // TODO: Define OrderService dependency and use Constructor Injection (DONE)
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public void handleUserRequest(Long productId, int quantity) {
        System.out.println(">>> New Request: Product ID=" + productId + ", Quantity=" + quantity);

        // TODO: Call placeOrder inside a try-catch block. (DONE)
        try {
            orderService.placeOrder(productId, quantity);
            // Print "✅ Order Confirmed" on success
            System.out.println("✅ Order Confirmed");
        } catch (IllegalArgumentException e) {
            // Katalogdan gelen stok veya ürün bulunamadı hatalarını burada yakalıyoruz
            System.out.println("❌ ERROR: " + e.getMessage());
        } catch (Exception e) {
            // Beklenmedik diğer sistem hataları için
            System.out.println("❌ ERROR: An unexpected error occurred.");
        }
    }
}
