// Clase Singleton
public class DatabaseConnection {
    // La única instancia de la clase
    private static DatabaseConnection instance;

    // Constructor privado para evitar la creación de instancias adicionales
    private DatabaseConnection() {
        System.out.println("Estableciendo conexión a la base de datos...");
    }

    // Método para obtener la única instancia
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void connect() {
        System.out.println("Conectado a la base de datos.");
    }

    public void disconnect() {
        System.out.println("Desconectado de la base de datos.");
    }
}
