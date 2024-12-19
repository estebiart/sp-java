// Clase CryptoPayment
public class CryptoPayment extends DigitalPayment {
    public CryptoPayment(String accountId) {
        super(accountId);
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing crypto payment of " + amount + " for wallet " + accountId);
    }
}
