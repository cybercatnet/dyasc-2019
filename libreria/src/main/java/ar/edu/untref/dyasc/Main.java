package ar.edu.untref.dyasc;

import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

import Enums.Mes;

public class Main {

    public static void printClientesHashtable(Hashtable<Cliente, Double> dict) {
        List<Cliente> keys = Collections.list(dict.keys());
        for (Cliente cliente : keys) {
            String line = String.format("%s %s: $%f", cliente.getNombre(),
                    cliente.getApellido(), dict.get(cliente));
            System.out.println(line);
        }
    }

    public static void main(String args[]) {
        final double IVA = 0.21;
        // Creamos la Libreria
        Libreria libreria = new Libreria();
        // Creamos Cuentas Corrientes
        CuentaCorriente ccCliente1 = new CuentaCorriente();
        CuentaCorriente ccCliente2 = new CuentaCorriente();
        CuentaCorriente ccCliente3 = new CuentaCorriente();
        // Creamos Clientes
        Cliente cliente1 = new Cliente(ccCliente1);
        Cliente cliente2 = new Cliente(ccCliente2);
        Cliente cliente3 = new Cliente(ccCliente3);
        // Registramos algunos clientes
        cliente1.registrar("Nombre1", "Apellido1", "Dir1 1234");
        cliente2.registrar("Nombre2", "Apellido2", "Dir2 5121");
        cliente3.registrar("Nombre3", "Apellido3", "Dir3 5412");
        // Agregamos los clientes a la libreria
        libreria.addCliente(cliente1);
        libreria.addCliente(cliente2);
        libreria.addCliente(cliente3);
        // Creamos Productos
        Libro libro = new Libro(255);
        ArticuloLibreria artLibreria = new ArticuloLibreria(75, IVA);
        RevistaPeriodico revista = new RevistaPeriodico(120, 4);
        RevistaPeriodico periodico = new RevistaPeriodico(85, 8);
        // Agregamos los productos a la libreria
        libreria.addProducto(libro);
        libreria.addProducto(artLibreria);
        libreria.addProducto(revista);
        libreria.addProducto(periodico);
        // Hacemos que el cliente1 compre un libro y se suscriba a una revista
        libreria.venderProducto(libro, cliente1, Mes.MARZO);
        libreria.venderSuscripcionAnual(revista, cliente1);
        // Hacemos que el cliente2 compre un artibulo de libreria y se suscriba
        // a un periodico
        libreria.venderProducto(libro, cliente2, Mes.MARZO);
        libreria.venderSuscripcionAnual(periodico, cliente2);
        // Hacemos que el cliente3 compre un articulo de libreria y un periodico
        libreria.venderProducto(artLibreria, cliente3, Mes.MARZO);
        libreria.venderProducto(periodico, cliente3, Mes.MARZO);
        // Imprimimos cuanto le cobramos a los clientes en Marzo
        System.out.println("Cobro de Marzo para los clientes:");
        Main.printClientesHashtable(libreria.getCobrosMes(Mes.MARZO));
    }
}