package ar.edu.untref.dyasc;

public class Ejemplo {

    public static void main(String[] args) {
        // -Dbitacora.destino="test.txt, CONSOLA" para la salida
        String destino = System.getProperty("bitacora.destino");
        Bitacora bitacora = new Bitacora(destino);
        String descripcionEvento = "Iniciando ejecucion";
        bitacora.registrarEvento(descripcionEvento);
    }
}