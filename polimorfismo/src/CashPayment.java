// Clase CashPayment
public class CashPayment implements PaymentMethod2 {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing cash payment of " + amount);
    }

    @Override
    public String getPaymentType() {
        return "Cash Payment";
    }
}
