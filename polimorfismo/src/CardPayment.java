// Clase CardPayment
public class CardPayment extends DigitalPayment {
    public CardPayment(String accountId) {
        super(accountId);
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing card payment of " + amount + " for account " + accountId);
    }
}
