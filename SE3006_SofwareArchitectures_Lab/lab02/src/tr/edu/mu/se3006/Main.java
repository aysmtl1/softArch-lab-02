package tr.edu.mu.se3006;

import tr.edu.mu.se3006.catalog.CatalogFactory;
import tr.edu.mu.se3006.catalog.CatalogService;
import tr.edu.mu.se3006.orders.OrderController;
import tr.edu.mu.se3006.orders.OrdersFactory;

public class Main {

    public static void main(String[] args) {
        System.out.println("🚀 System Starting in Modular Monolith Mode...");
        System.out.println("----------------------------------------------\n");

        // TODO 1: Create the Catalog Module via its Factory (DONE)
        // CatalogService interface'ini alıyoruz, impl detaylarını görmüyoruz.
        CatalogService catalog = CatalogFactory.create();

        // TODO 2: Create the Orders Module via its Factory, passing the catalog module (DONE)
        // Orders modülü çalışmak için CatalogService'e ihtiyaç duyar (Dependency Injection).
        OrderController controller = OrdersFactory.create(catalog);

        System.out.println("--- Test Scenarios ---");

        // TODO 3: Call handleUserRequest via the controller to test the system (DONE)
        // Senaryo 1: Başarılı Sipariş (MacBook Pro - Stokta 5 adet var)
        controller.handleUserRequest(1L, 2);

        // Senaryo 2: Başarılı Sipariş (Aynı üründen devam, stok 3'e düşmüştü)
        controller.handleUserRequest(1L, 1);

        // Senaryo 3: Yetersiz Stok Hatası (Kalan stok 2, istenen 10)
        controller.handleUserRequest(1L, 10);

        // Senaryo 4: Olmayan Ürün Hatası
        controller.handleUserRequest(99L, 1);

        System.out.println("\n----------------------------------------------");
        System.out.println("✅ Lab 02: Modular Monolith Refactoring Completed.");
    }
}
