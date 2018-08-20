package ar.edu.untref.dyasc;

import ar.edu.untref.dyasc.Enums.Direction;
import ar.edu.untref.dyasc.Enums.Orientation;

public class Fibo {
    /*
     * Dado un numero devuelve el valor de la sucesion de Fibonacci
     * correspondiente a ese numero
     */
    private int fibo(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibo(n - 1) + fibo(n - 2);
        }
    }

    /*
     * Dado una orientacion, devuelve el separador correspondiente
     */
    private String getSeparator(Orientation orientation) {
        return orientation.equals(Orientation.VERTICAL) ? "\n" : " ";
    }

    /*
     * Dado un array de valores y un separador, devuelve los valores del array
     * de manera directa, separados por el separador
     */
    private String getDirectValues(int[] values, String separator) {
        String result = "";
        for (int i = 0; i < values.length; i++) {
            result += String.format(separator + "%d", values[i]);
        }
        return result;
    }

    /*
     * Dado un array de valores y un separador, devuelve los valores del array
     * de manera inversa, separados por el separador
     */
    private String getInverseValues(int[] values, String separator) {
        String result = "";
        for (int i = values.length - 1; i >= 0; i--) {
            result += String.format(separator + "%d", values[i]);
        }
        return result;
    }

    /*
     * Dado una cantidad numerica, devuelve el calculo de la sucesion de
     * fibonacci con una cantidad de iteraciones igual al valor ingresado por
     * parametro
     */
    public String getSerie(int quantity, Direction direction,
            Orientation orientation) {
        int[] serieResult = new int[quantity];
        String separator = getSeparator(orientation);
        for (int i = 0; i < quantity; i++) {
            serieResult[i] = fibo(i);
        }
        String result = String.format("fibo<%d>:", quantity);
        if (direction.equals(Direction.DIRECT)) {
            return result + getDirectValues(serieResult, separator);
        } else {
            return result + getInverseValues(serieResult, separator);
        }
    }
}