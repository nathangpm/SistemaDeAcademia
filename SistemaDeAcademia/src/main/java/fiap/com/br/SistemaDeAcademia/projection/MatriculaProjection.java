package fiap.com.br.SistemaDeAcademia.projection;

import java.time.LocalDate;

public interface MatriculaProjection {
    Long getId();
    LocalDate getDataInicio();
    LocalDate getDataVencimento();
    String getStatus();
}