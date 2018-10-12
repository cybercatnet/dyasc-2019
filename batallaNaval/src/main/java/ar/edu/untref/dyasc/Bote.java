package ar.edu.untref.dyasc;

public class Bote extends Barco {

    private final static int CANTIDAD_POSICIONES = 1;

    public Bote(int posX, int posY) {
        super(posX, posY, CANTIDAD_POSICIONES);
    }
}