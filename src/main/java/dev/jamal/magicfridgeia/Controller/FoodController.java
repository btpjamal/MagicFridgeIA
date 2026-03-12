package dev.jamal.magicfridgeia.Controller;

import dev.jamal.magicfridgeia.DTO.FoodDTO;
import dev.jamal.magicfridgeia.Service.FoodService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    private FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping("/create")
    public ResponseEntity<FoodDTO> create(@RequestBody FoodDTO foodDTO){
        FoodDTO newFood= foodService.create(foodDTO);
        return ResponseEntity.ok(newFood);
    }

    @GetMapping("/readAll")
    public ResponseEntity<List<FoodDTO>> listar(){
        List<FoodDTO> lista = foodService.getAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<FoodDTO> listarID(@PathVariable Long id){
        FoodDTO foodListedByID =  foodService.getById(id);
        return ResponseEntity.ok(foodListedByID);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FoodDTO> atualizar(@RequestBody FoodDTO foodDTO, @PathVariable Long id){
        foodDTO = foodService.update(id, foodDTO);
        return ResponseEntity.ok(foodDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        foodService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
