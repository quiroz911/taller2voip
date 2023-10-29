package co.com.udea.model.cuenta.gateways;


import co.com.udea.model.cuenta.Cuenta;

import java.util.List;

public interface CuentaRepository {
    List<Cuenta> findByCedula(String cedula);
    List<Cuenta> findAll();
    void updateSaldoByCedula(String cedula, Double monto);
}
