package modulos;

import javax.swing.*;
import java.awt.*;

public class BotonCalculadora extends JButton {

    public BotonCalculadora(String texto, Color fondo, Color textoColor) {
        super(texto);
        setFont(new Font("Arial", Font.BOLD, 16));
        setBackground(fondo);
        setForeground(textoColor);
    }

    // Sobrecarga para botones con color predeterminado
    public BotonCalculadora(String texto) {
        this(texto, new Color(240, 240, 240), Color.BLACK);
    }
}
