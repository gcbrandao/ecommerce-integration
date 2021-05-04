package br.com.spot.ecommerceintegration.util;

public class EntityUtil {

    private EntityUtil() {
    }

    public static String getFirstName(String fullName) {
        return fullName.split(" ")[0];
    }

    public static String getLastName(String fullName) {

        int start = fullName.indexOf(' ');
        int end = fullName.length();

        if (start >= 0 && end > start) {
            return fullName.substring(start + 1, end);
        }

        return "";
    }
}
