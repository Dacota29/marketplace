public class ProductImpl implements Product {

    final private int id;
    final private String name;
    final private double price;

    public ProductImpl(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ProductImpl{" +
                " name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
