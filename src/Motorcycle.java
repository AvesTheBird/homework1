public class Motorcycle extends Vehicle implements Acceleratable, Brakable {
    private boolean helmetOn;
    private static int totalMotorcycles;

    public Motorcycle(String model, int speed, boolean helmetOn) {
        super(model, speed);
        this.helmetOn = helmetOn;
        totalMotorcycles++;
    }

    @Override
    public void accelerate() {
        if (helmetOn) {
            speed += 15;
            System.out.println(model + " ускоряется. Текущая скорость: " + speed + " км/ч.");
        } else {
            System.out.println("Оденьте шлем для ускорения.");
        }
    }

    @Override
    public void brake() {
        if (speed > 0) {
            speed -= 15;
            System.out.println(model + " тормозит. Текущая скорость: " + speed + " км/ч.");
        } else {
            System.out.println(model + " уже остановлен.");
        }
    }

    @Override
    public void displayInfo() {
        String helmetStatus = helmetOn ? "Шлем надет" : "Шлем не надет";
        System.out.println("Модель: " + model + ", Скорость: " + speed + " км/ч, " + helmetStatus);
    }

    public static int getTotalMotorcycles() {
        return totalMotorcycles;
    }
}
