package co.com.udea.api;
import co.com.udea.model.cuenta.Cuenta;
import co.com.udea.model.usuario.Usuario;
import co.com.udea.model.usuarioconsaldo.UsuarioConSaldo;
import co.com.udea.usecase.consultarcuenta.ConsultarCuentaUseCase;
import co.com.udea.usecase.consultarusuarios.ConsultarUsuariosUseCase;
import co.com.udea.usecase.modificarcuenta.ModificarCuentaUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final ConsultarUsuariosUseCase consultarUsuariosUseCase;
    private final ConsultarCuentaUseCase consultarCuentaUseCase;
    private final ModificarCuentaUseCase modificarCuentaUseCase;

    @GetMapping(path = "/usuarios")
    public List<Usuario> consultarUsuarios() {
        return consultarUsuariosUseCase.consultarUsuarios();
    }

    //método para consultar un usuario por cedula
    @GetMapping(path = "/usuario/{cedula}")
    public ResponseEntity<Usuario> consultarUsuario(@PathVariable("cedula") String cedula) {
        if(cedula == null || cedula.isEmpty())
            throw new IllegalArgumentException("La cedula no puede ser nula ni vacia");
        Usuario usuario = consultarUsuariosUseCase.consultarUsuario(cedula);
        if(usuario != null)
        return ResponseEntity.ok().body(usuario);
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/usuario/{cedula}/cuenta/{cuenta}")
    public ResponseEntity<UsuarioConSaldo> consultarUsuarioConSaldo(@PathVariable("cedula") String cedula, @PathVariable("cuenta") Integer cuenta) {
        if(cedula == null || cedula.isEmpty())
            throw new IllegalArgumentException("La cedula no puede ser nula ni vacia");
        if(cuenta == null)
            throw new IllegalArgumentException("El numero de cuenta no puede ser nulo");
        UsuarioConSaldo usuarioConSaldo = consultarUsuariosUseCase.consultarUsuarioConSaldo(cedula, cuenta);
        if(usuarioConSaldo != null)
            return ResponseEntity.ok().body(usuarioConSaldo);
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/usuario/{cedula}/cuentas")
    public ResponseEntity<List<Cuenta>> consultarCuentasByCedula(@PathVariable("cedula") String cedula) {
        if(cedula == null || cedula.isEmpty())
            throw new IllegalArgumentException("La cedula no puede ser nula ni vacia");
        List<Cuenta> cuentas = consultarCuentaUseCase.consultarCuentasByCedula(cedula);
        if(cuentas != null)
            return ResponseEntity.ok().body(cuentas);
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/cuentas")
    public List<Cuenta> consultarCuentas() {
        return consultarCuentaUseCase.consultarCuentas();
    }

    @PostMapping(path = "/updateSaldoByCedula/{cedula}/monto/{monto}")
    public ResponseEntity<String> updateSaldoByCedula(@PathVariable("cedula") String cedula, @PathVariable("monto") Double monto) {
        if(cedula == null || cedula.isEmpty())
            throw new IllegalArgumentException("La cedula no puede ser nula ni vacia");
        if(monto == null)
            throw new IllegalArgumentException("El monto no puede ser nulo");
        modificarCuentaUseCase.modificarSaldoCuentaByCedula(cedula, monto);
        return ResponseEntity.ok().body("Saldo actualizado");
    }

    @PostMapping(path = "/transferenciaByCedula/{cedulaOrigen}/cedulaDestino/{cedulaDestino}/monto/{monto}")
    public ResponseEntity<String> transferenciaByCedula(@PathVariable("cedulaOrigen") String cedulaOrigen, @PathVariable("cedulaDestino") String cedulaDestino, @PathVariable("monto") Double monto) {
        if(cedulaOrigen == null || cedulaOrigen.isEmpty())
            throw new IllegalArgumentException("La cedula origen no puede ser nula ni vacia");
        if(cedulaDestino == null || cedulaDestino.isEmpty())
            throw new IllegalArgumentException("La cedula destino no puede ser nula ni vacia");
        if(monto == null)
            throw new IllegalArgumentException("El monto no puede ser nulo");
        modificarCuentaUseCase.transferenciaByCedula(cedulaOrigen, cedulaDestino, monto);
        return ResponseEntity.ok().body("Transferencia realizada");
    }
}
