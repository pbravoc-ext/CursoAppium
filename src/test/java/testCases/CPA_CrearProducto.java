package testCases;

import pages.CarrucelPages;
import pages.CrearProductoPage;
import pages.RegistroPages;

public class CPA_CrearProducto {

    CarrucelPages carrucel = new CarrucelPages();
    RegistroPages registr = new RegistroPages();
    CrearProductoPage producto = new CrearProductoPage();
    String nombreProducto = "Disco 8";
    String precio= "12.000";

    public void flujoIngresoProducto(){
        //carrucel.flujoCarrucel();
        registr.validarVistaDesplegada();
        registr.tabBoton();
        registr.tabBtnProducto();
        producto.validarVistaDesplegada();
        producto.ingresarProducto(nombreProducto,precio);
        producto.tabBotonConfirmar();
        producto.tabBotonProducto();
    }
}
