public class UserValidator {

    public static boolean validateCredentials(String login, String password, String confirmPassword) {
        try {
            // Проверка login
            if (!login.matches("[a-zA-Z0-9_]+") || login.length() >= 20) {
                throw new WrongLoginException("Login должен содержать только латинские буквы, цифры и знак подчеркивания и быть короче 20 символов.");
            }

            if (!password.matches("[a-zA-Z0-9_]+") || password.length() >= 20) {
                throw new WrongPasswordException("Password должен содержать только латинские буквы, цифры и знак подчеркивания и быть короче 20 символов.");
            }

            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Password и confirmPassword не совпадают.");
            }

            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Ошибка: " + e.getMessage());
            return false;
        }
    }
}
