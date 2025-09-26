package views;

import paneles.PanelCentral;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame {

    private PanelCentral panelCentral;

    public Dashboard() {
        panelCentral = new PanelCentral();

        setTitle("Mi Aplicación - Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLayout(new BorderLayout());

        // Menú lateral 
        JPanel menuLateral = new JPanel();
        menuLateral.setLayout(new GridLayout(5, 1, 10, 10));
        menuLateral.setBackground(new Color(33, 37, 41));
        menuLateral.setPreferredSize(new Dimension(200, 600));

        JLabel tituloMenu = new JLabel("MENÚ", JLabel.CENTER);
        tituloMenu.setForeground(Color.WHITE);
        tituloMenu.setFont(new Font("Arial", Font.BOLD, 22));
        menuLateral.add(tituloMenu);

        // Botón Calculadora
        JButton btnCalculadora = crearBotonMenu("🧮 Calculadora");
        btnCalculadora.addActionListener(e -> panelCentral.abrirCalculadora());
        menuLateral.add(btnCalculadora);

        // Botón Reloj
        JButton btnReloj = crearBotonMenu("⏰ Reloj");
        btnReloj.addActionListener(e -> panelCentral.abrirReloj());
        menuLateral.add(btnReloj);

        // Botón Salir
        JButton btnSalir = crearBotonMenu("❌ Salir");
        btnSalir.addActionListener(e -> System.exit(0));
        menuLateral.add(btnSalir);

        // Panel principal vacío por ahora
        JPanel contenido = new JPanel();
        contenido.setBackground(new Color(248, 249, 250));

        add(menuLateral, BorderLayout.WEST);
        add(contenido, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
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
