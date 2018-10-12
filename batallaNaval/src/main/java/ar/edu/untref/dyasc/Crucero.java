package ar.edu.untref.dyasc;

public class Crucero extends Barco {

    private final static int CANTIDAD_POSICIONES = 3;

    public Crucero(int posX, int posY) {
        super(posX, posY, CANTIDAD_POSICIONES);
    }
}