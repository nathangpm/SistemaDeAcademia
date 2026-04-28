package fiap.com.br.SistemaDeAcademia.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_treino")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Column(nullable = false)
    private String nome;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    @NotNull(message = "Aluno é obrigatório")
    private Aluno aluno;

    @OneToMany(mappedBy = "treino", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Exercicio> exercicios;
}