package dev.jamal.magicfridgeia.Mapper;

import dev.jamal.magicfridgeia.DTO.FoodDTO;
import dev.jamal.magicfridgeia.Model.FoodModel;
import org.springframework.stereotype.Component;

@Component
public class FoodMapper {


    // Converte de Model para DTO
    public static FoodDTO toDTO(FoodModel foodModel) {
        FoodDTO foodDTO = new FoodDTO();
        foodDTO.setId(foodModel.getId());
        foodDTO.setNome(foodModel.getNome());
        foodDTO.setQuantidade(foodModel.getQuantidade());
        foodDTO.setValidade(foodModel.getValidade());
        foodDTO.setCategoriaID(foodModel.getCategoria().getId());
        return foodDTO;
    }

    // Converte de DTO para Model
    public static FoodModel toModel(FoodDTO dto) {
        FoodModel foodModel = new FoodModel();
        foodModel.setId(dto.getId());
        foodModel.setNome(dto.getNome());
        foodModel.setQuantidade(dto.getQuantidade());
        foodModel.setValidade(dto.getValidade());
        foodModel.setCategoria(dto.getCategoriaID());
        return foodModel;
    }

}
