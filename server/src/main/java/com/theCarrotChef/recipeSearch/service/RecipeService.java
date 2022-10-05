package com.theCarrotChef.recipeSearch.service;

import com.theCarrotChef.recipeSearch.external.edamam.EdamamApi;
import com.theCarrotChef.recipeSearch.model.RecipeResponseOverview;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

import static com.theCarrotChef.recipeSearch.util.Constant.EDAMAM_APP_ID;
import static com.theCarrotChef.recipeSearch.util.Constant.EDAMAM_APP_KEY;

@Service
public class RecipeService {

    private final EdamamApi edamamApi;

    public RecipeService(
            EdamamApi edamamApi
    ) {
        this.edamamApi = edamamApi;
    }

    public CompletableFuture<RecipeResponseOverview> getRecipe(String food) {
        return CompletableFuture.supplyAsync(() -> edamamApi.getRecipe(food, EDAMAM_APP_ID, EDAMAM_APP_KEY));
    }
}
