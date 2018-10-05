package ar.edu.untref.dyasc;

import Enums.Jugadores;

public class Game {

    private int puntosJugador1;
    private int puntosJugador2;
    
    public Game(){
        puntosJugador1 = 0;
        puntosJugador2 = 0;
    }
    
    public int getPuntaje(Jugadores jugador) {
        switch (jugador) {
        case JUGADOR_1:
            return puntosJugador1;
        case JUGADOR_2:
            return puntosJugador2;
        default:
            return 0;
        }
    }

    public void agregarPunto(Jugadores jugador) {
        switch (jugador) {
        case JUGADOR_1:
            puntosJugador1 += 15;
            break;
        case JUGADOR_2:
            puntosJugador2 += 15;
            break;
        }
    }
}
