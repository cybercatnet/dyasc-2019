package ar.edu.untref.dyasc;

import Enums.Mes;

public class Main {

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
        //Registramos algunos clientes
        cliente2.registrar("Nombre1", "Apellido1", "Dir1 1234");
        cliente3.registrar("Nombre2", "Apellido2", "Dir2 1234");
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
        // Imprimimos cuanto le cobramos al cliente1 en Marzo
        System.out.printf("Cobro de Marzo para el cliente1: %f\n",
                libreria.getCobroMes(cliente1, Mes.MARZO));
        // Hacemos que el cliente2 compre un artibulo de libreria y se suscriba a un periodico
        libreria.venderProducto(libro, cliente2, Mes.AGOSTO);
        libreria.venderSuscripcionAnual(periodico, cliente2);
        // Imprimimos cuanto le cobramos al cliente1 en Marzo
        System.out.printf("Cobro de Agosto para el cliente2: %f\n",
                libreria.getCobroMes(cliente2, Mes.AGOSTO));
        // Hacemos que el cliente3 compre un articulo de libreria y un periodico
        libreria.venderProducto(artLibreria, cliente3, Mes.ENERO);
        libreria.venderProducto(periodico, cliente3, Mes.ENERO);
        // Imprimimos cuanto le cobramos al cliente1 en Enero
        System.out.printf("Cobro de Enero para el cliente3: %f\n",
                libreria.getCobroMes(cliente3, Mes.ENERO));
    }

}
