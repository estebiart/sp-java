//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Crear una notificación básica
        Notifier notifier = new BasicNotifier();

        // Añadir notificación por email usando el decorador
        Notifier emailNotifier = new EmailNotifier(notifier);

        // Añadir notificación por SMS y email usando decoradores
        Notifier smsEmailNotifier = new SMSNotifier(emailNotifier);

        // Enviar notificación por todos los canales
        smsEmailNotifier.send("¡Alerta de sistema!");
    }
}
// Interfaz Notifier
interface Notifier {
    void send(String message);
}

// Clase básica de notificación
class BasicNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Enviando notificación básica: " + message);
    }
}

// Clase abstracta Decorator que implementa Notifier
abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message);
    }
}

// Decorador para enviar notificaciones por email
class EmailNotifier extends NotifierDecorator {
    public EmailNotifier(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendEmailNotification(message);
    }

    private void sendEmailNotification(String message) {
        System.out.println("Enviando notificación por email: " + message);
    }
}

// Decorador para enviar notificaciones por SMS
class SMSNotifier extends NotifierDecorator {
    public SMSNotifier(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSMSNotification(message);
    }

    private void sendSMSNotification(String message) {
        System.out.println("Enviando notificación por SMS: " + message);
    }
}
