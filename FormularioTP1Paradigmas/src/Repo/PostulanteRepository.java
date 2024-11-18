package Repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PostulanteRepository {
    private static final String DB_URL = "jdbc:sqlite:C:\\Users\\mateo\\IdeaProjects\\FormularioTP1Paradigmas/post.db"; // Update with your database path

    // save the data of the postulantes
    public void guardarPostu(String nombre, String email, String telefono, String direccion, String experiencia, String educacion, String habilidades) {
        String sql = "INSERT INTO postulantes (nombre, email, telefono, direccion, experiencia, educacion, habilidades) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, email);
            pstmt.setString(3, telefono);
            pstmt.setString(4, direccion);
            pstmt.setString(5, experiencia);
            pstmt.setString(6, educacion);
            pstmt.setString(7, habilidades);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // iterating the database to get all the postulantes
    public List<String[]> obtenerPostulantes() {
        List<String[]> postulantes = new ArrayList<>();
        String sql = "SELECT * FROM postulantes";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            // iterando la base de datos hasta q se encuentre null
            while (rs.next()) {
                String[] postulante = new String[7];
                postulante[0] = rs.getString("nombre");
                postulante[1] = rs.getString("email");
                postulante[2] = rs.getString("telefono");
                postulante[3] = rs.getString("direccion");
                postulante[4] = rs.getString("experiencia");
                postulante[5] = rs.getString("educacion");
                postulante[6] = rs.getString("habilidades");
                postulantes.add(postulante);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return postulantes;
    }
}