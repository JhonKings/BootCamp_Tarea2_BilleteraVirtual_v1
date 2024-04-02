package cl.billeteraVirtualBootcamp.convertidores;

import cl.billeteraVirtualBootcamp.convertidores.interfaces.MonedaInterface;
import cl.billeteraVirtualBootcamp.utilitario.Utilitario;

public class ConvertidorDolar implements MonedaInterface {

    /**
     * @param saldo del tipo double obtiene el saldo actual del cliente en clp
     * @param VALOR_DOLAR del tipo double almacena el valor del dolar de forma permanente y constante en el sistema. No puede ser modificado.
     * @param SIMBOLO_MONEDA_D del tipo String almacena el simbolo del dolar de forma permanente y constante en el sistema. No puede ser modificado.
     */
    private double saldo;
    public static final double VALOR_DOLAR = 943.35;
    public static final String SIMBOLO_MONEDA_D = "US$";

    public ConvertidorDolar() {
    }

    public ConvertidorDolar(double saldo) {
        this.saldo = saldo;
    }

    /**
     * @metodo convertir() se usa para convertir el saldo alctual a dolar
     * @return regresa el valor convertido y formateado
     */
    public String convertir() {

        return SIMBOLO_MONEDA_D + Utilitario.formatearSaldo(this.saldo / VALOR_DOLAR);
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
