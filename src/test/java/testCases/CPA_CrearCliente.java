package testCases;

import pages.CarrucelPages;
import pages.CrearClientePage;
import pages.RegistroPages;

public class CPA_CrearCliente {

    CarrucelPages carrucel = new CarrucelPages();
    RegistroPages registr = new RegistroPages();
    CrearClientePage crearCliente = new CrearClientePage();
    String nombre = "Car";
    String Id= "15";
    String telefono = "123456987";
    String direccion = "Las Acasias";
    String nota = "Cliente nuevo";


    public void flujoIngresoCliente(){
        carrucel.flujoCarrucel();
        registr.validarVistaDesplegada();
        registr.tabBoton();
        registr.tabBtnCliente();
        crearCliente.validarVistaDesplegada();
        crearCliente.ingresarCliente(nombre,Id,telefono,direccion,nota);
        crearCliente.tabBotonGuardar();
    }
}
