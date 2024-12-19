// Interfaz de estrategia de pago
interface PaymentStrategy {
    void pay(double amount);
}

// Implementación de pago con tarjeta de crédito
class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Pagando " + amount + " con tarjeta de crédito.");
    }
}

// Implementación de pago con PayPal
class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Pagando " + amount + " con PayPal.");
    }
}

// Clase que representa un carrito de compras
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(double amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Método de pago no establecido.");
        }
        paymentStrategy.pay(amount);
    }
}


public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Usar tarjeta de crédito para el pago
        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout(100.00);

        // Cambiar a PayPal para el siguiente pago
        cart.setPaymentStrategy(new PayPalPayment());
        cart.checkout(200.00);
    }
}