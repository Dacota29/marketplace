import java.util.List;

public interface Marketplace {
    List<User> getAllUsers();
    List<Product> getAllProducts();
    boolean buyProduct(int userId, int productId);

    List<Product> getPurchasedProductsForUser(int userId);

    List<User> getUsersWhoPurchasedProduct(int productId);

}

