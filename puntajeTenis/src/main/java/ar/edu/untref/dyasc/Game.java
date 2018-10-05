package ar.edu.untref.dyasc;

public class Game {

    private int puntosJugadorUno;
    private int puntosJugadorDos;
    
    public Game(){
        puntosJugadorUno = 0;
        puntosJugadorDos = 0;
    }
    
    public int getPuntajeJ1() {
        return puntosJugadorUno;
    }
    
    public int getPuntajeJ2() {
        return puntosJugadorDos;
    }

    public void puntoParaJugador1() {
        puntosJugadorUno += 15;
    }
}
