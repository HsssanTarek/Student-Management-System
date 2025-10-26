package backend;

public class AccessController {
    private final String username = "Admin";
    private final String password = "1234";

    public boolean login(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            return true;
        }
        return false;
    }
}
