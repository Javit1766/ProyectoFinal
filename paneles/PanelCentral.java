package paneles;

import views.CalculadoraView;
import views.RelojView;

public class PanelCentral {

    private PanelCalculadora panelCalculadora;

    public PanelCentral() {
        panelCalculadora = new PanelCalculadora();
    }

    // Abre la vista Calculadora
    public void abrirCalculadora() {
        CalculadoraView calcView = new CalculadoraView(this);
        calcView.setVisible(true);
    }

    // Abre la vista Reloj
    public void abrirReloj() {
        RelojView relojView = new RelojView();
        relojView.setVisible(true);
    }

    // Ejecuta operación de la calculadora desde la vista
    public double operarCalculadora(String tipo, double a, double b) {
        return panelCalculadora.operar(tipo, a, b);
    }

    // Historial de la calculadora
    public java.util.List<String> historialCalculadora() {
        return panelCalculadora.obtenerHistorial();
    }
}
