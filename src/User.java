public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public static User login(String username, String password) throws CustomException {
        if (username.isEmpty() || password.isEmpty()) {
            throw new CustomException("Username or password cannot be empty.");
        }
        // In a real system, add authentication logic here
        return new User(username, password);
    }
}
