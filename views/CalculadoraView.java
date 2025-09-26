package views;

import paneles.PanelCentral;
import paneles.PanelCalculadora;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CalculadoraView extends JFrame {

    private JTextField pantalla;
    private PanelCentral panelCentral;
    private PanelCalculadora panelCalculadora;

    private String operador = "";
    private double valor1 = 0;

    public CalculadoraView(PanelCentral central) {
        this.panelCentral = central;
        this.panelCalculadora = new PanelCalculadora();

        setTitle("Calculadora Científica");
        setSize(400, 600);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // PANTALLA
        pantalla = new JTextField("0");
        pantalla.setFont(new Font("Digital-7", Font.BOLD, 32));
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setEditable(false);
        pantalla.setBackground(new Color(230, 230, 230));
        pantalla.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(pantalla, BorderLayout.NORTH);

        // PANEL DE BOTONES
        JPanel panelBotones = new JPanel(new GridLayout(6, 4, 5, 5));
        panelBotones.setBackground(new Color(248, 249, 250));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] botones = {
            "7","8","9","/",
            "4","5","6","*",
            "1","2","3","-",
            "0",".","=","+",
            "sin","cos","tan","√",
            "x²","C","CE","Historial"
        };

        for (String texto : botones) {
            JButton btn = new JButton(texto);
            btn.setFont(new Font("Arial", Font.BOLD, 16));

            if (texto.matches("[0-9]|\\.")) {
                btn.setBackground(new Color(240, 240, 240));
            } else if (texto.equals("C") || texto.equals("CE")) {
                btn.setBackground(new Color(220, 53, 69));
                btn.setForeground(Color.WHITE);
            } else if (texto.equals("sin") || texto.equals("cos") || texto.equals("tan") || texto.equals("√") || texto.equals("x²")) {
                btn.setBackground(new Color(40, 167, 69));
                btn.setForeground(Color.WHITE);
            } else {
                btn.setBackground(new Color(0, 123, 255));
                btn.setForeground(Color.WHITE);
            }

            btn.addActionListener(e -> manejarBoton(texto));
            panelBotones.add(btn);
        }

        add(panelBotones, BorderLayout.CENTER);

        setVisible(true);
    }

    private void manejarBoton(String texto) {
        try {
            if (texto.matches("[0-9]|\\.")) {
                if (pantalla.getText().equals("0")) {
                    pantalla.setText(texto);
                } else {
                    pantalla.setText(pantalla.getText() + texto);
                }
            } else if ("+-*/".contains(texto)) {
                valor1 = Double.parseDouble(pantalla.getText());
                operador = texto;
                pantalla.setText("0");
            } else if (texto.equals("=")) {
                double valor2 = Double.parseDouble(pantalla.getText());
                double resultado = panelCentral.operarCalculadora(operador, valor1, valor2);
                pantalla.setText(String.valueOf(resultado));

                // Guardar operación en el historial del panelCalculadora
                panelCalculadora.obtenerHistorial().add(valor1 + " " + operador + " " + valor2 + " = " + resultado);

            } else if (texto.equals("C")) {
                pantalla.setText("0");
                valor1 = 0;
                operador = "";
            } else if (texto.equals("CE")) {
                pantalla.setText("0");
            } else if (texto.equals("x²")) {
                double valor = Double.parseDouble(pantalla.getText());
                pantalla.setText(String.valueOf(valor * valor));
            } else if (texto.equals("√")) {
                double valor = Double.parseDouble(pantalla.getText());
                pantalla.setText(String.valueOf(Math.sqrt(valor)));
            } else if (texto.equals("sin")) {
                double valor = Double.parseDouble(pantalla.getText());
                pantalla.setText(String.valueOf(Math.sin(Math.toRadians(valor))));
            } else if (texto.equals("cos")) {
                double valor = Double.parseDouble(pantalla.getText());
                pantalla.setText(String.valueOf(Math.cos(Math.toRadians(valor))));
            } else if (texto.equals("tan")) {
                double valor = Double.parseDouble(pantalla.getText());
                pantalla.setText(String.valueOf(Math.tan(Math.toRadians(valor))));
            } else if (texto.equals("Historial")) {
                mostrarHistorial();
            }
        } catch (NumberFormatException e) {
            pantalla.setText("Error");
        }
    }

    private void mostrarHistorial() {
        List<String> lista = panelCalculadora.obtenerHistorial();
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay operaciones en el historial.", "Historial", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JList<String> jList = new JList<>(lista.toArray(new String[0]));
            jList.setFont(new Font("Arial", Font.PLAIN, 16));
            JScrollPane scroll = new JScrollPane(jList);
            scroll.setPreferredSize(new Dimension(350, 400));
            JOptionPane.showMessageDialog(this, scroll, "Historial de operaciones", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
