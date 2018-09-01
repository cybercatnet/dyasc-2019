package ar.edu.untref.dyasc;

import Enums.Mes;

public class Cliente {

    private String nombre;
    private String apellido;
    private String direccion;
    private CuentaCorriente cuentaCorriente;
    private boolean registrado;

    public Cliente(CuentaCorriente cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }
    
    public void registrar(String nombre, String apellido, String direccion){
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        registrado = true;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public CuentaCorriente getCuentaCorriente() {
        return cuentaCorriente;
    }

    public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }

    public boolean isRegistrado() {
        return registrado;
    }

    public void setRegistrado(boolean registrado) {
        this.registrado = registrado;
    }
    
    public double getCobroMes(Mes mes){
        return cuentaCorriente.getCobroMes(mes);
    }
    
    public void adquirirProducto(Producto producto, Mes mes){
        Compra compra = new Compra(producto, registrado);
        cuentaCorriente.addOperacion(compra, mes);
    }
    
    public void adquirirSuscripcionAnual(RevistaPeriodico producto){
        Suscripcion suscripcion = new Suscripcion(producto);
        cuentaCorriente.addSuscripcionAnual(suscripcion);
    }

}
