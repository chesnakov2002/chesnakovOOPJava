package Parallelism;

public class CreditCard {
    private int money;

    public void addMoney(int moneyToAdd) {
        synchronized (this) {
            money += moneyToAdd;
        }
    }

    public int getMoney() {
        synchronized (this) {
            return money;
        }
    }
}

