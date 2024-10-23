import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("login: ");
        String login = scanner.nextLine();

        System.out.print("password: ");
        String password = scanner.nextLine();

        System.out.print("confirmPassword: ");
        String confirmPassword = scanner.nextLine();

        boolean isValid = UserValidator.validateCredentials(login, password, confirmPassword);

        if (isValid) {
            System.out.println("Валидация пройдена успешно.");
        } else {
            System.out.println("Валидация не пройдена.");
        }
    }
}
