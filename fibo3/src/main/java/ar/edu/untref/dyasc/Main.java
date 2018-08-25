package ar.edu.untref.dyasc;

import ParseResults.ArgumentsParseResult;
import ParseResults.OptionsParseResult;
import ar.edu.untref.dyasc.Enums.Direction;
import ar.edu.untref.dyasc.Enums.Orientation;

public class Main {

    public static void main(String args[]) {
        // Instanciamos las clases necesarias
        ArgumentsParser argsParser = new ArgumentsParser(args);
        ArgumentsParseResult parseResult;
        FiboPrinter printer = new FiboPrinter();
        Fibo fibo = new Fibo();
        // Parseamos los argumentos
        try {
            parseResult = argsParser.parseArguments();
        } catch (Exception e) {
            System.out.println("Opciones no validas.");
            return;
        }
        // Corroboramos que se haya ingresado un numero dentro de los argumentos
        if (parseResult.number == -1) {
            System.out.println("No se ingreso un numero valido");
            return;
        }
        // Si no se ingreso un argumento de opciones, generamos las opciones por
        // defecto
        if (parseResult.options == null) {
            parseResult.options = new OptionsParseResult();
            parseResult.options.direction = Direction.DIRECT;
            parseResult.options.orientation = Orientation.HORIZONTAL;
        }
        // Obtenemos el array de resultado de Fibonacci ordenado segun la
        // direccion
        int[] fiboResult = fibo.getSucesion(parseResult.number,
                parseResult.options.direction);
        // Dependiendo si se especifico o no un archivo de salida, ejecutamos al
        // encargado de la impresion correspondiente en pantalla
        if (parseResult.fileOutput == null) {
            printer.printSucesion(fiboResult, parseResult.options.orientation,
                    parseResult.workingMode.mode);
        } else {
            printer.printSucesionToFile(fiboResult,
                    parseResult.options.orientation,
                    parseResult.workingMode.mode, parseResult.fileOutput);
        }
    }
}