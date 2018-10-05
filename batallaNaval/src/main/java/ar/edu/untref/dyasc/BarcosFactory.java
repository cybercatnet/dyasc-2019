package ar.edu.untref.dyasc;

import java.util.HashMap;

import ar.edu.untref.dyasc.Enums.*;

public class BarcosFactory {
    
    private HashMap<TiposBarco,String> mapa;
    
    public BarcosFactory(){
        mapa = HashMap<TiposBarco,String>();
        llenarMapa();
    }
    
    private void llenarMapa(){
        mapa.put(TiposBarco.BOTE, "ar.edu.untref.dyasc.Bote")
    }

}
