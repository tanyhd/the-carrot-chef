package com.theCarrotChef.recipeSearch.external.edamam;

import com.theCarrotChef.recipeSearch.model.RecipeResponseOverview;
import feign.Param;
import feign.RequestLine;


public interface EdamamApi {

    @RequestLine("GET /api/recipes/v2?type=public&q={food}&app_id={appId}&app_key={appKey}")
    RecipeResponseOverview getRecipe(
            @Param("food") String food,
            @Param("appId") String appId,
            @Param("appKey") String appKey
    );

}
