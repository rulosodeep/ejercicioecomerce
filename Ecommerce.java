package ejemplos;

import java.util.ArrayList;

public class Ecommerce {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Juan Pérez", "Calle Falsa 123"));
        clientes.add(new Cliente("Raúl Meraz", "Calle Santa Fe"));
        clientes.add(new Cliente("Kevin Valencia", "Calle Limones 234"));
        clientes.add(new Cliente("Diego Rosales", "Rio Dorado"));

        ArrayList<Pedidos> pedidos = new ArrayList<>();
        pedidos.add(new Pedidos(1, "Laptop, Mouse", "Juan Pérez"));
        pedidos.add(new Pedidos(2, "Computadora, Teclado", "Raúl Meraz"));
        pedidos.add(new Pedidos(3, "Audifonos, Monitor para PC", "Kevin Valencia"));
        pedidos.add(new Pedidos(4, "Bocinas, Mouse", "Diego Rosales"));

        ArrayList<Pagos> pagos = new ArrayList<>();
        pagos.add(new Pagos(1, "Tarjeta de crédito", 1500.50));
        pagos.add(new Pagos(2, "Efectivo", 10500));
        pagos.add(new Pagos(3, "Tarjeta de crédito", 2000));
        pagos.add(new Pagos(4, "Efectivo", 2500));

        ArrayList<Notificacion> notificaciones = new ArrayList<>();
        notificaciones.add(new Notificacion(1, "XYZ123", "2024-09-15", "juan.perez@email.com"));
        notificaciones.add(new Notificacion(2, "XYZ124", "2024-09-17", "raul.meraz@email.com"));
        notificaciones.add(new Notificacion(3, "XYZ125", "2024-09-15", "kevin.valencia@email.com"));
        notificaciones.add(new Notificacion(4, "XYZ126", "2024-09-16", "diego.rosales@email.com"));

        System.out.println("------------Detalles de los clientes------------");
        for (Cliente cliente : clientes) {
            cliente.mostrarDetallesCliente();
            System.out.println();
        }

        System.out.println("------------Detalles de los pedidos------------");
        for (Pedidos pedido : pedidos) {
            pedido.mostrarDetallesPedido();
            System.out.println();
        }

        System.out.println("------------Detalles de los pagos------------");
        for (Pagos pago : pagos) {
            pago.mostrarDetallesPago();
            System.out.println();
        }

        System.out.println("------------Detalles de las notificaciones------------");
        for (Notificacion notificacion : notificaciones) {
            notificacion.mostrarDetallesNotificacion();
            System.out.println();
        }
    }
}

class Cliente {
    public String nombre;
    public String direccion;

    public Cliente(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public void mostrarDetallesCliente() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Dirección: " + direccion);
    }
}

class Pedidos {
    public int numero_pedido;
    public String articulos;
    public String cliente;

    public Pedidos(int numero_pedido, String articulos, String cliente) {
        this.numero_pedido = numero_pedido;
        this.articulos = articulos;
        this.cliente = cliente;
    }

    public void mostrarDetallesPedido() {
        System.out.println("Pedido #" + numero_pedido);
        System.out.println("Artículos: " + articulos);
        System.out.println("Cliente: " + cliente);
    }
}

class Pagos {
    public int numero_pedido;
    public String metodo_de_pago;
    public double total;

    public Pagos(int numero_pedido, String metodo_de_pago, double total) {
        this.numero_pedido = numero_pedido;
        this.metodo_de_pago = metodo_de_pago;
        this.total = total;
    }

    public void mostrarDetallesPago() {
        System.out.println("Pago del pedido #" + numero_pedido);
        System.out.println("Método de pago: " + metodo_de_pago);
        System.out.println("Total: $" + total);
    }
}

class Notificacion {
    public int numero_pedido;
    public String guia;
    public String fecha_entrega;
    public String correo;

    public Notificacion(int numero_pedido, String guia, String fecha_entrega, String correo) {
        this.numero_pedido = numero_pedido;
        this.guia = guia;
        this.fecha_entrega = fecha_entrega;
        this.correo = correo;
    }

    public void mostrarDetallesNotificacion() {
        System.out.println("Notificación del pedido #" + numero_pedido);
        System.out.println("Guía: " + guia);
        System.out.println("Fecha de entrega: " + fecha_entrega);
        System.out.println("Correo: " + correo);
    }
}