// Interfaz PaymentMethod
interface PaymentMethod {
    void processPayment(double amount);
}

// Clase concreta para pagos con tarjeta de crédito
class CreditCard implements PaymentMethod {
    private String cardNumber;

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Procesando pago de $" + amount + " con tarjeta de crédito: " + cardNumber);
    }
}

// Clase concreta para pagos en efectivo
class Cash implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Procesando pago de $" + amount + " en efectivo.");
    }
}

// Clase concreta para pagos con criptomonedas
class Crypto implements PaymentMethod {
    private String walletAddress;

    public Crypto(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Procesando pago de $" + amount + " con criptomoneda en wallet: " + walletAddress);
    }
}

// Clase PaymentProcessor que usa la interfaz PaymentMethod
class PaymentProcessor {
    private PaymentMethod paymentMethod;

    public PaymentProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void executePayment(double amount) {
        paymentMethod.processPayment(amount);
    }
}

// Clase principal para probar
public class Main {
    public static void main(String[] args) {
        PaymentMethod creditCard = new CreditCard("1234-5678-9876");
        PaymentMethod cash = new Cash();
        PaymentMethod crypto = new Crypto("wallet123xyz");

        PaymentProcessor processor = new PaymentProcessor(creditCard);
        processor.executePayment(100.0);

        processor = new PaymentProcessor(cash);
        processor.executePayment(50.0);

        processor = new PaymentProcessor(crypto);
        processor.executePayment(200.0);
    }
}
