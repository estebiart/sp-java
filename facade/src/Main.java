//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HomeAutomationFacade homeAutomation = new HomeAutomationFacade();

        // Usuario llega a casa
        homeAutomation.arriveHome(22); // Establece la temperatura a 22 grados

        // Usuario sale de casa
        homeAutomation.leaveHome();
    }
}
// Clase para controlar las luces
class Light {
    public void turnOn() {
        System.out.println("Las luces están encendidas.");
    }

    public void turnOff() {
        System.out.println("Las luces están apagadas.");
    }
}

// Clase para controlar el termostato
class Thermostat {
    public void setTemperature(int temperature) {
        System.out.println("El termostato está configurado a " + temperature + " grados.");
    }
}

// Clase para el sistema de seguridad
class SecuritySystem {
    public void activate() {
        System.out.println("El sistema de seguridad está activado.");
    }

    public void deactivate() {
        System.out.println("El sistema de seguridad está desactivado.");
    }
}

// Clase Facade que proporciona una interfaz simplificada
class HomeAutomationFacade {
    private Light light;
    private Thermostat thermostat;
    private SecuritySystem securitySystem;

    public HomeAutomationFacade() {
        light = new Light();
        thermostat = new Thermostat();
        securitySystem = new SecuritySystem();
    }

    public void arriveHome(int temperature) {
        light.turnOn();
        thermostat.setTemperature(temperature);
        securitySystem.deactivate();
        System.out.println("Bienvenido a casa.");
    }

    public void leaveHome() {
        light.turnOff();
        securitySystem.activate();
        System.out.println("Hasta luego. Seguridad activada.");
    }
}
