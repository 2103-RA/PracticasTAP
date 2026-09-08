package view;

import java.util.Scanner;

public class CajeroVista {

    private Scanner scanner = new Scanner(System.in);

    public String pedirNumeroCuenta() {
        System.out.println("===== CAJERO AUTOMÁTICO =====");
        System.out.print("Ingrese su número de cuenta: ");
        return scanner.nextLine();
    }

    public void mostrarBienvenida(String titular, String numeroCuenta) {
        System.out.println("\nBienvenido: " + titular);
        System.out.println("Número de cuenta: " + numeroCuenta);
    }

    public void mostrarErrorCuenta() {
        System.out.println("Error: la cuenta no existe.");
    }

    public int mostrarMenu() {
        System.out.println("\n===== MENÚ PRINCIPAL =====");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Depositar dinero");
        System.out.println("3. Retirar dinero");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public void mostrarSaldo(double saldo) {
        System.out.println("Saldo actual: $" + saldo);
    }

    public double pedirCantidad(String operacion) {
        System.out.print("Cantidad a " + operacion + ": $");
        return scanner.nextDouble();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}