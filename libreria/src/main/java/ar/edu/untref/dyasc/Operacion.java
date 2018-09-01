package ar.edu.untref.dyasc;

import Enums.TipoOperacion;

public class Operacion {
    
    protected Producto producto;
    
    public Operacion(Producto producto){
        this.producto = producto;
    }

    public double getPrecio(){
        return producto.getPrecio();
    }
    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }   
}
