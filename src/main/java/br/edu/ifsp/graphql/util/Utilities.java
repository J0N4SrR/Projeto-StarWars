package br.edu.ifsp.graphql.util;

public class Utilities {
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    public static int ConvertToNumeric(String str) {
        if (isNumeric(str)) return Integer.parseInt(str);
        throw new NumberFormatException();

    }
}
