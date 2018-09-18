package ar.edu.untref.dyasc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class Bitacora {

    private String nombreArchivoRegistro = "";

    public Bitacora() {
    }

    public Bitacora(String destino) {
        this.nombreArchivoRegistro = destino;
    }

    public void registrarEvento(String descripcion) {
        String registro = generarRegistro(descripcion);
        if (nombreArchivoRegistro.equals("")) {
            imprimirRegistro(registro);
        } else {
            guardarRegistro(registro);
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

    private void imprimirRegistro(String registro) {
        System.out.println(registro);
    }

    private void guardarRegistro(String registro) {
        File archivo = new File(nombreArchivoRegistro);
        String registroFinal;
        try {
            if (!archivo.exists()) {
                archivo.createNewFile();
                registroFinal = registro;
            } else {
                registroFinal = "\n" + registro;
            }
            Files.write(Paths.get(nombreArchivoRegistro),
                    registroFinal.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            String errorStr = String.format("Error al escribir el archivo: %s", nombreArchivoRegistro);
            System.out.println(errorStr);
        }
    }
}