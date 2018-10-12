package ar.edu.untref.dyasc;

import java.util.ArrayList;

import ar.edu.untref.dyasc.Enums.ResultadoDisparo;

public class Barco {

    private final int CANTIDAD_POSICIONES;
    protected ArrayList<Posicion> posiciones;

    public Barco(int posX, int posY, int cantidadPosiciones) {
        CANTIDAD_POSICIONES = cantidadPosiciones;
        posiciones = new ArrayList<Posicion>();
        inicializarPosiciones(posX, posY);
    }

    protected void inicializarPosiciones(int posInicialX, int posInicialY) {
        for (int i = 0; i < CANTIDAD_POSICIONES; i++) {
            posiciones.add(new Posicion(posInicialX, posInicialY + i));
        }
    }

    public ArrayList<Posicion> getPosiciones() {
        return posiciones;
    }

    public ResultadoDisparo disparar(int x, int y) {
        int cantidadPosicionesInicio = posiciones.size();
        ArrayList<Posicion> posicionesAEliminar = new ArrayList<Posicion>();
        for (Posicion posicion : posiciones) {
            if (posicion.x == x && posicion.y == y) {
                posicionesAEliminar.add(posicion);
            }
        }
        eliminarPosiciones(posicionesAEliminar);
        if (posiciones.size() == 0) {
            return ResultadoDisparo.HUNDIDO;
        } else if (posiciones.size() == cantidadPosicionesInicio) {
            return ResultadoDisparo.AGUA;
        } else {
            return ResultadoDisparo.TOCADO;
        }
    }

    private void eliminarPosiciones(ArrayList<Posicion> posicionesAEliminar) {
        for (Posicion posicion : posicionesAEliminar) {
            posiciones.remove(posicion);
        }
    }
}