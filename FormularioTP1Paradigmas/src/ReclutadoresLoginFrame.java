
import Repo.PostulanteRepository;
import Service.PostulanteService;
import Service.ReclutadorService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ReclutadoresLoginFrame extends JFrame {
    private ReclutadorService reclutadorService;
    private PostulanteService postulanteService;

    public ReclutadoresLoginFrame() {
        reclutadorService = new ReclutadorService();
        postulanteService = new PostulanteService();
        setTitle("Login de Reclutadores");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));


        JLabel lblEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField();

        JLabel lblContrasena = new JLabel("Contraseña:");
        JPasswordField txtContrasena = new JPasswordField();


        panel.add(lblEmail);
        panel.add(txtEmail);

        panel.add(lblContrasena);
        panel.add(txtContrasena);

        // botton login
        JButton btnLogin = new JButton("Login");
        panel.add(btnLogin);

        // adding the panel to the frame
        add(panel);

        // login event
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = txtEmail.getText();
                String contrasena = new String(txtContrasena.getPassword());

                if (reclutadorService.iniciarSesion(email, contrasena)) {
                    JOptionPane.showMessageDialog(null, "Login exitoso");
                    showPostulantes();
                } else {
                    JOptionPane.showMessageDialog(null, "Email o contraseña incorrectos");
                }
            }
        });
    }

    // showing the postulantes, aplicants
    private void showPostulantes() {
        List<String[]> postulantes = postulanteService.mostrarPostulantes();

        JFrame postulantesFrame = new JFrame("Lista de Postulantes");
        postulantesFrame.setSize(800, 400);
        postulantesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        postulantesFrame.setLocationRelativeTo(null);

        String[] columnNames = {"Nombre", "Email", "Teléfono", "Dirección", "Experiencia", "Educación", "Habilidades"};
        String[][] data = postulantes.toArray(new String[0][]);

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        postulantesFrame.add(scrollPane);

        postulantesFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ReclutadoresLoginFrame().setVisible(true);
            }
        });
    }
}