package co.com.udea.jpa.usuarioConSaldo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface UsuarioConSaldoDataRepository
        extends CrudRepository<UsuarioConSaldoData, Integer>, QueryByExampleExecutor<UsuarioConSaldoData> {

    @Query(value = "select u.cedula, cb.id, cb.tipo, cb.saldo from usuario u join cuenta_bancaria cb on u.id = cb.id_usuario "
    + "where u.cedula = :cedula and cb.id = :numCuenta", nativeQuery = true)
    UsuarioConSaldoData findUsuariosConSaldo(@Param("cedula") String cedula, @Param("numCuenta") Integer numCuenta);
}

