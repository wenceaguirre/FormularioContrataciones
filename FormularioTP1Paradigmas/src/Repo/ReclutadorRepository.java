package Repo;

import java.sql.*;

public class ReclutadorRepository {
    private static final String DB_URL = "jdbc:sqlite:C:\\Users\\mateo\\IdeaProjects\\FormularioTP1Paradigmas/post.db";
    // el archivo db lo subo directamente a la carpeta es un quilombo hacer toda la conexion me tuve q descargar un archivo jar file de maven repository: jdbc sqlite
    // , e olvide q tenia q hacer el proyecto en netbeans y lo hice en intelli

    public boolean verificarMailContra(String email, String contrasena) {
        String sql = "SELECT * FROM reclutadores WHERE email = ? AND contrasena = ?";

        // el prepared statement sirve para pasar los parametros de manera segura
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // email y contrasena son los parametros que se pasan a la query
            pstmt.setString(1, email);
            pstmt.setString(2, contrasena);

            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next(); // Returns true if a record is found
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}









