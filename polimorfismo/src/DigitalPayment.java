// Clase abstracta DigitalPayment
public abstract class DigitalPayment implements PaymentMethod2 {
    protected String accountId;

    public DigitalPayment(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public String getPaymentType() {
        return "Digital Payment";
    }
}
