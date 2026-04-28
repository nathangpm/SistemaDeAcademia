package fiap.com.br.SistemaDeAcademia.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "tb_plano")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Plano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Column(nullable = false)
    private String nome;

    @NotNull(message = "Preço é obrigatório")
    @Positive(message = "Preço deve ser positivo")
    @Column(nullable = false)
    private Double preco;

    @NotNull(message = "Duração é obrigatória")
    @Positive(message = "Duração deve ser positiva")
    @Column(nullable = false)
    private Integer duracaoDias;

    private String descricao;
}