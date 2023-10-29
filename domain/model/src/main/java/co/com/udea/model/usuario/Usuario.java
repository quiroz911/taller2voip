package co.com.udea.model.usuario;
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
public class Usuario {
    private Integer id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String email;
    private String direccion;
}
