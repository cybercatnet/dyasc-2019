package ar.edu.untref.dyasc;

import ar.edu.untref.dyasc.Enums.Direction;
import ar.edu.untref.dyasc.Enums.Orientation;

public class Main {
    /*
     * Dado un string correspondiente al parametro de opciones, devuelve
     * un objeto de tipo ParametersParseResult que contiene la orientacion
     * y la direccion a utilizar para imprimir el resultado de la operacion
     */
    public ParametersParseResult parseParameters(String inputOption) {
        ParametersParseResult result = new ParametersParseResult();
        String orientationValue = inputOption.substring(0, 1);
        String directionValue = inputOption.substring(1, 2);
        try {
            if (orientationValue.equals("v")) {
                result.orientation = Orientation.VERTICAL;
            } else if (orientationValue.equals("h")) {
                result.orientation = Orientation.HORIZONTAL;
            } else {
                throw new Exception();
            }
            if (directionValue.equals("d")) {
                result.direction = Direction.DIRECT;
            } else if (directionValue.equals("i")) {
                result.direction = Direction.INVERSE;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            return null;
        }
        return result;
    }

    /*
     * Dado un array de argumentos, devuelve(si es que existe) el string de
     * dos caracteres correspondiente a las opciones a utilizar 
     */
    public String getOptionParameter(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].length() == 5 && args[i].substring(0, 3).equals("-o=")) {
                return args[i].substring(3, 5);
            }
        }
        return "";
    }

    public static void main(String args[]) {
        Main main = new Main();
        int inputValue = Integer.valueOf(args[args.length - 1]);
        Fibo fibo = new Fibo();
        String optionParameters = main.getOptionParameter(args);
        String serieResult = "";
        if(!optionParameters.equals("")){
            ParametersParseResult parsedParams = main
                    .parseParameters(optionParameters);
            if (parsedParams == null) {
                System.out.println("Opciones no validas.");
                return;
            }
            serieResult = fibo.getSerie(inputValue, parsedParams.direction,
                    parsedParams.orientation);
        }else {
            serieResult = fibo.getSerie(inputValue, Direction.DIRECT,
                    Orientation.HORIZONTAL);
        }
        
        System.out.println(serieResult);
    }
}