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
        for (int i = 0; i < games.size() - 2; i++) {
            if (obtenerGanadorGame(games.get(i)) == jugador) {
                gamesJugador++;
            }
        }
        Game ultimoGame = games.get(games.size() - 1);
        if (ultimoGame.finalizo() && obtenerGanadorGame(ultimoGame) == jugador) {
            gamesJugador++;
        }
        return gamesJugador;
    }

    public void agregarPunto(Jugadores jugador) {
        games.get(games.size() - 1).agregarPunto(jugador);
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

}
