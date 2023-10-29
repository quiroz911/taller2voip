package co.com.udea.model.usuarioconsaldo;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class UsuarioConSaldo {
    private Integer idCuenta;

    private Integer cedula;

    private String tipo;

    private Double saldo;
}
