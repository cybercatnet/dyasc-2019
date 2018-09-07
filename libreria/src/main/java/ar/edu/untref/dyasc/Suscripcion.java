package ar.edu.untref.dyasc;

public class Suscripcion extends Operacion {

    public Suscripcion(RevistaPeriodico producto) {
        super(producto);
    }

    // Aplica un 20% de descuento en suscripciones anuales
    // El precio es el precio del producto por la periodicidad
    @Override
    public double getPrecio() {
        double precio = producto.getPrecio()
                * ((RevistaPeriodico) producto).getPeriodicidad();
        return precio - precio * 0.2;
    }
}