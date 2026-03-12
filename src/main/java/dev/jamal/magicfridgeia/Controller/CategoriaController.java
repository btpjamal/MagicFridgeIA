package dev.jamal.magicfridgeia.Controller;

import dev.jamal.magicfridgeia.DTO.CategoriaDTO;
import dev.jamal.magicfridgeia.Service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    // Post Mapping
    @PostMapping("/create")
    public ResponseEntity<CategoriaDTO> createCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        categoriaDTO= categoriaService.createCategoria(categoriaDTO);
        return ResponseEntity.ok(categoriaDTO);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<CategoriaDTO> readcategoria(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.getCategoriaById(id));
    }

    @GetMapping("/read/all")
    public ResponseEntity<List<CategoriaDTO>> readAllcategorias() {
        return ResponseEntity.ok(categoriaService.getAllCategorias()) ;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CategoriaDTO> updatecategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) {
        categoriaDTO= categoriaService.updateCategoria(id, categoriaDTO);
        return ResponseEntity.ok(categoriaDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletecategoria(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
        return ResponseEntity.noContent().build();
    }
}
