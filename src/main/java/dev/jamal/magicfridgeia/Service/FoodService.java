package dev.jamal.magicfridgeia.Service;

import dev.jamal.magicfridgeia.DTO.FoodDTO;
import dev.jamal.magicfridgeia.Mapper.FoodMapper;
import dev.jamal.magicfridgeia.Model.FoodModel;
import dev.jamal.magicfridgeia.Repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodService {

    public final FoodMapper foodMapper;
    public final FoodRepository foodRepository;


    public FoodService(FoodMapper foodMapper, FoodRepository foodRepository) {
        this.foodMapper = foodMapper;
        this.foodRepository = foodRepository;
    }

    // Create
    public FoodDTO create(FoodDTO foodDTO) {
        FoodModel foodModel = foodMapper.toModel(foodDTO);
        FoodModel savedProduto = foodRepository.save(foodModel);
        return foodMapper.toDTO(savedProduto);
    }

    // Read by ID
    public FoodDTO getById(Long id) {
        FoodModel foodModel = foodRepository.findById(id).orElse(null);
        return FoodMapper.toDTO(foodModel);
    }

    // Read all
    public List<FoodDTO> getAll() {
        List<FoodModel> produtos = foodRepository.findAll();
        return produtos.stream()
                .map(FoodMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Update
    public FoodDTO update(Long id, FoodDTO foodDTO) {
        FoodModel existingProduto = foodRepository.findById(id).orElse(null);
        if (existingProduto != null) {
            existingProduto.setNome(foodDTO.getNome());
            existingProduto.setQuantidade(foodDTO.getQuantidade());
            existingProduto.setValidade(foodDTO.getValidade());
            FoodModel updatedProduto = foodRepository.save(existingProduto);
            return FoodMapper.toDTO(updatedProduto);
        }
        return null;
    }

    // Delete
    public void delete(Long id) {
        foodRepository.deleteById(id);
    }
}
