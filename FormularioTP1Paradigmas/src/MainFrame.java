import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("App de Reclutamiento");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // creating the panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2, 10, 10));

        JButton btnReclutadores = new JButton("Reclutadores");
        JButton btnPostulantes = new JButton("Postulantes");

        // bigger font
        Font font = new Font("Arial", Font.BOLD, 24);
        btnReclutadores.setFont(font);
        btnPostulantes.setFont(font);

        panel.add(btnReclutadores);
        panel.add(btnPostulantes);

        add(panel);

        btnReclutadores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ReclutadoresLoginFrame().setVisible(true);
            }
        });

        btnPostulantes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PostulantesFrame().setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}