package dev.jamal.magicfridgeia.DTO;

import dev.jamal.magicfridgeia.Model.CategoriaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FoodDTO {

    private Long id;

    private String nome;

    private Integer quantidade;

    private LocalDate validade;

    private Long categoriaID; // transita apenas o ID da categoria

}
