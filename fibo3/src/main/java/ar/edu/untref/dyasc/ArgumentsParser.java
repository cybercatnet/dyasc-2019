package ar.edu.untref.dyasc;

import ar.edu.untref.dyasc.Enums.Direction;
import ar.edu.untref.dyasc.Enums.Orientation;
import ar.edu.untref.dyasc.Enums.WorkingMode;
import ParseResults.ArgumentsParseResult;
import ParseResults.OptionsParseResult;
import ParseResults.WorkingModeParseResult;

public class ArgumentsParser {

    private String[] arguments;

    public ArgumentsParser(String[] arguments) {
        this.arguments = arguments;
    }

    /*
     * Dado el nombre de un argumento, devuelve el valor que posee ese argumento
     * si es que se encuentra en el array de argumentos dentro del atributo
     * 'arguments'. Si no se encuentra el argumento devuelve null
     */
    private String getArgumentValue(String argumentName) {
        String argumentFormat = String.format("-%s=", argumentName);
        for (int i = 0; i < this.arguments.length; i++) {
            if (this.arguments[i].length() > argumentFormat.length()
                    && this.arguments[i].substring(0, 3).equals(argumentFormat)) {
                return this.arguments[i].substring(3);
            }
        }
        return null;
    }

    /*
     * Devuelve del array de argumentos el primer argumento que encuentre de
     * tipo entero
     */
    private int getNumberArgument() {
        int result = -1;
        for (int i = 0; i < this.arguments.length; i++) {
            try {
                result = Integer.parseInt(this.arguments[i]);
                break;
            } catch (Exception e) {
                continue;
            }
        }
        return result;
    }

    /*
     * Devuelve el resultado de parsear el argumento opciones
     */
    private OptionsParseResult parseOptions() throws Exception {
        OptionsParseResult result = new OptionsParseResult();
        String exceptionMessage = "El argumento opcion no es valido";
        String value = getArgumentValue("o");
        if (value == null) {
            return null;
        }
        if (value.length() != 2) {
            throw new Exception(exceptionMessage);
        }
        String orientationValue = value.substring(0, 1);
        String directionValue = value.substring(1, 2);
        // Checkeamos la orientacion
        switch (orientationValue) {
        case "v":
            result.orientation = Orientation.VERTICAL;
            break;
        case "h":
            result.orientation = Orientation.HORIZONTAL;
            break;
        default:
            throw new Exception(exceptionMessage);
        }
        // Checkeamos la direccion
        switch (directionValue) {
        case "d":
            result.direction = Direction.DIRECT;
            break;
        case "i":
            result.direction = Direction.INVERSE;
            break;
        default:
            throw new Exception(exceptionMessage);
        }
        return result;
    }

    /*
     * Devuelve el resultado de parsear el argumento modo de trabajo
     */
    private WorkingModeParseResult parseWorkingMode() throws Exception {
        WorkingModeParseResult result = new WorkingModeParseResult();
        String exceptionMessage = "El argumento modo de funcionamiento no es valido";
        String value = getArgumentValue("m");
        if (value == null) {
            result.mode = WorkingMode.LIST;
            return result;
        }
        switch (value) {
        case "l":
            result.mode = WorkingMode.LIST;
            break;
        case "s":
            result.mode = WorkingMode.SUM;
            break;
        default:
            throw new Exception(exceptionMessage);
        }
        return result;
    }

    /*
     * Devuelve el resultado de parsear todos los argumentos en un objeto de
     * tipo ArgumentsParseResult
     */
    public ArgumentsParseResult parseArguments() throws Exception {
        ArgumentsParseResult parseResult = new ArgumentsParseResult();
        parseResult.options = parseOptions();
        parseResult.workingMode = parseWorkingMode();
        parseResult.fileOutput = getArgumentValue("f");
        parseResult.number = getNumberArgument();
        return parseResult;
    }
}
