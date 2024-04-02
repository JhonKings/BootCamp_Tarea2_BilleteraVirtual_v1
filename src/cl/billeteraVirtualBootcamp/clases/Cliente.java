package cl.billeteraVirtualBootcamp.clases;

public class Cliente {
    //Atributos
    /**
     * @param cuenta obtiene el valor de la clases Cuenta
     * @param rutCliente es el rut del cliente del tipo String que, al mismo tiempo, funciona como id
     * @param nombreCliente es el nombre del cliente del tipo String
     *
     */
    private Cuenta cuenta;
    private String rutCliente;
    private String nombreCliente;

    //Constructor
    public Cliente() {

    }

    /**
     *
     * @param rutCliente es el Rut del cliente que se usa para validar la veracidad del requerimiento
     * @param nombreCliente es el nombre del cliente
     */
    public Cliente(String rutCliente, String nombreCliente) {
        this.rutCliente = rutCliente;
        this.nombreCliente = nombreCliente;
    }

    /**
     * @Metodo crearCuenta() valida si el cliente ya tiene una cuenta creada.
     */
    public void crearCuenta() {
        if (this.cuenta != null) {
            throw new RuntimeException("Este cliente ya tiene una cuenta");
        }
        this.cuenta = new Cuenta();
    }

    /**
     * Metodo verificarCuenta() verifica si existe cuenta
     * @return true si el cliente ya tiene una cuenta
     */
    public boolean verificarCuenta() {
        return this.cuenta != null;
    }

    /**
     *
     * @metodo Getters and Setters de la clase
     */
    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }


}
