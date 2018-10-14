package ar.edu.untref.dyasc;

import java.util.ArrayList;
import java.util.List;

import Enums.Jugadores;
import Enums.Puntaje;

public class Set {

    private List<Game> games;

    public Set() {
        this.games = new ArrayList<Game>();
        games.add(new Game());
    }

    public int getPuntaje(Jugadores jugador) {
        int gamesJugador = 0;
        for (int i = 0; i < games.size(); i++) {
            if (obtenerGanadorGame(games.get(i)) == jugador) {
                gamesJugador++;
            }
        }
        return gamesJugador;
    }

    public void agregarPunto(Jugadores jugador) {
        Game ultimoGame = games.get(games.size() - 1);
        ultimoGame.agregarPunto(jugador);
        if (ultimoGame.finalizo()) {
            games.add(new Game());
        }
    }

    private Jugadores obtenerGanadorGame(Game game) {
        Jugadores ganador = null;
        if (game.finalizo()) {
            if (game.getPuntaje(Jugadores.JUGADOR_1) == Puntaje.GANO) {
                ganador = Jugadores.JUGADOR_1;
            } else {
                ganador = Jugadores.JUGADOR_2;
            }
        }
        return ganador;
    }

    public Jugadores getGanador() {
        Jugadores ganador = null;
        int puntajeJugador1 = getPuntaje(Jugadores.JUGADOR_1);
        int puntajeJugador2 = getPuntaje(Jugadores.JUGADOR_2);
        if ((puntajeJugador1 == 6 && puntajeJugador2 < 5) || puntajeJugador1 == 7) {
            ganador = Jugadores.JUGADOR_1;
        } else if ((puntajeJugador2 == 6 && puntajeJugador1 < 5) || puntajeJugador2 == 7) {
            ganador = Jugadores.JUGADOR_2;
        }
        return ganador;
    }

}
