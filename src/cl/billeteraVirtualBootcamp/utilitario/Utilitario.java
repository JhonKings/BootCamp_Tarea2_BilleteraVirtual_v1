package cl.billeteraVirtualBootcamp.utilitario;

import java.text.DecimalFormat;

public class Utilitario {


    /**
     * @metodo formatearSaldo() usado para formatear el saldo devuelto con maximo 3 decimales
     * @param saldo es el atributo de entrada de tipo double usado para poder formatear
     * @return devuelve al valor formateado y listo.
     */
    public static String formatearSaldo(double saldo) {
        DecimalFormat formateo = new DecimalFormat("#,###");
        return formateo.format(saldo);
    }

    /**
     * @metodo validarRut() usado validar el rut del cliente
     * @param rut es el atributo de entrada del tipo String que se usa para validar
     * @return devuelve el dv calculado y en caso de existir error, devuelve un false
     */
    public static boolean validarRut(String rut) {
        if (rut == null || rut.isEmpty()) {
            return false;
        }

        rut = rut.replace(".", "");

        try {
            String rutNumeros = rut.substring(0, rut.length() - 2);
            char dv = rut.charAt(rut.length() - 1);
            int rutInt = Integer.parseInt(rutNumeros);

            int m = 0, s = 1;
            for (; rutInt != 0; rutInt /= 10) {
                s = (s + rutInt % 10 * (9 - m++ % 6)) % 11;
            }
            char dvCalculado = (char) (s != 0 ? s + 47 : 75);
            return dv == dvCalculado;
        } catch (java.lang.NumberFormatException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
