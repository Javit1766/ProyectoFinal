package paneles;

import views.CalculadoraView;
import views.RelojView;

import javax.swing.*;

public class PanelCentral {

    private JFrame dashboard;

    public PanelCentral(JFrame dashboard) {
        this.dashboard = dashboard;
    }

    public void abrirCalculadora() {
        new CalculadoraView();
    }

    public void abrirReloj() {
        new RelojView(false);
    }

}
