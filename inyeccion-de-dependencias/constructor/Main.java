interface Engine {
    void start();
}


class GasolineEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Starting the gasoline engine...");
    }
}

class ElectricEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Starting the electric engine...");
    }
}
class Car {
    private final Engine engine;

    // Inyección de dependencia a través del constructor
    public Car(Engine engine) {
        this.engine = engine;
    }

    public void startCar() {
        engine.start();
        System.out.println("Car is ready to go!");
    }
}

public class Main {
    public static void main(String[] args) {
        // Creamos una instancia de Car con un motor de gasolina
        Engine gasolineEngine = new GasolineEngine();
        Car gasolineCar = new Car(gasolineEngine);
        gasolineCar.startCar();

        // Creamos una instancia de Car con un motor eléctrico
        Engine electricEngine = new ElectricEngine();
        Car electricCar = new Car(electricEngine);
        electricCar.startCar();
    }

}
