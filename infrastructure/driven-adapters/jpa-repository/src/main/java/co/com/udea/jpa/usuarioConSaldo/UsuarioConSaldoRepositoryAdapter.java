package co.com.udea.jpa.usuarioConSaldo;

import co.com.udea.jpa.Usuario.UsuarioDataRepository;
import co.com.udea.jpa.helper.AdapterOperations;

import co.com.udea.model.usuario.Usuario;
import co.com.udea.model.usuarioconsaldo.UsuarioConSaldo;
import co.com.udea.model.usuarioconsaldo.gateways.UsuarioConSaldoRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioConSaldoRepositoryAdapter
        extends AdapterOperations<UsuarioConSaldo, UsuarioConSaldoData, Integer, UsuarioConSaldoDataRepository>
        implements UsuarioConSaldoRepository {

    public UsuarioConSaldoRepositoryAdapter(UsuarioConSaldoDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, UsuarioConSaldo.class));
    }

    public UsuarioConSaldo findUsuariosConSaldo(String cedula, Integer numCuenta) {
        return this.toEntity(this.repository.findUsuariosConSaldo(cedula, numCuenta));
    }
}
