public class UserImpl implements User {
    final private int id;
    final private String firstName;
    final private String lastName;
    private double amountOfMoney;

    public UserImpl(int id, String firstName, String lastName, double amountOfMoney) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.amountOfMoney = amountOfMoney;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public double getAmountOfMoney() {
        return amountOfMoney;
    }

    @Override
    public void chargeMoney(double amount) {
        amountOfMoney = amountOfMoney - amount;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", amountOfMoney=" + amountOfMoney +
                '}';
    }
}
