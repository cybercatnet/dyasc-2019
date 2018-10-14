
package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

import Enums.Jugadores;

public class TestSet {

    @Test
    public void crearUnSetYVerificarPuntajeInicialJugadores() {
        Set set = new Set();

        int puntajeJ1 = set.getPuntaje(Jugadores.JUGADOR_1);
        int puntajeJ2 = set.getPuntaje(Jugadores.JUGADOR_2);

        Assert.assertEquals(0, puntajeJ1);
        Assert.assertEquals(0, puntajeJ2);
    }

    @Test
    public void sumar1PuntosAlJugador1() {
        Set set = new Set();

        set.agregarPunto(Jugadores.JUGADOR_1);
        int puntajeJ1 = set.getPuntaje(Jugadores.JUGADOR_1);
        int puntajeJ2 = set.getPuntaje(Jugadores.JUGADOR_2);

        Assert.assertEquals(0, puntajeJ1);
        Assert.assertEquals(0, puntajeJ2);
    }
}
