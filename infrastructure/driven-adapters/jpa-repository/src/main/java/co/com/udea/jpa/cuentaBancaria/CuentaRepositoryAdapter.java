package co.com.udea.jpa.cuentaBancaria;

import co.com.udea.jpa.helper.AdapterOperations;
import co.com.udea.model.cuenta.Cuenta;
import co.com.udea.model.cuenta.gateways.CuentaRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CuentaRepositoryAdapter
        extends AdapterOperations<Cuenta, CuentaData, Integer, CuentaDataRepository>
        implements CuentaRepository
{

    public CuentaRepositoryAdapter(CuentaDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Cuenta.class));
    }

    public List<Cuenta> findByCedula(String cedula) {
        return this.repository.findByCedula(cedula).stream().map(this::toEntity).collect(Collectors.toList());
    }
    @Override
    public List<Cuenta> findAll() {
        return this.repository.findAll().stream().map(this::toEntity).collect(Collectors.toList());
    }
}
