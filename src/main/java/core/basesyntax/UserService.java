package core.basesyntax;

public class UserService {
    private PasswordValidator passwordValidator;

    public UserService() {
        this.passwordValidator = new PasswordValidator();
    }

    public void registerUser(User user) {
        try {
            passwordValidator.validate(user.getPassword(), user.getRepeatPassword());
            saveUser(user);
            System.out.println("User registered successfully.");
        } catch (PasswordValidationException e) {
            System.out.println("Your passwords are incorrect. Try again.");
        }
    }

    public void saveUser(User user) {
        System.out.println("User " + user.toString() + " was saved to database!!!");
    }
}
