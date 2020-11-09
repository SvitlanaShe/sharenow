package com.sharenow.utilities;

public class EmailPhoneGenerator {

    private static String emailPattern = "test+%s@gmail.com";

    public static String generateEmail(String data) {
        if (data.equals(""))
            data = emailPattern;
        return String.format(data, System.currentTimeMillis());
    }

    public static String generateMobilePhone(String length) {
        int lengthInt = Integer.parseInt(length);
        int max = (int) (Math.pow(10, lengthInt) - 1);
        int min = (int) Math.pow(10, lengthInt - 1);
        int range = max - min + 1;
        return String.valueOf((int) ((Math.random() * range) + min));
    }
}
