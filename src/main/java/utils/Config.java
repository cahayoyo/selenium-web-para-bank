package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Config {
    public static final String URL = "https://parabank.parasoft.com/parabank/index.htm";
    public static final String URL_REGISTER = "https://parabank.parasoft.com/parabank/register.htm";

    public static final String FIRST_NAME = "Anugerah Cahaya";
    public static final String LAST_NAME = "Utama";
    public static final String ADDRESS = "Margonda";
    public static final String CITY = "Depok";
    public static final String STATE = "West Java";
    public static final String ZIP_CODE = "16411";
    public static final String PHONE = "6281269696969";
    public static final String SSN = "696969696969";
    public static final String USERNAME = "cahayoyo";
    public static final String PASSWORD = "Password1234!";

    private static final Random random = new Random();

    public static String getUniqueUsername() {
        StringBuilder sb = new StringBuilder("cahaya_");
        for (int i = 0; i < 5; i++) {
            char randomChar = (char) ('a' + random.nextInt(26));
            sb.append(randomChar);
        }
        return sb.toString();
    }
}
