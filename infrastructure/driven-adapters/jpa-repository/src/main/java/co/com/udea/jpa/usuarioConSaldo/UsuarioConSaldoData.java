package co.com.udea.jpa.usuarioConSaldo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UsuarioConSaldoData {

    @Id
    @Column(name = "id")
    private Integer idCuenta;

    @Column(name = "cedula")
    private Integer cedula;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "saldo")
    private Double saldo;
}
