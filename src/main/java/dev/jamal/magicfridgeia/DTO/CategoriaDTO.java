package dev.jamal.magicfridgeia.DTO;

import dev.jamal.magicfridgeia.Model.FoodModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoriaDTO {

    private Long id;

    private String nome;

    private List<FoodModel> foodModelList;

}
