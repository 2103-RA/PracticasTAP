package controller;

import model.CajeroModelo;
import model.Cuenta;
import view.CajeroVista;

public class CajeroControlador {

    private CajeroModelo modelo;
    private CajeroVista vista;

    public CajeroControlador(CajeroModelo modelo, CajeroVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {

        String numeroCuenta = vista.pedirNumeroCuenta();
        Cuenta cuentaActual = modelo.buscarCuenta(numeroCuenta);

        if (cuentaActual == null) {
            vista.mostrarErrorCuenta();
        } else {
            vista.mostrarBienvenida(cuentaActual.getTitular(), cuentaActual.getNumeroCuenta());

            int opcion;
            double cantidad;

            do {
                opcion = vista.mostrarMenu();

                switch (opcion) {

                    case 1:
                        vista.mostrarSaldo(cuentaActual.getSaldo());
                        break;

                    case 2:
                        cantidad = vista.pedirCantidad("depositar");
                        if (cantidad > 0) {
                            cuentaActual.depositar(cantidad);
                            vista.mostrarMensaje("Depósito exitoso.");
                        } else {
                            vista.mostrarMensaje("Error: el depósito debe ser mayor a $0.");
                        }
                        vista.mostrarSaldo(cuentaActual.getSaldo());
                        break;

                    case 3:
                        cantidad = vista.pedirCantidad("retirar");
                        if (cantidad <= 0) {
                            vista.mostrarMensaje("Error: la cantidad debe ser mayor a $0.");
                        } else if (cantidad > cuentaActual.getSaldo()) {
                            vista.mostrarMensaje("Error: saldo insuficiente.");
                        } else {
                            cuentaActual.retirar(cantidad);
                            vista.mostrarMensaje("Retiro exitoso.");
                        }
                        vista.mostrarSaldo(cuentaActual.getSaldo());
                        break;

                    case 4:
                        vista.mostrarMensaje("Gracias por utilizar el cajero automático.");
                        break;

                    default:
                        vista.mostrarMensaje("Error: opción no válida.");
                }

            } while (opcion != 4);
        }

        vista.cerrarScanner();
    }
}