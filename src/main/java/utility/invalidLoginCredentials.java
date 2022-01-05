package utility;

public class invalidLoginCredentials {
    public static final String scenario = ["Invalid Username TC", "Invalid Password TC", "Blank Username and Password TC"];
    public static final String username = ["isaacstephen", "isaacstephen1@yahoo.com", ""];
    public static final String password = ["123456", "", ""];
    public static final String expectedErrorMessage = ["Please enter a valid email address.", "The credentials provided are incorrect", "No customer account found"];
}
