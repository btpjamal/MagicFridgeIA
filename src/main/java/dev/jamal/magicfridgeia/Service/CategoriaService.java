package dev.jamal.magicfridgeia.Service;

import dev.jamal.magicfridgeia.DTO.CategoriaDTO;
import dev.jamal.magicfridgeia.Mapper.CategoriaMapper;
import dev.jamal.magicfridgeia.Model.CategoriaModel;
import dev.jamal.magicfridgeia.Repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    public final CategoriaMapper categoriaMapper;
    public final CategoriaRepository categoriaRepository;


    public CategoriaService(CategoriaMapper categoriaMapper, CategoriaRepository categoriaRepository) {
        this.categoriaMapper = categoriaMapper;
        this.categoriaRepository = categoriaRepository;
    }


    // Create
    public CategoriaDTO createCategoria(CategoriaDTO categoriaDTO) {
        CategoriaModel categoriaModel = categoriaMapper.toModel(categoriaDTO);
        CategoriaModel savedCategoria = categoriaRepository.save(categoriaModel);
        return categoriaMapper.toDTO(savedCategoria);
    }

    // Read by ID
    public CategoriaDTO getCategoriaById(Long id) {
        CategoriaModel categoriaModel = categoriaRepository.findById(id).orElse(null);
        return categoriaMapper.toDTO(categoriaModel);
    }

    // Read all
    public List<CategoriaDTO> getAllCategorias() {
        List<CategoriaModel> categorias = categoriaRepository.findAll();
        return categorias.stream()
                .map(CategoriaMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Update
    public CategoriaDTO updateCategoria(Long id, CategoriaDTO categoriaDTO) {
        CategoriaModel existingCategoria = categoriaRepository.findById(id).orElse(null);
        if (existingCategoria != null) {
            existingCategoria.setNome(categoriaDTO.getNome());
            CategoriaModel updatedCategoria = categoriaRepository.save(existingCategoria);
            return CategoriaMapper.toDTO(updatedCategoria);
        }
        return null;
    }

    // Delete
    public void deleteCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}
