
package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

import Enums.Jugadores;

public class TestGame {
    @Test
    public void crearUnGameYVerificarPuntajeInicialJugadores(){
        Game game = new Game();
        
        int puntajeJ1 = game.getPuntaje(Jugadores.JUGADOR_1);
        int puntajeJ2 = game.getPuntaje(Jugadores.JUGADOR_2);
        
        Assert.assertEquals(0, puntajeJ1);
        Assert.assertEquals(0, puntajeJ2);
    }
    
    @Test
    public void sumarPuntosAUnSoloJugador(){
        Game game = new Game();
    
        game.agregarPunto(Jugadores.JUGADOR_1);
        int puntajeJ1 = game.getPuntaje(Jugadores.JUGADOR_1);
        int puntajeJ2 = game.getPuntaje(Jugadores.JUGADOR_2);
        
        Assert.assertEquals(15, puntajeJ1);
        Assert.assertEquals(0, puntajeJ2);
    }
    
}
