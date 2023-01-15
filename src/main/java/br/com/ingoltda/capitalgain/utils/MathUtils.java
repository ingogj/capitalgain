package br.com.ingoltda.capitalgain.utils;

public class MathUtils {

    public static double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

}
