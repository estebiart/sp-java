//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();

        Notification email = factory.createNotification("EMAIL");
        email.send("Hola, esta es una notificación por correo.");

        Notification sms = factory.createNotification("SMS");
        sms.send("Hola, este es un mensaje SMS.");

        Notification push = factory.createNotification("PUSH");
        push.send("Hola, esta es una notificación push.");
    }
}
// Interfaz Notification
interface Notification {
    void send(String message);
}

// Implementación de EmailNotification
class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Enviando correo: " + message);
    }
}

// Implementación de SMSNotification
class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Enviando SMS: " + message);
    }
}

// Implementación de PushNotification
class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Enviando notificación push: " + message);
    }
}

// Clase NotificationFactory con el método Factory Method
class NotificationFactory {
    public Notification createNotification(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }
        switch (type) {
            case "EMAIL":
                return new EmailNotification();
            case "SMS":
                return new SMSNotification();
            case "PUSH":
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Tipo de notificación desconocido: " + type);
        }
    }
}
