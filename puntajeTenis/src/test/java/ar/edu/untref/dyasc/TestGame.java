
package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

public class TestGame {
    @Test
    public void crearUnGameYVerificarPuntajeInicialJugadores(){
        Game game = new Game();
        
        int puntajeJ1 = game.getPuntajeJ1();
        int puntajeJ2 = game.getPuntajeJ2();
        
        Assert.assertEquals(0, puntajeJ1);
        Assert.assertEquals(0, puntajeJ2);
    }
    
    @Test
    public void sumarPuntosAUnSoloJugador(){
        Game game = new Game();
    
        game.puntoParaJugador1();
        int puntajeJ1 = game.getPuntajeJ1();
        int puntajeJ2 = game.getPuntajeJ2();
        
        Assert.assertEquals(15, puntajeJ1);
        Assert.assertEquals(0, puntajeJ2);
    }
    
}
