import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", 0, 50);
        Motorcycle moto1 = new Motorcycle("Harley", 0, false);

        TransportStorage<Vehicle> transportStorage = new TransportStorage<>();
        transportStorage.add(car1);
        transportStorage.add(moto1);

        System.out.println("Транспорт в гараже:");
        transportStorage.displayAll();

        CarRepairService repairService = new CarRepairService();
        repairService.repair(car1);



        Scanner scanner = new Scanner(System.in);

        // Ввод числа для проверки деления на 13
        System.out.print("Введите число для проверки деления на 13: ");
        int number = scanner.nextInt();

        DivisibleByThirteen divisibleByThirteen = (n) -> n % 13 == 0;
        System.out.println(number + " делится на 13? " + divisibleByThirteen.check(number));

        // Ввод коэффициентов для вычисления дискриминанта
        System.out.println("Введите коэффициенты для уравнения вида ax^2 + bx + c = 0:");
        System.out.print("Введите a: ");
        double a = scanner.nextDouble();
        System.out.print("Введите b: ");
        double b = scanner.nextDouble();
        System.out.print("Введите c: ");
        double c = scanner.nextDouble();

        DiscriminantCalculator discriminantCalculator = (x, y, z) -> y * y - 4 * x * z;
        double discriminant = discriminantCalculator.calculate(a, b, c);
        System.out.println("Дискриминант для уравнения " + a + "x^2 + " + b + "x + " + c + " = 0 равен: " + discriminant);

        scanner.close();
    }
}
