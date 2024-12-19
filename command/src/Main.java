// Clase que representa una luz
class Light {
    public void turnOn() {
        System.out.println("La luz está encendida.");
    }

    public void turnOff() {
        System.out.println("La luz está apagada.");
    }
}


// Interfaz para los comandos
interface Command {
    void execute();
}

// Clase para encender la luz
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

// Clase para apagar la luz
class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

// Clase para el control remoto
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl();

        // Encender la luz
        remote.setCommand(lightOn);
        remote.pressButton();

        // Apagar la luz
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}