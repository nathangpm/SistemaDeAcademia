package fiap.com.br.SistemaDeAcademia.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_matricula")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    @NotNull(message = "Aluno é obrigatório")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "plano_id", nullable = false)
    @NotNull(message = "Plano é obrigatório")
    private Plano plano;

    @Column(nullable = false)
    private LocalDate dataInicio = LocalDate.now();

    @Column(nullable = false)
    private LocalDate dataVencimento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusMatricula status = StatusMatricula.ATIVA;

    public enum StatusMatricula {
        ATIVA, INATIVA, SUSPENSA
    }
}