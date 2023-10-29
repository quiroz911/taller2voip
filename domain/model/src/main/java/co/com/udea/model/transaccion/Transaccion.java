package co.com.udea.model.transaccion;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Transaccion {
    private String id;
    private String idCuentaOrigen;
    private String idCuentaDestino;
    private double monto;
    private LocalDate fecha;
}
