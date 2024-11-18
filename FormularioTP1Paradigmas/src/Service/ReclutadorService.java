package Service;

import Repo.ReclutadorRepository;

public class ReclutadorService {
    private ReclutadorRepository reclutadorRepository;

    public ReclutadorService() {
        this.reclutadorRepository = new ReclutadorRepository();
    }

    public boolean iniciarSesion(String email, String contrasena) {
        return reclutadorRepository.verificarMailContra(email, contrasena);
    }
}
