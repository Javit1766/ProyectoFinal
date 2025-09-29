package views;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RelojView extends JPanel {

    private JLabel lblHora;
    private JLabel lblFecha;
    private Timer timer;

    private JPanel panelPrincipal;

    public RelojView(boolean modoPanel) {
        panelPrincipal = new JPanel(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setBackground(new Color(52, 58, 64));
        panel.setLayout(new GridLayout(2, 1));

        lblHora = new JLabel("", JLabel.CENTER);
        lblHora.setFont(new Font("Digital-7", Font.BOLD, 40));
        lblHora.setForeground(new Color(40, 167, 69));

        lblFecha = new JLabel("", JLabel.CENTER);
        lblFecha.setFont(new Font("Arial", Font.PLAIN, 18));
        lblFecha.setForeground(Color.WHITE);

        panel.add(lblHora);
        panel.add(lblFecha);

        panelPrincipal.add(panel, BorderLayout.CENTER);

        timer = new Timer(1000, e -> actualizarReloj());
        timer.start();

        if (!modoPanel) {
            JFrame frame = new JFrame("Reloj Digital");
            frame.setSize(300, 200);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.add(panelPrincipal, BorderLayout.CENTER);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    }

    private void actualizarReloj() {
        Date ahora = new Date();
        lblHora.setText(new SimpleDateFormat("HH:mm:ss").format(ahora));
        lblFecha.setText(new SimpleDateFormat("EEEE, dd MMMM yyyy").format(ahora));
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    // Solo para pruebas independientes
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RelojView(false));
    }
}

