package modulos;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PanelBotonesCalculadora extends JPanel {

    private List<JButton> botones;

    public PanelBotonesCalculadora(String[] textos) {
        setLayout(new GridLayout(7, 4, 5, 5));
        setBackground(new Color(248, 249, 250));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        botones = new ArrayList<>();

        for (String texto : textos) {
            JButton btn;
            if (texto.matches("[0-9]|\\.")) {
                btn = new BotonCalculadora(texto, new Color(240, 240, 240), Color.BLACK);
            } else if (texto.equals("C") || texto.equals("CE")) {
                btn = new BotonCalculadora(texto, new Color(220, 53, 69), Color.WHITE);
            } else if (texto.equals("sin") || texto.equals("cos") || texto.equals("tan") || texto.equals("√") || texto.equals("x²")) {
                btn = new BotonCalculadora(texto, new Color(40, 167, 69), Color.WHITE);
            } else if (texto.equals("Historial") || texto.equals("BorrarHistorial")) {
                btn = new BotonCalculadora(texto, new Color(108, 117, 125), Color.WHITE);
            } else {
                btn = new BotonCalculadora(texto, new Color(0, 123, 255), Color.WHITE);
            }

            botones.add(btn);
            add(btn);
        }
    }

    public List<JButton> getBotones() {
        return botones;
    }
}
