package cl.billeteraVirtualBootcamp.clases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    Cliente clienteTest;
    boolean result = true;
    List<Cliente> listaClientesTest = new ArrayList<>();
    Cliente nuevoCliente = new Cliente("15752952-8", "Juan Reyes");


    @BeforeEach
    public void configuration(){
        clienteTest = new Cliente();

    }

    @Test
    void crearCuenta() {
        listaClientesTest.add(nuevoCliente);

        assertTrue(listaClientesTest.contains(nuevoCliente));
    }

    @Test
    void verificarCuenta() {
        listaClientesTest.add(nuevoCliente);

        if(listaClientesTest.isEmpty()){
            result = false;
        }else{
            result = true;
        }
        assertEquals(true,result);

    }


}