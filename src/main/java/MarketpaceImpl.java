import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MarketpaceImpl implements Marketplace {

    final private Map<Integer, User> users = new HashMap<>();

    final private Map<Integer, Product> products = new HashMap<>();

    // for every user(by Id) store the list of purchaser products
    // TODO: consider storing list of product ids only, instead of whole products;
    final private Map<Integer, List<Product>> purchases = new HashMap<>();

    final private Map<Integer, List<User>> usersByProducts = new HashMap<>();

    public MarketpaceImpl(List<User> newUsers, List<Product> newProducts) {
        newUsers.forEach(usr -> users.put(usr.getId(), usr));
        newProducts.forEach(prdct -> products.put(prdct.getId(), prdct));
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) users.values();
    }

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) products.values();
    }

    @Override
    public boolean buyProduct(int userId, int productId) {
        var user = users.get(userId);
        var userMoney = user.getAmountOfMoney();

        var product = products.get(productId);
        var productCost = product.getPrice();

        if (productCost > userMoney) {
            throw new RuntimeException("Not enough money. User balance: " + userMoney + "; Product cost: " + productCost);
        } else {
            user.chargeMoney(productCost);
            return addPurchaseForUser(userId, product) && updateUsersByProducts(productId, user);
        }
    }

    @Override
    public List<Product> getPurchasedProductsForUser(int userId) {
        var products = purchases.get(userId);
        if (products == null) {
            return new LinkedList<>();
        } else {
            return products;
        }
    }

    @Override
    public List<User> getUsersWhoPurchasedProduct(int productId) {
        var users = usersByProducts.get(productId);
        if (users == null) {
            return new LinkedList<>();
        } else {
            return users;
        }
    }

    private boolean addPurchaseForUser(int userId, Product product) {
        var userPurchases = purchases.get(userId);
        if (userPurchases == null) {
            var purchasedProductsList = new LinkedList<Product>();
            purchasedProductsList.add(product);
            purchases.put(userId, purchasedProductsList);
        }
        else  {
            userPurchases.add(product);
            purchases.put(userId, userPurchases);
        }
        return true;
    }

    private boolean updateUsersByProducts(int productId, User user) {
        var users = usersByProducts.get(productId);
        if (users == null) {
            var usersPurchasedTheProductList = new LinkedList<User>();
            usersPurchasedTheProductList.add(user);
            usersByProducts.put(productId, usersPurchasedTheProductList);
        } else {
            users.add(user);
            usersByProducts.put(productId, users);
        }

        return true;
    }
}
