package co.com.udea.jpa.Usuario;

import co.com.udea.jpa.helper.AdapterOperations;
import co.com.udea.model.usuario.Usuario;
import co.com.udea.model.usuario.gateways.UsuarioRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.stream.Collectors;
import java.util.List;

@Repository
public class UsuarioRepositoryAdapter
        extends AdapterOperations<Usuario, UsuarioData, Integer, UsuarioDataRepository>
        implements UsuarioRepository
{

    public UsuarioRepositoryAdapter(UsuarioDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Usuario.class));
    }

    @Override
    public List<Usuario> findAll() {
        return this.repository.findAll().stream().map(this::toEntity).collect(Collectors.toList());
    }

    public Usuario findByCedula(String cedula) {
        return this.toEntity(this.repository.findByCedula(cedula));
    }
}
