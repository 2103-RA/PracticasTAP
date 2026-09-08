import controller.CajeroControlador;
import model.CajeroModelo;
import view.CajeroVista;

public class Main {
    public static void main(String[] args) {
        CajeroModelo modelo = new CajeroModelo();
        CajeroVista vista = new CajeroVista();
        CajeroControlador controlador = new CajeroControlador(modelo, vista);
        controlador.iniciar();
    }
}