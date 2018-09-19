package ar.edu.untref.dyasc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BitacoraDestinoArchivo extends BitacoraDestino {

    private String nombreArchivoRegistro = "";

    public BitacoraDestinoArchivo(String nombreArchivo) {
        this.nombreArchivoRegistro = nombreArchivo;
    }

    @Override
    public void enviarADestino(String registro) {
        guardarRegistro(registro);
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
            String errorStr = String.format("Error al escribir el archivo: %s",
                    nombreArchivoRegistro);
            System.out.println(errorStr);
        }
    }
}