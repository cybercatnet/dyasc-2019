package ar.edu.untref.dyasc;

public class Main {

    public static void main(String[] args) {
        // -DDESTINO_BITACORA=test.txt para el archivo de salida
        String destino = System.getProperty("DESTINO_BITACORA");
        Bitacora bitacora;
        if (destino == null || destino.equals("")) {
            bitacora = new Bitacora();
        } else {
            bitacora = new Bitacora(destino);
        }
        String descripcionEvento = "Iniciando ejecucion";
        bitacora.registrarEvento(descripcionEvento);
    }
}