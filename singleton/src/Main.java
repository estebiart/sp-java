//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Intentamos obtener la instancia de DatabaseConnection
        DatabaseConnection dbConnection1 = DatabaseConnection.getInstance();
        dbConnection1.connect();

        // Intentamos obtener la instancia nuevamente
        DatabaseConnection dbConnection2 = DatabaseConnection.getInstance();
        dbConnection2.disconnect();

        // Verificamos que ambas instancias son la misma
        System.out.println("¿Ambas instancias son iguales? " + (dbConnection1 == dbConnection2));
    }
}
