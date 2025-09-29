package views;

import modulos.PanelBotonesCalculadora;
import modulos.OperacionesAvanzadas;
import controles.CalculadoraController;
import database.HistorialDB;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CalculadoraView extends JFrame {

    private JTextField pantalla;
    private PanelBotonesCalculadora panelBotones;
    private CalculadoraController controller;

    private String operador = "";
    private double valor1 = 0;

    public CalculadoraView() {
        controller = new CalculadoraController();

        setTitle("Calculadora Científica");
        setSize(400, 600);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Pantalla
        pantalla = new JTextField("0");
        pantalla.setFont(new Font("Digital-7", Font.BOLD, 32));
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setEditable(false);
        pantalla.setBackground(new Color(230, 230, 230));
        pantalla.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(pantalla, BorderLayout.NORTH);

        // Botones
        String[] textos = {
            "7","8","9","/",
            "4","5","6","*",
            "1","2","3","-",
            "0",".","=","+",
            "sin","cos","tan","√",
            "x²","C","CE","Historial",
            "BorrarHistorial"
        };

        panelBotones = new PanelBotonesCalculadora(textos);
        for (JButton boton : panelBotones.getBotones()) {
            boton.addActionListener(e -> manejarBoton(boton.getText()));
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
                double resultado = controller.operar(operador, valor1, valor2);
                pantalla.setText(String.valueOf(resultado));

                // Guardar en historial
                String operacion = valor1 + " " + operador + " " + valor2 + " = " + resultado;
                HistorialDB.guardarOperacion(operacion);

            } else if (texto.equals("C")) {
                pantalla.setText("0");
                valor1 = 0;
                operador = "";
            } else if (texto.equals("CE")) {
                pantalla.setText("0");
            } else if (texto.equals("x²")) {
                pantalla.setText(String.valueOf(OperacionesAvanzadas.cuadrado(Double.parseDouble(pantalla.getText()))));
            } else if (texto.equals("√")) {
                pantalla.setText(String.valueOf(OperacionesAvanzadas.raiz(Double.parseDouble(pantalla.getText()))));
            } else if (texto.equals("sin")) {
                pantalla.setText(String.valueOf(OperacionesAvanzadas.seno(Double.parseDouble(pantalla.getText()))));
            } else if (texto.equals("cos")) {
                pantalla.setText(String.valueOf(OperacionesAvanzadas.coseno(Double.parseDouble(pantalla.getText()))));
            } else if (texto.equals("tan")) {
                pantalla.setText(String.valueOf(OperacionesAvanzadas.tangente(Double.parseDouble(pantalla.getText()))));
            } else if (texto.equals("Historial")) {
                mostrarHistorial();
            } else if (texto.equals("BorrarHistorial")) {
                HistorialDB.limpiarHistorial();
                JOptionPane.showMessageDialog(this, "Historial borrado correctamente.");
            }
        } catch (NumberFormatException e) {
            pantalla.setText("Error");
        }
    }

    private void mostrarHistorial() {
        List<String> lista = HistorialDB.leerHistorial();
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
