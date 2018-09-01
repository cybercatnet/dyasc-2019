package ar.edu.untref.dyasc;

public class Producto {
    protected double precio;
    
    public Producto(double precio){
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
