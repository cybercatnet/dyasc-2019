package ar.edu.untref.dyasc;

import java.util.ArrayList;

import Enums.Mes;

public class Libreria {

    private ArrayList<Producto> productos = new ArrayList<Producto>();
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public void addProducto(Producto producto) {
        this.productos.add(producto);
    }

    public void addCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public ArrayList<Producto> getProductos() {
        return this.productos;
    }

    public ArrayList<Cliente> getClientes() {
        return this.clientes;
    }

    public double getCobroMes(Cliente cliente, Mes mes) {
        return cliente.getCobroMes(mes);
    }

    public void venderProducto(Producto producto, Cliente cliente, Mes mes) {
        cliente.adquirirProducto(producto, mes);
    }

    public void venderSuscripcionAnual(RevistaPeriodico producto,
            Cliente cliente) {
        cliente.adquirirSuscripcionAnual(producto);
    }
}
