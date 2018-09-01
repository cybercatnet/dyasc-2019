package ar.edu.untref.dyasc;

import java.util.ArrayList;
import java.util.Hashtable;

import Enums.Mes;

public class CuentaCorriente {
    private Hashtable<Mes, ArrayList<Operacion>> operaciones = new Hashtable<Mes, ArrayList<Operacion>>();

    public void addOperacion(Operacion operacion, Mes mes) {
        if (!this.operaciones.containsKey(mes)) {
            this.operaciones.put(mes, new ArrayList<Operacion>());
        }
        this.operaciones.get(mes).add(operacion);
    }
    
    public void addSuscripcionAnual(Operacion operacion) {
        for (Mes mes : Mes.values()) {
            addOperacion(operacion, mes);
        }
    }
    
    private ArrayList<Operacion> getOperacionesMes(Mes mes){
        if(!this.operaciones.containsKey(mes)){
            return new ArrayList<Operacion>();
        }
        return this.operaciones.get(mes);
    }
    
    public double getCobroMes(Mes mes){
        double result = 0;
        ArrayList<Operacion> operacionesMes = getOperacionesMes(mes);
        for(int i =0;i<operacionesMes.size();i++){
            result += operacionesMes.get(i).getPrecio();
        }
        return result;
    }
}
