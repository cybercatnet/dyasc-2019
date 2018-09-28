package ar.edu.untref.dyasc;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;

public class DestinosMapeador {

    private HashMap<String, String> mapa = new HashMap<String, String>();
    private String mapaDefault;

    public DestinosMapeador() {
        llenarMapa();
    }

    private void llenarMapa() {
        mapa.put("CONSOLA", "ar.edu.untref.dyasc.BitacoraDestinoConsola");
        mapaDefault = "ar.edu.untref.dyasc.BitacoraDestinoArchivo";
    }

    public ArrayList<BitacoraDestino> mapearDestinos(String argumentos) {
        ArrayList<BitacoraDestino> destinos = new ArrayList<BitacoraDestino>();
        String[] arrayArgumentos = separarArgumentos(argumentos);
        for (String argumento : arrayArgumentos) {
            if (mapa.containsKey(argumento)) {
                BitacoraDestino destino;
                try {
                    destino = (BitacoraDestino) Class.forName(
                            mapa.get(argumento)).newInstance();
                    destinos.add(destino);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                destinos.add(generateDefault(argumento));
            }
        }
        return destinos;
    }

    private BitacoraDestino generateDefault(String argumento) {
        Constructor constructor;
        BitacoraDestino destino = null;
        try {
            constructor = Class.forName(mapaDefault).getConstructor(
                    String.class);
            destino = (BitacoraDestino) constructor.newInstance(argumento);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return destino;
    }

    private String[] separarArgumentos(String argumentos) {
        String[] listaArgumentos = argumentos.split(",");
        for (int i = 0; i < listaArgumentos.length; i++) {
            // Quitamos los espacios
            listaArgumentos[i] = listaArgumentos[i].replaceAll("\\s+", "");
        }
        return listaArgumentos;
    }
}