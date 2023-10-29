package co.com.udea.jpa.Usuario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface UsuarioDataRepository
        extends CrudRepository<UsuarioData, Integer>, QueryByExampleExecutor<UsuarioData> {

    List<UsuarioData> findAll();

    UsuarioData findByCedula(String cedula);
}
