package com.theCarrotChef.recipeSearch.controller;

import com.theCarrotChef.recipeSearch.model.RecipeResponseOverview;
import com.theCarrotChef.recipeSearch.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class RecipesController {

    private final RecipeService recipeService;

    public RecipesController(
            RecipeService recipeService
    ) {
        this.recipeService = recipeService;
    }

    @GetMapping(path="/api/recipes/{food}")
    public CompletableFuture<ResponseEntity<RecipeResponseOverview>> getRecipes(@PathVariable String food) {
        return recipeService.getRecipe(food).thenApply(ResponseEntity::ok);
    }
}
