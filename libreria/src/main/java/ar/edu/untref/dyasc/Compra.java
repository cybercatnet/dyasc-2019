package ar.edu.untref.dyasc;

import Enums.TipoOperacion;

public class Compra extends Operacion {
    
    private boolean clienteRegistrado;
    
    public Compra(Producto producto, boolean clienteRegistrado) {
        super(producto);
        this.clienteRegistrado = clienteRegistrado;
    }
    
    //Si el cliente esta registrado, se le aplica un 5% de descuento
    @Override
    public double getPrecio(){
        if(clienteRegistrado){
            return producto.getPrecio() - producto.getPrecio()*0.05;
        }
        return producto.getPrecio();
    }
}
