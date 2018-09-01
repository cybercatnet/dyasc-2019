package ar.edu.untref.dyasc;

public class ArticuloLibreria extends Producto {

    private double IVA;

    public ArticuloLibreria(double precio, double IVA) {
        super(precio);
        this.setIVA(IVA);
    }

    public double getIVA() {
        return IVA;
    }

    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

    //Devuelve el precio con el IVA aplicado
    @Override
    public double getPrecio() {
        return precio + precio * IVA;
    }
}
