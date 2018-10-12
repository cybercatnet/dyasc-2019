package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

public class TestCrucero {
    
    @Test
    public void CreamosUnCruceroYConsultamosLaLasCoordenadasDeLaSegundaPosicionQuePosee() {
        Crucero crucero = new Crucero(2,6);
        
        Posicion segundaPosicion = crucero.getPosiciones().get(0);
        
        Assert.assertEquals(2, segundaPosicion.x);
        Assert.assertEquals(7, segundaPosicion.y);
    }
}