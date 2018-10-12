package ar.edu.untref.dyasc;

import java.util.ArrayList;

import ar.edu.untref.dyasc.Enums.ResultadoDisparo;
import ar.edu.untref.dyasc.Enums.TipoBarco;

public class BatallaNaval {

    private ArrayList<Barco> barcos;

    public BatallaNaval() {
        barcos = new ArrayList<Barco>();
    }

    public void agregarBarco(TipoBarco tipoBarco, int posX, int posY) {
        Barco barco = null;
        switch (tipoBarco) {
        case BOTE:
            barco = new Bote(posX, posY);
            break;
        case CRUCERO:
            barco = new Crucero(posX, posY);
            break;
        }
        barcos.add(barco);
    }

    public ResultadoDisparo disparar(int x, int y) {
        for (Barco barco : barcos) {
            ResultadoDisparo resultado = barco.disparar(x, y);
            if (!resultado.equals(ResultadoDisparo.AGUA)) {
                return resultado;
            }
        }
        return ResultadoDisparo.AGUA;
    }
}