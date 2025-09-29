package views;

import paneles.MenuLateral;
import paneles.PanelContenido;
import paneles.PanelCentral;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    private PanelCentral panelCentral;
    private PanelContenido panelContenido;

    public Dashboard() {
        setTitle("Mi Aplicación - Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLayout(new BorderLayout());

        // Inicializar el Panel Central
        panelCentral = new PanelCentral(this);

        // Menú lateral separado
        MenuLateral menuLateral = new MenuLateral(panelCentral);

        // Panel de contenido vacío
        panelContenido = new PanelContenido();

        add(menuLateral, BorderLayout.WEST);
        add(panelContenido, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public PanelContenido getPanelContenido() {
        return panelContenido;
    }
}
