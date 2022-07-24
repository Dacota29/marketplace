public interface User {
    int getId();
    String getFirstName();
    String getLastName();
    double getAmountOfMoney();

    void chargeMoney(double amount);
}

