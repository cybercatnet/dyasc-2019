package ar.edu.untref.dyasc;

import Enums.Jugadores;
import Enums.Puntaje;

public class Game {

    private Puntaje[] puntuacion = { Puntaje._0, Puntaje._15, Puntaje._30,
            Puntaje._40, Puntaje.VENTAJA, Puntaje.GANO };
    private int puntosJugador1;
    private int puntosJugador2;

    public Game() {
        puntosJugador1 = 0;
        puntosJugador2 = 0;
    }

    public Puntaje getPuntaje(Jugadores jugador) {
        switch (jugador) {
        case JUGADOR_1:
            return puntuacion[puntosJugador1];
        case JUGADOR_2:
            return puntuacion[puntosJugador2];
        default:
            return Puntaje._0;
        }
    }

    public void agregarPunto(Jugadores jugador) {        
        switch (jugador) {
        case JUGADOR_1:
            if(puntuacion[puntosJugador2] == Puntaje.VENTAJA){
                puntosJugador2--;
                return;
            }
            puntosJugador1 = calcularProximoPuntaje(puntosJugador1,
                    puntosJugador2);
            break;
        case JUGADOR_2:
            if(puntuacion[puntosJugador1] == Puntaje.VENTAJA){
                puntosJugador1--;
                return;
            }
            puntosJugador2 = calcularProximoPuntaje(puntosJugador2,
                    puntosJugador1);
            break;
        }
    }

    private boolean isDeuce() {
        return puntosJugador1 == puntosJugador2
                && puntuacion[puntosJugador1] == Puntaje._40;
    }

    public int calcularProximoPuntaje(int sumador, int otro) {
        if (puntuacion[sumador] == Puntaje._40) {
            if (puntuacion[otro] == Puntaje._40) {
                return sumador + 1;
            } else {
                return sumador + 2;
            }
        }
        return sumador + 1;
    }

    public boolean finalizo() {
        return true;
    }

}
