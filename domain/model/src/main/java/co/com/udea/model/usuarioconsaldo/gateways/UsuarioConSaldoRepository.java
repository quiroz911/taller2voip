package co.com.udea.model.usuarioconsaldo.gateways;

import co.com.udea.model.usuarioconsaldo.UsuarioConSaldo;

import java.util.List;

public interface UsuarioConSaldoRepository {
    UsuarioConSaldo findUsuariosConSaldo(String cedula, Integer numCuenta);
}
