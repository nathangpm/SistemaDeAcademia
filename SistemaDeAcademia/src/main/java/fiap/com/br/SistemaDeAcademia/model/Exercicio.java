package fiap.com.br.SistemaDeAcademia.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "tb_exercicio")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Column(nullable = false)
    private String nome;

    @NotBlank(message = "Grupo muscular é obrigatório")
    @Column(nullable = false)
    private String grupoMuscular;

    @NotNull(message = "Séries é obrigatório")
    @Positive(message = "Séries deve ser positivo")
    private Integer series;

    @NotNull(message = "Repetições é obrigatório")
    @Positive(message = "Repetições deve ser positivo")
    private Integer repeticoes;

    private String observacao;

    @ManyToOne
    @JoinColumn(name = "treino_id", nullable = false)
    @NotNull(message = "Treino é obrigatório")
    private Treino treino;
}