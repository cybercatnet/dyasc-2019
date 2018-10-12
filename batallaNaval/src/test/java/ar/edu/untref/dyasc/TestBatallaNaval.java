package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.dyasc.Enums.ResultadoDisparo;
import ar.edu.untref.dyasc.Enums.TipoBarco;

public class TestBatallaNaval {
    
    @Test
    public void InstanciamosUnaBatallaNavalYDisparamosSinCrearBarcos() {
        BatallaNaval batallaNaval = new BatallaNaval();
        
        ResultadoDisparo resultado = batallaNaval.disparar(1,1);
        
        Assert.assertEquals(ResultadoDisparo.AGUA, resultado);
    }
    
    @Test
    public void InstanciamosUnaBatallaNavalConUnCruceroYDisparamosAUnaDeSusPosicionesParaTocarlo() {
        BatallaNaval batallaNaval = new BatallaNaval();
        batallaNaval.agregarBarco(TipoBarco.CRUCERO, 1, 1);
        
        ResultadoDisparo resultado = batallaNaval.disparar(1,1);
        
        Assert.assertEquals(ResultadoDisparo.TOCADO, resultado);
    }
    
    @Test
    public void InstanciamosUnaBatallaNavalConUnBoteYDisparamosASuUnicaPosicionParaHundirlo() {
        BatallaNaval batallaNaval = new BatallaNaval();
        batallaNaval.agregarBarco(TipoBarco.BOTE, 1, 1);
        
        ResultadoDisparo resultado = batallaNaval.disparar(1,1);
        
        Assert.assertEquals(ResultadoDisparo.HUNDIDO, resultado);
    }
    
    @Test
    public void InstanciamosUnaBatallaNavalConUnCruceroYDisparamosATodasSusPosicionesParaHundirlo() {
        BatallaNaval batallaNaval = new BatallaNaval();
        batallaNaval.agregarBarco(TipoBarco.CRUCERO, 1, 1);
        
        ResultadoDisparo resultado1 = batallaNaval.disparar(1,1);
        ResultadoDisparo resultado2 = batallaNaval.disparar(1,2);
        ResultadoDisparo resultado3 = batallaNaval.disparar(1,3);
        
        Assert.assertEquals(ResultadoDisparo.TOCADO, resultado1);
        Assert.assertEquals(ResultadoDisparo.TOCADO, resultado2);
        Assert.assertEquals(ResultadoDisparo.HUNDIDO, resultado3);
    }
    
    @Test
    public void InstanciamosUnaBatallaNavalConUnCruceroYDisparamosAUnLugarDistintoDeSuPosicion() {
        BatallaNaval batallaNaval = new BatallaNaval();
        batallaNaval.agregarBarco(TipoBarco.CRUCERO, 1, 1);
        
        ResultadoDisparo resultado = batallaNaval.disparar(10,21);
        
        Assert.assertEquals(ResultadoDisparo.AGUA, resultado);
    }    
}