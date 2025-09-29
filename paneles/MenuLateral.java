package paneles;

import javax.swing.*;
import java.awt.*;

public class MenuLateral extends JPanel {

    public MenuLateral(PanelCentral panelCentral) {
        setLayout(new GridLayout(5, 1, 10, 10));
        setBackground(new Color(33, 37, 41));
        setPreferredSize(new Dimension(200, 600));

        // Título
        JLabel tituloMenu = new JLabel("Mis Aplicaciones", JLabel.CENTER);
        tituloMenu.setForeground(Color.WHITE);
        tituloMenu.setFont(new Font("Arial", Font.BOLD, 22));
        add(tituloMenu);

        // Botón Calculadora
        JButton btnCalculadora = crearBotonMenu("🧮 Calculadora");
        btnCalculadora.addActionListener(e -> panelCentral.abrirCalculadora());
        add(btnCalculadora);

        // Botón Reloj
        JButton btnReloj = crearBotonMenu("⏰ Reloj");
        btnReloj.addActionListener(e -> panelCentral.abrirReloj());
        add(btnReloj);

        // Botón Salir
        JButton btnSalir = crearBotonMenu("❌ Salir");
        btnSalir.addActionListener(e -> System.exit(0));
        add(btnSalir);
    }

    private JButton crearBotonMenu(String texto) {
        JButton boton = new JButton(texto);
        boton.setFocusPainted(false);
        boton.setFont(new Font("Arial", Font.BOLD, 16));
        boton.setBackground(new Color(52, 58, 64));
        boton.setForeground(Color.WHITE);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return boton;
    }
}
