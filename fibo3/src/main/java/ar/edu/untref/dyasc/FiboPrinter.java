package ar.edu.untref.dyasc;

import java.io.PrintWriter;

import ar.edu.untref.dyasc.Enums.Orientation;
import ar.edu.untref.dyasc.Enums.WorkingMode;

public class FiboPrinter {
    /*
     * Dado un array correspondiente a una sucesion, un separador de texto y un
     * modo de trabajo, genera una cadena de texto con formato generado a partir
     * de los parametro brindados
     */
    private String generateSucesionString(int[] sucesion, String separator,
            WorkingMode workingMode) {
        String result = "";
        if (workingMode.equals(WorkingMode.SUM)) {
            int sum = 0;
            for (int i = 0; i < sucesion.length; i++) {
                sum += sucesion[i];
            }
            result = String.format("fibo<%d>s:%s%d", sucesion.length,
                    separator, sum);
        } else {
            result = String.format("fibo<%d>:", sucesion.length);
            for (int i = 0; i < sucesion.length; i++) {
                result += String.format(separator + "%d", sucesion[i]);
            }
        }
        return result;
    }

    /*
     * Dado un array correspondiente a una sucesion, una orientacion y un modo
     * de trabajo; imprime en pantalla el resultado de transformar la sucesion a
     * un string aplicando el formato correspondiente a los parametros brindados
     */
    public void printSucesion(int[] sucesion, Orientation orientation,
            WorkingMode workingMode) {
        String separator = getSeparator(orientation);
        String result = generateSucesionString(sucesion, separator, workingMode);
        System.out.println(result);
    }

    /*
     * Dado un array correspondiente a una sucesion, una orientacion, un modo de
     * trabajo y un nombre de archivo; guarda en el archivo el resultado de
     * transformar la sucesion a un string aplicando el formato correspondiente
     * a los parametros brindados e imprime en pantalla la informacion de que el
     * archivo se guardo correctamente
     */
    public void printSucesionToFile(int[] sucesion, Orientation orientation,
            WorkingMode workingMode, String fileOutput) {
        String separator = getSeparator(orientation);
        String fileContent = generateSucesionString(sucesion, separator,
                workingMode);
        try (PrintWriter out = new PrintWriter(fileOutput)) {
            out.println(fileContent);
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al escribir el archivo");
            return;
        }
        String result = String.format("fibo<%d> guardado en %s",
                sucesion.length, fileOutput);
        System.out.println(result);
    }

    /*
     * Dado una orientacion, devuelve el separador correspondiente
     */
    private String getSeparator(Orientation orientation) {
        return orientation.equals(Orientation.VERTICAL) ? "\n" : " ";
    }

}
