package model;

import java.util.ArrayList;

public class CajeroModelo {

    private ArrayList<Cuenta> cuentas;

    public CajeroModelo() {
        cuentas = new ArrayList<>();
        cuentas.add(new Cuenta("1001", "Juan Pérez", 5000));
        cuentas.add(new Cuenta("1002", "María López", 8500));
        cuentas.add(new Cuenta("1003", "Pedro García", 3200));
        cuentas.add(new Cuenta("1004", "Ana Martínez", 12000));
    }

    public Cuenta buscarCuenta(String numeroCuenta) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }
}