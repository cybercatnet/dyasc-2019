package ar.edu.untref.dyasc;

public class BitacoraDestinoConsola extends BitacoraDestino {

    @Override
    public void enviarADestino(String registro) {
        System.out.println(registro);
    }

}
