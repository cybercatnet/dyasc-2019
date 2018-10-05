package ar.edu.untref.dyasc;

import Enums.Jugadores;

public class Game {
    
    private int[] puntuacion = {0,15,30,40};
    private int puntosJugador1;
    private int puntosJugador2;
    
    public Game(){
        puntosJugador1 = 0;
        puntosJugador2 = 0;
    }
    
    public int getPuntaje(Jugadores jugador) {
        switch (jugador) {
        case JUGADOR_1:
            return puntuacion[puntosJugador1];
        case JUGADOR_2:
            return puntuacion[puntosJugador2];
        default:
            return 0;
        }
    }

    public void agregarPunto(Jugadores jugador) {
        switch (jugador) {
        case JUGADOR_1:
            puntosJugador1++;
            break;
        case JUGADOR_2:
            puntosJugador2++;
            break;
        }
    }
}
