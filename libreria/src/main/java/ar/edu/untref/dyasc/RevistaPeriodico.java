package ar.edu.untref.dyasc;

public class RevistaPeriodico extends Producto {

    private int periodicidad;

    public RevistaPeriodico(double precio, int periodicidad) {
        super(precio);
        this.periodicidad = periodicidad;
    }

    public int getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(int periodicidad) {
        this.periodicidad = periodicidad;
    }
}