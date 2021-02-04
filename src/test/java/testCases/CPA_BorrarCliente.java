package testCases;

import pages.BorrarClientePage;
import pages.RegistroPages;

public class CPA_BorrarCliente {

    RegistroPages registr = new RegistroPages();
    BorrarClientePage borrar = new BorrarClientePage();

    String eliminar = "BORRAR";

    public void flujoBorrarCliente(){
        borrar.tabBotonCliente();
        registr.validarVistaDesplegada();
        borrar.validarVistaDesplegada();
        borrar.seleccionarCliente();
        borrar.encontrarBtn();
        borrar.borrarCliente(eliminar);
        registr.validarVistaDesplegada();



    }
}
