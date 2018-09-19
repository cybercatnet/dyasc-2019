package ar.edu.untref.dyasc;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Bitacora {

    private ArrayList<BitacoraDestino> destinos = new ArrayList<BitacoraDestino>();
    private DestinosMapeador mapeador = new DestinosMapeador();

    public Bitacora(String argumentos) {
        destinos = mapeador.mapearDestinos(argumentos);
    }

    public void registrarEvento(String descripcion) {
        String registro = generarRegistro(descripcion);
        enviarADestinos(registro);
    }

    private void enviarADestinos(String registro) {
        for (BitacoraDestino bitacoraDestino : destinos) {
            bitacoraDestino.enviarADestino(registro);
        }
    }

    private String generarRegistro(String descripcion) {
        LocalDateTime now = LocalDateTime.now();
        int dia = now.getDayOfMonth();
        int mes = now.getMonth().getValue();
        int anio = now.getYear();
        int hora = now.getHour();
        int minuto = now.getMinute();
        String registroTiempo = String.format("%d/%d/%d %d:%d ", dia, mes,
                anio, hora, minuto);
        return registroTiempo + descripcion;
    }
}