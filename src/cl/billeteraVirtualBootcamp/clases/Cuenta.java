package cl.billeteraVirtualBootcamp.clases;

import cl.billeteraVirtualBootcamp.utilitario.Utilitario;

import java.text.DecimalFormat;

public class Cuenta {

    /**
     * @param saldo del tipo double. sirve para almacenar el saldo de la cuenta del cliente
     */
    private double saldo;

    public Cuenta() {
    }

    public Cuenta(double saldo) {
        this.saldo = saldo;
    }

    /**
     * @metodo verSaldoDisponible() muestra el saldo actual del cliente en clp
     * @return regresa el valor del saldo en clp formateado
     */
    public String verSaldoDisponible() {
        return Utilitario.formatearSaldo(this.saldo);
    }

    /**
     * @metodo realizarIngreso() añade saldo al saldo actual actualizando el saldo final. Recibe como entrada el saldo monto a añadir del tipo boolean
     * @return regresa el valor del saldo en clp formateado y actualizado
     */
    public String realizarIngreso(double ingreso) {
        this.saldo += ingreso;
        return Utilitario.formatearSaldo(this.saldo);
    }

    /**
     * @metodo realizarRetiro() retira saldo al saldo actual actualizando el saldo final. Recibe como entrada el saldo monto a retirar del tipo boolean
     * @return regresa el valor del saldo en clp formateado y actualizado
     */
    public String realizarRetiro(double retiro) {
        if (this.saldo < retiro) {
            throw new RuntimeException("Lo que desea retirar es mayor a su saldo actual.");
        }
        this.saldo -= retiro;
        return Utilitario.formatearSaldo(this.saldo);
    }

    /**
     *
     * @metodo Getters and Setters de la clase
     */
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
