package dev.jamal.magicfridgeia.Mapper;

import dev.jamal.magicfridgeia.DTO.CategoriaDTO;
import dev.jamal.magicfridgeia.Model.CategoriaModel;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

    // Converte de Model para DTO
    public static CategoriaDTO toDTO(CategoriaModel categoriaModel) {
        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(categoriaModel.getId());
        dto.setNome(categoriaModel.getNome());
        dto.setFoodModelList(categoriaModel.getFoodModelList());
        return dto;
    }

    // Converte de DTO para Model
    public static CategoriaModel toModel(CategoriaDTO dto) {
        CategoriaModel categoriaModel = new CategoriaModel();
        categoriaModel.setId(dto.getId());
        categoriaModel.setNome(dto.getNome());
        categoriaModel.setFoodModelList(dto.getFoodModelList());
        return categoriaModel;
    }

}
