package co.com.udea.usecase.consultarusuarios;

import co.com.udea.model.usuario.Usuario;
import co.com.udea.model.usuario.gateways.UsuarioRepository;
import co.com.udea.model.usuarioconsaldo.UsuarioConSaldo;
import co.com.udea.model.usuarioconsaldo.gateways.UsuarioConSaldoRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ConsultarUsuariosUseCase {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConSaldoRepository usuarioConSaldoRepository;

    public List<Usuario> consultarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario consultarUsuario(String cedula) {
        return usuarioRepository.findByCedula(cedula);
    }

    public UsuarioConSaldo consultarUsuarioConSaldo(String cedula, Integer numCuenta) {
        return usuarioConSaldoRepository.findUsuariosConSaldo(cedula, numCuenta);
    }
}
