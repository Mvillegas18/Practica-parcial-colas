import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Queue<Cliente> clientes = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n--- MENÚ BANCO ---");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Mostrar clientes");
            System.out.println("3. Editar cliente");
            System.out.println("4. Eliminar primer cliente");
            System.out.println("5. Atender cliente (consumir)");
            System.out.println("6. Salir");
            System.out.println("Seleccione una opcion: ");

            if(!sc.hasNextInt()) {
                System.out.println("Error: Debe ingresar un numero entero");
                sc.nextLine();
                continue;
            }

            int opcion = sc.nextInt();
            sc.nextLine();

            if(opcion < 1 || opcion > 6) {
                System.out.println("Error: Opcion no valida. Ingrese un numero entre 1 y 6");
                continue;
            }

            switch (opcion) {
                case 1:
                    // agregar cliente
                    System.out.println("\n--- Agregar cliente ---");

                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombre = sc.nextLine();

                    System.out.print("Ingrese el numero de ID: ");
                    int id = sc.nextInt();

                    clientes.offer(new Cliente(nombre, id));
                    System.out.println("Cliente agregado con exito.");
                    break;
                case 2:
                    // mostrar clientes
                    System.out.println("\n--- Mostrar clientes ---");
                    if(clientes.isEmpty()) {
                        System.out.println("No hay clientes en la cola");
                    }else {
                        System.out.println("Clientes en la cola: ");
                        for(Cliente cliente : clientes){
                            System.out.println("Nombre: " + cliente.getName() + " | ID: " + cliente.getId());
                        }
                    }
                    break;
                case 3:
                    // editar cliente
                    System.out.println("\n--- Editar cliente ---");

                    System.out.println("Ingrese el nombre del cliente que desea modificar: ");
                    String clienteModificar = sc.nextLine();
                    boolean clienteEncontrado = false;

                    for(Cliente cliente : clientes){
                        if(clienteModificar.equalsIgnoreCase(cliente.getName())) {
                            System.out.println("Modifica el nombre del cliente y su cedula: " + cliente.getName() + " | ID: " + cliente.getId());
                            clienteEncontrado = true;
                            System.out.println("Nombre: ");
                            cliente.setName(sc.nextLine());
                            System.out.println("Cedula: ");
                            while(!sc.hasNextInt()) {
                                System.out.println("Error: Debe ingresar un numero entero");
                                sc.nextLine();
                            }
                            cliente.setId(sc.nextInt());
                            sc.nextLine();

                            System.out.println("Estos son los nuevos datos del cliente: ");
                            System.out.println("Nombre: " + cliente.getName() + " | ID: " + cliente.getId());
                        }
                    }
                    if(!clienteEncontrado) {
                        System.out.println("Cliente no encontrado.");
                        System.out.println("Presione ENTER para continuar");
                        sc.nextLine();
                    }
                    break;
                case 4:
                    // eliminar
                    System.out.println("\n--- Eliminar primer cliente ---");
                    Cliente clienteEliminado = clientes.poll();
                    if(clienteEliminado != null) {
                        clientes.remove(clienteEliminado);
                        System.out.println("Cliente : " + clienteEliminado.getName() + " eliminado correctamente.");
                    }else {
                        System.out.println("La cola esta vacia.");
                    }
                    break;
                case 5:
                    // atender cliente
                    System.out.println("\n--- Atender cliente ---");
                    Cliente clienteAtendido = clientes.poll();
                    if(clienteAtendido != null) {
                        System.out.println("Cliente atendido : " + clienteAtendido.getName() + " | ID: " + clienteAtendido.getId());
                    }else {
                        System.out.println("La cola esta vacia.");
                    }
                    break;
                case 6:
                    System.out.println("👋 Saliendo del sistema...");
                    continuar = false;
                    break;
            }



        }
        sc.close();
    }
}