package utility;

import java.util.Random;

public class data {
    public static final String url = "http://demowebshop.tricentis.com/";
    public static final String firstName = "Isaac";
    public static final String lastName = "Ponteres";
    public static final String password = "foobar";
    public static final String confirmPassword = "foobar";
    public static final String product = "laptop";
    public static final String itemQuantity = "3";
    public static final String country = "Philippines";
    public static final String city = "Pangasinan";
    public static final String address1 = "Bolinao";
    public static final String zipCode = "2406";
    public static final String phoneNumber = "09778268888";

    public static String generateRandomString(){
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder(6);
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String result = sb.toString();

        return result;
    }

    @org.jetbrains.annotations.NotNull
    public static String generateRandomEmail(){
        String randomString = generateRandomString();
        String text1 = "isaac_stephen_";
        String emailUsername = text1+randomString;
        String email = emailUsername+"@yahoo.com";

        return email;
    }
    public static final String email = generateRandomEmail();

}

