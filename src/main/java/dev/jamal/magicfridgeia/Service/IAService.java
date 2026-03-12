package dev.jamal.magicfridgeia.Service;


import dev.jamal.magicfridgeia.DTO.FoodDTO;
import org.springframework.stereotype.Service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IAService {

    private final Client client = new Client();
    private final FoodService foodService;

    public IAService(FoodService foodService) {
        this.foodService = foodService;
    }

    public String generateRecipe(){
        List<FoodDTO> listaAlimentos = foodService.getAll();

        // Monta uma string legível com os ingredientes
        String ingredientes = listaAlimentos.stream()
                .map(FoodDTO::getNome)
                .collect(Collectors.joining(", "));

        String prompt = "Com base nos seguintes ingredientes disponíveis: " + listaAlimentos +
                ", sugira uma receita simples e saborosa.";


        GenerateContentResponse response = client.models.generateContent(
                        "gemini-2.5-flash",
                        prompt,
                        null
        );
        return response.text();
    }
}
