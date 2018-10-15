package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

public class TestPuntajeTieBreak {

    @Test
    public void creamosUnPuntajeTieBreakYcorroboramosSuValorDeInicio() {
        PuntajeTieBreak puntaje = new PuntajeTieBreak();

        int valorPuntaje = puntaje.getPuntaje();

        Assert.assertEquals(0, valorPuntaje);
    }

    @Test
    public void creamosUnPuntajeTieBreakYAgregamosUnPunto() {
        PuntajeTieBreak puntaje = new PuntajeTieBreak();

        int valorPuntaje = puntaje.agregarPunto();

        Assert.assertEquals(1, valorPuntaje);
    }

    @Test(expected = PuntajeException.class)
    public void creamosUnPuntajeTieBreakYTratamosDeQuitarUnPunto() {
        PuntajeTieBreak puntaje = new PuntajeTieBreak();

        puntaje.quitarPunto();
    }

    @Test
    public void creamosUnPuntajeTieBreakYAgregamosDosPuntosYQuitamosUno() {
        PuntajeTieBreak puntaje = new PuntajeTieBreak();

        puntaje.agregarPunto();
        puntaje.agregarPunto();
        int valorPuntaje = puntaje.quitarPunto();

        Assert.assertEquals(1, valorPuntaje);
    }

    @Test(expected = SetPuntajeException.class)
    public void creamosUnPuntajeTieBreakYTratamosDeAsgnarUnPuntajeNegativo() {
        PuntajeTieBreak puntaje = new PuntajeTieBreak();

        puntaje.setPuntaje(-1);
    }

    @Test
    public void creamosUnPuntajeTieBreakAsignamosUnPuntajeYCorroboramosElValor() {
        PuntajeTieBreak puntaje = new PuntajeTieBreak();

        puntaje.setPuntaje(5);
        int valorPuntaje = puntaje.getPuntaje();

        Assert.assertEquals(5, valorPuntaje);
    }

}