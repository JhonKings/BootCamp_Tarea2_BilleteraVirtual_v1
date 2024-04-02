package cl.billeteraVirtualBootcamp.convertidores;

import cl.billeteraVirtualBootcamp.convertidores.interfaces.MonedaInterface;
import cl.billeteraVirtualBootcamp.utilitario.Utilitario;

public class ConvertidorEuro implements MonedaInterface {

    /**
     * @param saldo del tipo double obtiene el saldo actual del cliente en clp
     * @param VALOR_EURO del tipo double almacena el valor del euro de forma permanente y constante en el sistema. No puede ser modificado.
     * @param SIMBOLO_MONEDA_E del tipo String almacena el simbolo del euro de forma permanente y constante en el sistema. No puede ser modificado.
     */
    private double saldo;
    public static final double VALOR_EURO = 1027.78;
    public static final String SIMBOLO_MONEDA_E = "€";

    public ConvertidorEuro() {
    }

    public ConvertidorEuro(double saldo) {
        this.saldo = saldo;
    }

    /**
     * @metodo convertir() se usa para convertir el saldo actual a euro
     * @return regresa el valor convertido y formateado
     */
    public String convertir() {

        return SIMBOLO_MONEDA_E + Utilitario.formatearSaldo(this.saldo / VALOR_EURO);
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
