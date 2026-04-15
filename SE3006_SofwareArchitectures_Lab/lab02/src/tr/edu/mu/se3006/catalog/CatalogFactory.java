package tr.edu.mu.se3006.catalog;

// PUBLIC Factory: Assembles the internal components and exposes ONLY the interface.
public class CatalogFactory {

    public static CatalogService create() {
        // TODO: Instantiate ProductRepository (DONE)
        ProductRepository repository = new ProductRepository();

        // TODO: Instantiate CatalogServiceImpl using the repository (DONE)
        CatalogServiceImpl serviceImpl = new CatalogServiceImpl(repository);

        // TODO: Return the CatalogServiceImpl instance (DONE)
        // Note: It is returned as CatalogService (Interface) to maintain information hiding.
        return serviceImpl;
    }
}
