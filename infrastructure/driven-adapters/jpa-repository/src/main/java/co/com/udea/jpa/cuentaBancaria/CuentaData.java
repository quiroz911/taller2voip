package co.com.udea.jpa.cuentaBancaria;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cuenta_bancaria")
public class CuentaData {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "saldo")
    private Double saldo;


}
