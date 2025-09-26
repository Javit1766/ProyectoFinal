package paneles;

import controles.CalculadoraController;
import java.util.List;

public class PanelCalculadora {

    private CalculadoraController controller;

    public PanelCalculadora() {
        controller = new CalculadoraController();
    }

    public double operar(String tipo, double a, double b) {
        return controller.operar(tipo, a, b);
    }

    public List<String> obtenerHistorial() {
        return controller.getHistorial();
    }
}
