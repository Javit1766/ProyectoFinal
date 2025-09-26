package controles;

import modulos.CalculadoraModulo;
import java.util.ArrayList;
import java.util.List;

public class CalculadoraController {

    private CalculadoraModulo modulo;
    private List<String> historial;

    public CalculadoraController() {
        modulo = new CalculadoraModulo();
        historial = new ArrayList<>();
    }

    public double operar(String tipo, double a, double b) {
        double resultado = 0;
        switch (tipo) {
            case "+": resultado = modulo.sumar(a, b); break;
            case "-": resultado = modulo.restar(a, b); break;
            case "*": resultado = modulo.multiplicar(a, b); break;
            case "/": resultado = modulo.dividir(a, b); break;
        }

        // historial
        historial.add(a + " " + tipo + " " + b + " = " + resultado);
        return resultado;
    }

    public List<String> getHistorial() {
        return historial;
    }
}
