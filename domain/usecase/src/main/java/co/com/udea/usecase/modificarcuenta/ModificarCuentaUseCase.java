package co.com.udea.usecase.modificarcuenta;

import co.com.udea.model.cuenta.gateways.CuentaRepository;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class ModificarCuentaUseCase {
    private final CuentaRepository cuentaRepository;
    public void modificarSaldoCuentaByCedula(String cedula, Double monto) {
        cuentaRepository.updateSaldoByCedula(cedula, monto);
    }
}
