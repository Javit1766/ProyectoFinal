package paneles;

import javax.swing.*;
import java.awt.*;

public class PanelContenido extends JPanel {

    public PanelContenido() {
        setBackground(new Color(ABORT));
        setLayout(new BorderLayout());

        // Texto inicial
        JLabel textoInicial = new JLabel("Bienvenido a mis aplicaciones", JLabel.CENTER);
        textoInicial.setFont(new Font("Arial", Font.BOLD, 22));
        textoInicial.setForeground(Color.WHITE); 
        add(textoInicial, BorderLayout.CENTER); 
    }

    public void cambiarContenido(JPanel nuevoPanel) {
        removeAll();
        add(nuevoPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
}
