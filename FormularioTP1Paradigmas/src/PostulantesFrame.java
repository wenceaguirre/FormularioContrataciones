import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Service.PostulanteService;

public class PostulantesFrame extends JFrame {
    private PostulanteService postulanteService;

    public PostulantesFrame() {
        postulanteService = new PostulanteService();

        setTitle("Interfaz de Postulantes");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 10, 10));

        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();

        JLabel lblEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField();

        JLabel lblTelefono = new JLabel("Teléfono:");
        JTextField txtTelefono = new JTextField();

        JLabel lblDireccion = new JLabel("Dirección:");
        JTextField txtDireccion = new JTextField();

        JLabel lblExperiencia = new JLabel("Experiencia:");
        JTextField txtExperiencia = new JTextField();

        JLabel lblEducacion = new JLabel("Educación:");
        JTextField txtEducacion = new JTextField();

        JLabel lblHabilidades = new JLabel("Habilidades:");
        JTextField txtHabilidades = new JTextField();

        // adding componentd to the panel
        panel.add(lblNombre);
        panel.add(txtNombre);

        panel.add(lblEmail);
        panel.add(txtEmail);

        panel.add(lblTelefono);
        panel.add(txtTelefono);

        panel.add(lblDireccion);
        panel.add(txtDireccion);

        panel.add(lblExperiencia);
        panel.add(txtExperiencia);

        panel.add(lblEducacion);
        panel.add(txtEducacion);

        panel.add(lblHabilidades);
        panel.add(txtHabilidades);

        // creating save button
        JButton btnGuardar = new JButton("Guardar");
        panel.add(btnGuardar);

        add(panel);

        // event to save information in database
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String email = txtEmail.getText();
                String telefono = txtTelefono.getText();
                String direccion = txtDireccion.getText();
                String experiencia = txtExperiencia.getText();
                String educacion = txtEducacion.getText();
                String habilidades = txtHabilidades.getText();

                postulanteService.guardarPostulante(nombre, email, telefono, direccion, experiencia, educacion, habilidades);
                JOptionPane.showMessageDialog(null, "Datos guardados");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PostulantesFrame().setVisible(true);
            }
        });
    }
}