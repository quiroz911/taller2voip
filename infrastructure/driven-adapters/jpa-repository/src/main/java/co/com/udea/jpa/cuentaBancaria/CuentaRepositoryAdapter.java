package co.com.udea.jpa.cuentaBancaria;

import co.com.udea.jpa.helper.AdapterOperations;
import co.com.udea.model.cuenta.Cuenta;
import co.com.udea.model.cuenta.gateways.CuentaRepository;
import jakarta.transaction.Transactional;
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

    @Transactional
    @Override
    public void updateSaldoByCedula(String cedula, Double monto) {
        CuentaData cuentaData = this.repository.findByCedula(cedula).get(0);
        if(cuentaData.getSaldo() - Math.abs(monto)< 0 && monto < 0){
            throw new RuntimeException("Saldo insuficiente");
        }
        this.repository.updateSaldoByCedula(monto, cedula);
    }

    @Transactional
    public void transferenciaByCedula(String cedulaOrigen, String cedulaDestino, Double monto){
        CuentaData cuentaData = this.repository.findByCedula(cedulaOrigen).get(0);
        if(cuentaData.getSaldo() - monto< 0){
            throw new RuntimeException("Saldo insuficiente");
        }
        this.repository.updateSaldoByCedula(-monto, cedulaOrigen);
        this.repository.updateSaldoByCedula(monto, cedulaDestino);
    }

}
