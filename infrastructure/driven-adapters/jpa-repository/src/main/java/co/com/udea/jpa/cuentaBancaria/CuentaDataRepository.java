package co.com.udea.jpa.cuentaBancaria;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface CuentaDataRepository
        extends CrudRepository<CuentaData, Integer>, QueryByExampleExecutor<CuentaData> {


    List<CuentaData> findAll();
    @Query(value = "select * from cuenta_bancaria cb  where id_usuario = (select id from usuario u where cedula = :cedula)", nativeQuery = true)
    List<CuentaData> findByCedula(@Param("cedula") String cedula);
}
