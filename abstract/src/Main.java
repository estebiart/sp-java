//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UIFactory factory;

        // Simulamos una configuración de sistema operativo
        String osType = "MacOS";  // Cambia a "Windows" para probar el otro caso

        // Selección de la fábrica según el sistema operativo
        if (osType.equals("Windows")) {
            factory = new WindowsFactory();
        } else if (osType.equals("MacOS")) {
            factory = new MacFactory();
        } else {
            throw new IllegalArgumentException("Sistema operativo desconocido.");
        }

        // Crear y usar los componentes
        Button button = factory.createButton();
        Dialog dialog = factory.createDialog();

        button.paint();
        dialog.render();
    }
}
// Interfaz para botones
interface Button {
    void paint();
}

// Interfaz para diálogos
interface Dialog {
    void render();
}

// Implementación de botón en Windows
class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Dibujando botón estilo Windows.");
    }
}

// Implementación de diálogo en Windows
class WindowsDialog implements Dialog {
    @Override
    public void render() {
        System.out.println("Renderizando cuadro de diálogo estilo Windows.");
    }
}

// Implementación de botón en MacOS
class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("Dibujando botón estilo MacOS.");
    }
}

// Implementación de diálogo en MacOS
class MacDialog implements Dialog {
    @Override
    public void render() {
        System.out.println("Renderizando cuadro de diálogo estilo MacOS.");
    }
}

// Interfaz de fábrica abstracta
interface UIFactory {
    Button createButton();
    Dialog createDialog();
}

// Fábrica concreta para crear elementos estilo Windows
class WindowsFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Dialog createDialog() {
        return new WindowsDialog();
    }
}

// Fábrica concreta para crear elementos estilo MacOS
class MacFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Dialog createDialog() {
        return new MacDialog();
    }
}
