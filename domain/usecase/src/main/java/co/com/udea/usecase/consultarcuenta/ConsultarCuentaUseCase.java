package co.com.udea.usecase.consultarcuenta;

import co.com.udea.model.cuenta.Cuenta;
import co.com.udea.model.cuenta.gateways.CuentaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ConsultarCuentaUseCase {
    private final CuentaRepository cuentaRepository;

    public List<Cuenta> consultarCuentas() {
        return cuentaRepository.findAll();
    }

    public List<Cuenta> consultarCuentasByCedula(String cedula) {
        return cuentaRepository.findByCedula(cedula);
    }
}
