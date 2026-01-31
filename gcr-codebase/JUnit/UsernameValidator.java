public class UsernameValidator {

    public static boolean isValidUsername(String username) {
        String regex = "^[A-Za-z][A-Za-z0-9_]{4,14}$";
        return username.matches(regex);
    }

    public static void main(String[] args) {
        String[] usernames = {
            "user_123",
            "123user",
            "us",
            "User_Name1"
        };

        for (String user : usernames) {
            System.out.println(user + " -> " +
                (isValidUsername(user) ? "Valid" : "Invalid"));
        }
    }
}
