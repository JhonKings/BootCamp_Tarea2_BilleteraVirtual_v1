import cl.billeteraVirtualBootcamp.clases.Cliente;
import cl.billeteraVirtualBootcamp.clases.Cuenta;
import cl.billeteraVirtualBootcamp.convertidores.ConvertidorDolar;
import cl.billeteraVirtualBootcamp.convertidores.ConvertidorEuro;
import cl.billeteraVirtualBootcamp.convertidores.interfaces.MonedaInterface;
import cl.billeteraVirtualBootcamp.utilitario.Utilitario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Cuenta cuenta = new Cuenta();


        System.out.println("**************************************************************************************");
        System.out.println("*                                                                                    *");
        System.out.println("*                       Bienvenido a mi Billetera                                    *");
        System.out.println("*                                                                                    *");
        System.out.println("* Valor Dolar hoy: " + ConvertidorDolar.SIMBOLO_MONEDA_D + ConvertidorDolar.VALOR_DOLAR);
        System.out.println("* Valor Euro hoy: " + ConvertidorEuro.SIMBOLO_MONEDA_E + ConvertidorEuro.VALOR_EURO);
        System.out.println("*                                                                                    *");
        System.out.println("**************************************************************************************");

        /**
         * parametros usados en el menu principal
         * @param seleccion es el atributo de tipo entero que se usa para gatillar cada uno de los switch usados en la acciones del sistema
         * @param montoDinero es el atributo de tipo String usado para guardar el monto ingresado desde el scanner
         * @param montoDineroDouble es el atributo de tipo double usado para parsear el atributo montoDinero
         * @param listaClientes es el atributo tipo array usado para almacenar el cliente
         * @param SIMBOLO_MONEDA_D es el atributo global tipo String que almacena el dato del simbolo de moneda de dolar de forma constante
         * @param VALOR_DOLAR es el atributo global tipo String que almacena el valor de la moneda dolar actual de forma constante
         * @param SIMBOLO_MONEDA_E es el atributo global tipo String que almacena el dato del simbolo de moneda de euro de forma constante
         * @param VALOR_EURO es el atributo global tipo String que almacena el valor de la moneda euro actual de forma constante
         *
         */
        Scanner scanner = new Scanner(System.in);
        int seleccion = 0;
        String montoDinero = "";
        double montoDineroDouble = 0;
        List<Cliente> listaClientes = new ArrayList<>();

        System.out.println();

        do {
            try {
                System.out.println("******************* MENU ******************");

                System.out.println("* Crear Cliente ---------------------> 1  *");
                System.out.println("* Crear Cuenta ----------------------> 2  *");
                System.out.println("* Saldo Disponible ------------------> 3  *");
                System.out.println("* Depositar Dinero ------------------> 4  *");
                System.out.println("* Retirar Dinero --------------------> 5  *");
                System.out.println("* Ver Saldo en USD ------------------> 6  *");
                System.out.println("* Ver Saldo en Euros ----------------> 7  *");
                System.out.println("*                                         *");
                System.out.println("* Salir del Sistema -----------------> 0  *");

                System.out.println("*******************************************");
                System.out.println();

                System.out.print("Ingrese su selección/acción: ");


                String inputSeleccion = scanner.nextLine();
                seleccion = Integer.parseInt(inputSeleccion);

                String rutCliente = "";
                Cliente clienteEncontrado = null;

                switch (seleccion) {
                    case 1:
                        System.out.println("Ingrese su RUT (Formato: 12345678-9). ");
                        rutCliente = scanner.nextLine();

                        if (Utilitario.validarRut(rutCliente)) {
                            System.out.println("Ingrese su nombre completo.");
                            String nombreCliente = scanner.nextLine();

                            Cliente nuevoCliente = new Cliente(rutCliente, nombreCliente);
                            listaClientes.add(nuevoCliente);

                            System.out.println("CLIENTE CREADO CON EXITO. Bienvenido " + nuevoCliente.getNombreCliente());
                            System.out.println("------------------------------------------");
                            System.out.println();

                        } else {
                            System.out.println("ERROR Validación de RUT. El RUT está mal digitado o erróneo.");
                            System.out.println("------------------------------------------");
                            System.out.println();
                        }
                        break;
                    case 2:
                        System.out.println("Por seguridad, ingrese su RUT (Formato: 12345678-9).");
                        rutCliente = scanner.nextLine();

                        if (Utilitario.validarRut(rutCliente)) {
                            for (Cliente clienteExistente : listaClientes) {
                                if (clienteExistente.getRutCliente().equals(rutCliente)) {
                                    clienteEncontrado = clienteExistente;
                                    break;
                                }
                            }

                            if (clienteEncontrado == null) {
                                System.out.println("El RUT ingresado no existe o no fue encontrado. Favor reingresar RUT o crear cliente con la opción 1.");
                                System.out.println("------------------------------------------");
                                System.out.println();
                                break;
                            }

                            if (clienteEncontrado.verificarCuenta()) {
                                System.out.println("Esta cuenta ya existe.");
                                System.out.println("------------------------------------------");
                                System.out.println();
                                break;
                            }

                            if (clienteEncontrado != null) {
                                clienteEncontrado.crearCuenta();
                            }

                            System.out.println("CUENTA CREADA EXITOSAMENTE.");
                            System.out.println("Estimado " + clienteEncontrado.getNombreCliente() + ", usted ya puede usar su cuenta.");
                            System.out.println("------------------------------------------");
                            System.out.println();
                            System.out.println();
                        } else {
                            System.out.println("ERROR Validación de RUT. El RUT está mal digitado o erróneo.");
                            System.out.println("------------------------------------------");
                            System.out.println();
                        }

                        break;
                    case 3:
                        System.out.println("Por seguridad, ingrese su RUT (Formato: 12345678-9).");
                        rutCliente = scanner.nextLine();

                        if (Utilitario.validarRut(rutCliente)) {
                            for (Cliente clienteExistente : listaClientes) {
                                if (clienteExistente.getRutCliente().equals(rutCliente)) {
                                    clienteEncontrado = clienteExistente;
                                    break;
                                }
                            }

                            if (clienteEncontrado == null) {
                                System.out.println("El RUT ingresado no existe o no fue encontrado. Favor reingresar RUT o crear cliente con la opción 1.");
                                System.out.println("------------------------------------------");
                                System.out.println();
                                break;
                            }

                            if (!clienteEncontrado.verificarCuenta()) {
                                System.out.println("La cuenta no existe o no fue encontrada. Favor reingresar numero de cuenta o crear cuenta con la opción 2.");
                                System.out.println("------------------------------------------");
                                System.out.println();
                                break;
                            }

                            String saldo = clienteEncontrado.getCuenta().verSaldoDisponible();
                            System.out.println("Estimado " + clienteEncontrado.getNombreCliente() + " su saldo actual es $" + saldo + "clp");
                            System.out.println("------------------------------------------");
                            System.out.println();

                        } else {
                            System.out.println("ERROR Validación de RUT. El RUT está mal digitado o erróneo.");
                            System.out.println("------------------------------------------");
                            System.out.println();
                        }

                        break;
                    case 4:
                        System.out.println("Por seguridad, ingrese su RUT (Formato: 12345678-9).");
                        rutCliente = scanner.nextLine();

                        if (Utilitario.validarRut(rutCliente)) {
                            for (Cliente clienteExistente : listaClientes) {
                                if (clienteExistente.getRutCliente().equals(rutCliente)) {
                                    clienteEncontrado = clienteExistente;
                                    break;
                                }
                            }

                            if (clienteEncontrado == null) {
                                System.out.println("El RUT ingresado no existe o no fue encontrado. Favor reingresar RUT o crear cliente con la opción 1.");
                                System.out.println("------------------------------------------");
                                System.out.println();
                                break;
                            }

                            if (!clienteEncontrado.verificarCuenta()) {
                                System.out.println("La cuenta no existe o no fue encontrada. Favor reingresar numero de cuenta o crear cuenta con la opción 2.");
                                System.out.println("------------------------------------------");
                                System.out.println();
                                break;
                            }

                            System.out.println("Ingrese monto a depositar.");
                            montoDinero = scanner.nextLine();
                            montoDineroDouble = Double.parseDouble(montoDinero);

                            System.out.println("Estimado(a) " + clienteEncontrado.getNombreCliente() + " su saldo actual es $" + clienteEncontrado.getCuenta().realizarIngreso(montoDineroDouble) + "clp");
                            System.out.println("INGRESO EXITOSO.");
                            System.out.println("------------------------------------------");
                            System.out.println();

                        } else {
                            System.out.println("ERROR Validación de RUT. El RUT está mal digitado o erróneo.");
                            System.out.println("------------------------------------------");
                            System.out.println();
                        }

                        break;
                    case 5:
                        System.out.println("Por seguridad, ingrese su RUT (Formato: 12345678-9).");
                        rutCliente = scanner.nextLine();

                        if (Utilitario.validarRut(rutCliente)) {
                            for (Cliente clienteExistente : listaClientes) {
                                if (clienteExistente.getRutCliente().equals(rutCliente)) {
                                    clienteEncontrado = clienteExistente;
                                    break;
                                }
                            }

                            if (clienteEncontrado == null) {
                                System.out.println("El RUT ingresado no existe o no fue encontrado. Favor reingresar RUT o crear cliente con la opción 1.");
                                System.out.println("------------------------------------------");
                                System.out.println();
                                break;
                            }

                            if (!clienteEncontrado.verificarCuenta()) {
                                System.out.println("La cuenta no existe o no fue encontrada. Favor reingresar numero de cuenta o crear cuenta con la opción 2.");
                                System.out.println("------------------------------------------");
                                System.out.println();
                                break;
                            }

                            System.out.println("Ingrese monto a retirar.");
                            montoDinero = scanner.nextLine();
                            montoDineroDouble = Double.parseDouble(montoDinero);

                            System.out.println("Estimado(a) " + clienteEncontrado.getNombreCliente() + " su saldo actual es $" + clienteEncontrado.getCuenta().realizarRetiro(montoDineroDouble) + "clp");
                            System.out.println("RETIRO EXITOSO.");
                            System.out.println("------------------------------------------");
                            System.out.println();
                        } else {
                            System.out.println("ERROR Validación de RUT. El RUT está mal digitado o erróneo.");
                            System.out.println("------------------------------------------");
                            System.out.println();
                        }

                        break;
                    case 6:
                    case 7:
                        System.out.println("Por seguridad, ingrese su RUT (Formato: 12345678-9).");
                        rutCliente = scanner.nextLine();

                        if (Utilitario.validarRut(rutCliente)) {
                            for (Cliente clienteExistente : listaClientes) {
                                if (clienteExistente.getRutCliente().equals(rutCliente)) {
                                    clienteEncontrado = clienteExistente;
                                    break;
                                }
                            }

                            if (clienteEncontrado == null) {
                                System.out.println("El RUT ingresado no existe o no fue encontrado. Favor reingresar RUT o crear cliente con la opción 1.");
                                System.out.println("------------------------------------------");
                                System.out.println();
                                break;
                            }

                            if (!clienteEncontrado.verificarCuenta()) {
                                System.out.println("La cuenta no existe o no fue encontrada. Favor reingresar numero de cuenta o crear cuenta con la opción 2.");
                                System.out.println("------------------------------------------");
                                System.out.println();
                                break;
                            }

                            MonedaInterface moneda = null;
                            if (seleccion == 6) {
                                moneda = new ConvertidorDolar(clienteEncontrado.getCuenta().getSaldo());
                            }

                            if (seleccion == 7) {
                                moneda = new ConvertidorEuro(clienteEncontrado.getCuenta().getSaldo());
                            }

                            System.out.println("Estimado(a) " + clienteEncontrado.getNombreCliente() + " este es su saldo actual convertido a : " + moneda.convertir());
                            System.out.println("------------------------------------------");
                            System.out.println();
                        } else {
                            System.out.println("ERROR Validación de RUT. El RUT está mal digitado o erróneo.");
                            System.out.println("------------------------------------------");
                            System.out.println();
                        }

                        break;
                    case 0:
                        System.out.println("GRACIAS POR PREFERIRNOS. VUELVA PRONTO.");
                        System.out.println("------------------------------------------");
                        System.out.println();
                        break;
                    default:
                        System.out.println("Sólo se permite números enteros como opción de menú!");
                        System.out.println();
                }

            } catch (NumberFormatException error) {
                System.out.println("Solo se permiten numeros.");
                System.out.println();
            } catch (RuntimeException error) {
                System.out.println("Ocurrio un error: " + error.getMessage());
                System.out.println();
            } catch (Exception error) {
                System.out.println("Ocurrio otro error: " + error.getMessage());
                System.out.println();
            }
        } while (!(seleccion == 0));
        scanner.close();


    }
}