import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserInterface {
    private final Marketplace marketplace;


    public UserInterface(Marketplace marketplace) {
        this.marketplace = marketplace;
    }

    public void run() {
        greetings();
        while (true) {
            var input = readInput();
            processCommand(input);
        }
    }

    private void greetings() {
        System.out.println("Hi there! It's Marketplace.");
        System.out.println("There are three different commands to interact with the Marketplace.");
        System.out.println("To execute a command enter it's id and pass the params with spaces.\n");
        System.out.println("Command #1. Purchase products. To do that enter command id('1') than userId and productId in the next format:\n1 <userId> <productID>");
        System.out.println("Command #2. Get the list of products purchased by user. To do that enter command id('2') than userId :\n2 <userId> ");
        System.out.println("Command #3. Get the list of users purchased the product. To do that enter command id('3') than productId :\n2 <productId> ");
    }

    // returns List of up to three elements. command id and parameters(either user id or product id, or both)
    private List<Integer> readInput() {
        var scanner = new Scanner(System.in);
        var line = scanner.nextLine();
        var params = line.split("\\s+");
        var paramsList = Arrays.asList(params);

        return paramsList.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    private void processCommand(List<Integer> params) {
        var commandId = params.get(0);

        if (commandId.equals(1)) {
            var userId = params.get(1);
            var productId = params.get(2);
            if (marketplace.buyProduct(userId, productId)) {
                System.out.println("Purchase successful!");
            }
        } else if (commandId.equals(2)) {
            var userId = params.get(1);
            var products = marketplace.getPurchasedProductsForUser(userId);
            if (products.isEmpty()) System.out.println();
            else {
                System.out.println(Arrays.toString(products.toArray()));
            }
        } else {
            var productId = params.get(1);
            var users = marketplace.getUsersWhoPurchasedProduct(productId);
            if (users.isEmpty()) System.out.println();
            else {
                System.out.println(Arrays.toString(users.toArray()));
            }
        }
    }
}
