package dev.jamal.magicfridgeia.Controller;

import dev.jamal.magicfridgeia.Service.IAService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RecipeController {

    private IAService iAService;


    public RecipeController(IAService iAService) {
        this.iAService = iAService;
    }

    @GetMapping("/generate")
    public String iAresponse(){
        return iAService.generateRecipe();
    }

}
