public class ValidationService {
    public boolean isUserValid(String nom, String password) {
        return nom.equals("quentin") && password.equals("plop");
    }
}
