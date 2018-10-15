package ar.edu.untref.dyasc;

import java.util.Arrays;

import Enums.ValorPuntajeGame;

public class PuntajeGame implements Puntaje<ValorPuntajeGame> {

    protected ValorPuntajeGame[] escalaPuntos;
    protected int indicePuntajeActual;
    
    public PuntajeGame() {
        escalaPuntos = new ValorPuntajeGame[] { ValorPuntajeGame._0, ValorPuntajeGame._15,
                ValorPuntajeGame._30, ValorPuntajeGame._40, ValorPuntajeGame.VENTAJA,
                ValorPuntajeGame.GANO };
    }

    @Override
    public ValorPuntajeGame agregarPunto() {
        if (indicePuntajeActual >= escalaPuntos.length - 1) {
            throw new PuntajeException(
                    "No es posible agregar mas puntos que el maximo");
        }
        indicePuntajeActual++;
        return getPuntaje();
    }

    @Override
    public ValorPuntajeGame quitarPunto() {
        if (indicePuntajeActual <= 0) {
            throw new PuntajeException(
                    "No es posible quitar mas puntos que el minimo");
        }
        indicePuntajeActual--;
        return getPuntaje();
    }

    @Override
    public void setPuntaje(ValorPuntajeGame puntaje) {
        int indice = Arrays.asList(escalaPuntos).indexOf(puntaje);
        if (indice == -1) {
            throw new SetPuntajeException(
                    "El elemento no pudo ser asignado ya que este no se encuentra dentro de la lista de puntajes posibles");
        }
        indicePuntajeActual = indice;
    }

    @Override
    public ValorPuntajeGame getPuntaje() {
        return escalaPuntos[indicePuntajeActual];
    }

}
