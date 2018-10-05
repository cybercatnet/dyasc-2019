package ar.edu.untref.dyasc;

import java.lang.reflect.Array;

import ar.edu.untref.dyasc.Enums.TableroElementos;
import ar.edu.untref.dyasc.Enums.TableroOrientacion;

public class Tablero {
    
    private ArrayList<Barco> barcos; 
    
    
    public Tablero(){
        barcos = new ArrayList<Barco>();
    }
    
    public void agregarBarco(Barco barco, int posX, int posY, TableroOrientacion orientacion){
        mapa[posY][posX] = elemento;
    }
    
    public TableroElementos getElemento(int posX, int posY){
        return mapa[posY][posX];
    }
}
