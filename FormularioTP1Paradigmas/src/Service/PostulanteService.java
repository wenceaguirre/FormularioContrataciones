package Service;

import Repo.PostulanteRepository;

import java.util.List;

public class PostulanteService {
    private PostulanteRepository postulanteRepository;

    public PostulanteService() {
        this.postulanteRepository = new PostulanteRepository();
    }

    public void guardarPostulante(String nombre, String email, String telefono, String direccion, String experiencia, String educacion, String habilidades) {
        postulanteRepository.guardarPostu(nombre, email, telefono, direccion, experiencia, educacion, habilidades);
    }
    public List<String[]> mostrarPostulantes() {
        return postulanteRepository.obtenerPostulantes();
    }
}


