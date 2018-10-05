
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
    public void sumar1PuntosAlJugador1(){
        Game game = new Game();
    
        game.agregarPunto(Jugadores.JUGADOR_1);
        Puntaje puntajeJ1 = game.getPuntaje(Jugadores.JUGADOR_1);
        Puntaje puntajeJ2 = game.getPuntaje(Jugadores.JUGADOR_2);
        
        Assert.assertEquals(Puntaje._15, puntajeJ1);
        Assert.assertEquals(Puntaje._0, puntajeJ2);
    }
    
    @Test
    public void sumar1PuntosAlJugador2(){
        Game game = new Game();
    
        game.agregarPunto(Jugadores.JUGADOR_2);
        Puntaje puntajeJ1 = game.getPuntaje(Jugadores.JUGADOR_1);
        Puntaje puntajeJ2 = game.getPuntaje(Jugadores.JUGADOR_2);
        
        Assert.assertEquals(Puntaje._0, puntajeJ1);
        Assert.assertEquals(Puntaje._15, puntajeJ2);
    }
    
    @Test
    public void sumar2PuntosAlJugador1(){
        Game game = new Game();
    
        game.agregarPunto(Jugadores.JUGADOR_1);
        game.agregarPunto(Jugadores.JUGADOR_1);
        Puntaje puntajeJ1 = game.getPuntaje(Jugadores.JUGADOR_1);
        Puntaje puntajeJ2 = game.getPuntaje(Jugadores.JUGADOR_2);
        
        Assert.assertEquals(Puntaje._30, puntajeJ1);
        Assert.assertEquals(Puntaje._0, puntajeJ2);
    }
    
    @Test
    public void sumar2PuntosAlJugador2(){
        Game game = new Game();
    
        game.agregarPunto(Jugadores.JUGADOR_2);
        game.agregarPunto(Jugadores.JUGADOR_2);
        Puntaje puntajeJ1 = game.getPuntaje(Jugadores.JUGADOR_1);
        Puntaje puntajeJ2 = game.getPuntaje(Jugadores.JUGADOR_2);
        
        Assert.assertEquals(Puntaje._30, puntajeJ2);
        Assert.assertEquals(Puntaje._0, puntajeJ1);
    }
    
    @Test
    public void sumar3PuntosAlJugador1(){
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
    public void sumar3PuntosAlJugador2(){
        Game game = new Game();
    
        game.agregarPunto(Jugadores.JUGADOR_2);
        game.agregarPunto(Jugadores.JUGADOR_2);
        game.agregarPunto(Jugadores.JUGADOR_2);
        
        Puntaje puntajeJ1 = game.getPuntaje(Jugadores.JUGADOR_1);
        Puntaje puntajeJ2 = game.getPuntaje(Jugadores.JUGADOR_2);
        
        Assert.assertEquals(Puntaje._40, puntajeJ2);
        Assert.assertEquals(Puntaje._0, puntajeJ1);
    }
    
    @Test
    public void sumar4PuntosAlJugador1ParaQueGane(){
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
    
    @Test
    public void sumar4PuntosAlJugador2ParaQueGane(){
        Game game = new Game();
    
        game.agregarPunto(Jugadores.JUGADOR_2);
        game.agregarPunto(Jugadores.JUGADOR_2);
        game.agregarPunto(Jugadores.JUGADOR_2);
        game.agregarPunto(Jugadores.JUGADOR_2);
        
        Puntaje puntajeJ1 = game.getPuntaje(Jugadores.JUGADOR_1);
        Puntaje puntajeJ2 = game.getPuntaje(Jugadores.JUGADOR_2);
        
        Assert.assertEquals(Puntaje.GANO, puntajeJ2);
        Assert.assertEquals(Puntaje._0, puntajeJ1);
    }
    
    @Test
    public void enDeuce(){

        Game game = new Game();

        game.agregarPunto(Jugadores.JUGADOR_1);
        game.agregarPunto(Jugadores.JUGADOR_1);
        game.agregarPunto(Jugadores.JUGADOR_1);
        game.agregarPunto(Jugadores.JUGADOR_2);
        game.agregarPunto(Jugadores.JUGADOR_2);
        game.agregarPunto(Jugadores.JUGADOR_2);
        
        Puntaje puntajeJ1 = game.getPuntaje(Jugadores.JUGADOR_1);
        Puntaje puntajeJ2 = game.getPuntaje(Jugadores.JUGADOR_2);
        
        Assert.assertEquals(Puntaje._40, puntajeJ2);
        Assert.assertEquals(Puntaje._40, puntajeJ1);
    }
    
    @Test
    public void jugador2enVentaja(){

        Game game = new Game();

        game.agregarPunto(Jugadores.JUGADOR_1);
        game.agregarPunto(Jugadores.JUGADOR_1);
        game.agregarPunto(Jugadores.JUGADOR_1);
        game.agregarPunto(Jugadores.JUGADOR_2);
        game.agregarPunto(Jugadores.JUGADOR_2);
        game.agregarPunto(Jugadores.JUGADOR_2);
        game.agregarPunto(Jugadores.JUGADOR_2);
        
        Puntaje puntajeJ1 = game.getPuntaje(Jugadores.JUGADOR_1);
        Puntaje puntajeJ2 = game.getPuntaje(Jugadores.JUGADOR_2);
        
        Assert.assertEquals(Puntaje._40, puntajeJ1);
        Assert.assertEquals(Puntaje.VENTAJA, puntajeJ2);
    }
    
    @Test
    public void jugador2GanaEnVentaja(){

        Game game = new Game();

        game.agregarPunto(Jugadores.JUGADOR_1);
        game.agregarPunto(Jugadores.JUGADOR_1);
        game.agregarPunto(Jugadores.JUGADOR_1);
        game.agregarPunto(Jugadores.JUGADOR_2);
        game.agregarPunto(Jugadores.JUGADOR_2);
        game.agregarPunto(Jugadores.JUGADOR_2);
        game.agregarPunto(Jugadores.JUGADOR_2);
        game.agregarPunto(Jugadores.JUGADOR_2);
        
        Puntaje puntajeJ1 = game.getPuntaje(Jugadores.JUGADOR_1);
        Puntaje puntajeJ2 = game.getPuntaje(Jugadores.JUGADOR_2);
        
        Assert.assertEquals(Puntaje._40, puntajeJ1);
        Assert.assertEquals(Puntaje.GANO, puntajeJ2);
    }
    
    @Test
    public void jugador1HaceUnPuntoConJugador2EnVentaja(){

        Game game = new Game();

        game.agregarPunto(Jugadores.JUGADOR_1);
        game.agregarPunto(Jugadores.JUGADOR_1);
        game.agregarPunto(Jugadores.JUGADOR_1);
        game.agregarPunto(Jugadores.JUGADOR_2);
        game.agregarPunto(Jugadores.JUGADOR_2);
        game.agregarPunto(Jugadores.JUGADOR_2);
        game.agregarPunto(Jugadores.JUGADOR_2);
        game.agregarPunto(Jugadores.JUGADOR_1);
        
        Puntaje puntajeJ1 = game.getPuntaje(Jugadores.JUGADOR_1);
        Puntaje puntajeJ2 = game.getPuntaje(Jugadores.JUGADOR_2);
        
        Assert.assertEquals(Puntaje._40, puntajeJ1);
        Assert.assertEquals(Puntaje._40, puntajeJ2);
    }
    
    
}
