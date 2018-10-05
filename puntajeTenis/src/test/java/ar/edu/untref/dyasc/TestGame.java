
package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

import Enums.Jugadores;
import Enums.Puntaje;

public class TestGame {
    @Test
    public void crearUnGameYVerificarPuntajeInicialJugadores(){
        Game game = new Game();
        
        Puntaje puntajeJ1 = game.getPuntaje(Jugadores.JUGADOR_1);
        Puntaje puntajeJ2 = game.getPuntaje(Jugadores.JUGADOR_2);
        
        Assert.assertEquals(Puntaje._0, puntajeJ1);
        Assert.assertEquals(Puntaje._0, puntajeJ2);
    }
    
    @Test
    public void sumarPuntosAUnSoloJugador(){
        Game game = new Game();
    
        game.agregarPunto(Jugadores.JUGADOR_1);
        Puntaje puntajeJ1 = game.getPuntaje(Jugadores.JUGADOR_1);
        Puntaje puntajeJ2 = game.getPuntaje(Jugadores.JUGADOR_2);
        
        Assert.assertEquals(Puntaje._15, puntajeJ1);
        Assert.assertEquals(Puntaje._0, puntajeJ2);
    }
    
    @Test
    public void sumar2PuntosAUnSoloJugador(){
        Game game = new Game();
    
        game.agregarPunto(Jugadores.JUGADOR_1);
        game.agregarPunto(Jugadores.JUGADOR_1);
        Puntaje puntajeJ1 = game.getPuntaje(Jugadores.JUGADOR_1);
        Puntaje puntajeJ2 = game.getPuntaje(Jugadores.JUGADOR_2);
        
        Assert.assertEquals(Puntaje._30, puntajeJ1);
        Assert.assertEquals(Puntaje._0, puntajeJ2);
    }
    
    @Test
    public void sumar3PuntosAUnSoloJugador(){
        Game game = new Game();
    
        game.agregarPunto(Jugadores.JUGADOR_1);
        game.agregarPunto(Jugadores.JUGADOR_1);
        game.agregarPunto(Jugadores.JUGADOR_1);
        
        Puntaje puntajeJ1 = game.getPuntaje(Jugadores.JUGADOR_1);
        Puntaje puntajeJ2 = game.getPuntaje(Jugadores.JUGADOR_2);
        
        Assert.assertEquals(Puntaje._40, puntajeJ1);
        Assert.assertEquals(Puntaje._0, puntajeJ2);
    }
    
    @Test
    public void sumar4PuntosAUnSoloJugadorParaQueUnGame(){
        Game game = new Game();
    
        game.agregarPunto(Jugadores.JUGADOR_1);
        game.agregarPunto(Jugadores.JUGADOR_1);
        game.agregarPunto(Jugadores.JUGADOR_1);
        game.agregarPunto(Jugadores.JUGADOR_1);
        
        Puntaje puntajeJ1 = game.getPuntaje(Jugadores.JUGADOR_1);
        Puntaje puntajeJ2 = game.getPuntaje(Jugadores.JUGADOR_2);
        
        Assert.assertEquals(Puntaje.GANO, puntajeJ1);
        Assert.assertEquals(Puntaje._0, puntajeJ2);
    }
    
    
    
}
