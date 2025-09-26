package views;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RelojView extends JFrame {

    private JLabel lblHora;
    private JLabel lblFecha;
    private Timer timer;

    public RelojView() {
        setTitle("Reloj Digital");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

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

        add(panel, BorderLayout.CENTER);

        timer = new Timer(1000, e -> actualizarReloj());
        timer.start();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void actualizarReloj() {
        Date ahora = new Date();
        lblHora.setText(new SimpleDateFormat("HH:mm:ss").format(ahora));
        lblFecha.setText(new SimpleDateFormat("EEEE, dd MMMM yyyy").format(ahora));
    }
}
