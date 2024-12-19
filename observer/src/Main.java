import java.util.ArrayList;
import java.util.List;

// Interfaz para los observadores
interface Observer {
    void update(String news);
}

// Interfaz para el sujeto
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Clase que representa una agencia de noticias
class NewsAgency implements Subject {
    private List<Observer> observers;
    private String news;

    public NewsAgency() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(news);
        }
    }

    public void setNews(String news) {
        this.news = news;
        notifyObservers();
    }
}

// Clase que representa un usuario que recibe noticias
class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " recibió la noticia: " + news);
    }
}
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();

        User user1 = new User("Juan");
        User user2 = new User("Ana");

        newsAgency.registerObserver(user1);
        newsAgency.registerObserver(user2);

        // Agregar noticias
        newsAgency.setNews("¡Nueva actualización de Java lanzada!");
        newsAgency.setNews("Patrón de diseño Observer explicado.");
    }
}