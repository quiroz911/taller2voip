package co.com.udea.model.usuario.gateways;

import co.com.udea.model.usuario.Usuario;

import java.util.List;

public interface UsuarioRepository {
    List<Usuario> findAll();
    Usuario findByCedula(String cedula);
}
