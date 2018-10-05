package ar.edu.untref.dyasc;

import org.junit.Assert;

import org.junit.Test;

import ar.edu.untref.dyasc.Enums.TableroElementos;

public class TestTablero {
    
    @Test
    public void InstanciamosUnTableroYCorroboramosQueSeInicialiceConAgua(){
        Tablero tablero = new Tablero();
        TableroElementos elementoDeseado = TableroElementos.AGUA; 
        TableroElementos elementoObtenido = tablero.getElemento(0, 0);
        Assert.assertEquals(elementoDeseado, elementoObtenido);        
    }
    
    @Test
    public void AgregamosElementoAlTableroYCorroboramosQueHallaSidoAgregado(){
        Tablero tablero = new Tablero();
        TableroElementos elemento = TableroElementos.BOTE;
        tablero.setElemento(elemento, 0, 0);
        TableroElementos elementoObtenido = tablero.getElemento(0, 0);
        Assert.assertEquals(elemento, elementoObtenido);        
    }

}
