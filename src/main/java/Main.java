import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> defaultUsers = List.of(
                new UserImpl(1, "John", "Doe", 100.0),
                new UserImpl(2, "Jane", "Doe", 250.0),
                new UserImpl(3, "Viacheslav", "Rudnytskyi", 1000.0)
                );

        List<Product> defaultProducts = List.of(
                new ProductImpl(1, "Phone",  100.0),
                new ProductImpl(2, "Icecream", 2.5),
                new ProductImpl(3, "Book", 9.0)
        );

        Marketplace marketplace = new MarketpaceImpl(defaultUsers, defaultProducts);

        UserInterface ui = new UserInterface(marketplace);
        ui.run();

    }
}
