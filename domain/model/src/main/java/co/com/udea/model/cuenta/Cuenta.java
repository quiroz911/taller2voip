package co.com.udea.model.cuenta;
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
public class Cuenta {
    private String id;
    private String idUsuario;
    private String tipo;
    private double saldo;
}
