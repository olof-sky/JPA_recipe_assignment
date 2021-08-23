package com.skylan.jpa_recipe_assignment;

import com.skylan.jpa_recipe_assignment.model.entity.*;

import java.util.Arrays;
import java.util.List;

public class TestObjectGenerator{

    public List<Ingredient> ingredients(){
        return Arrays.asList(
                new Ingredient(0, "lök"),
                new Ingredient(0, "bönor")
        );
    }

    public List<Recipe> recipe(){
        return Arrays.asList(
                new Recipe(0, "recipe1", null, null, null),
                new Recipe(0, "recipe2", null, null, null),
                new Recipe(0, "recipe3", null, null, null),
                new Recipe(0, "recipe4", null, null, null)
        );
    }

    public List<RecipeIngredient> recipeIngredients(){
        return Arrays.asList(
                new RecipeIngredient(null, null, 1.0, Measurement.ST, null),
                new RecipeIngredient(null, null, 1.0, Measurement.ST, null),
                new RecipeIngredient(null, null, 1.0, Measurement.ST, null),
                new RecipeIngredient(null, null, 1.0, Measurement.ST, null)
        );
    }

    public List<RecipeCategory> recipeCategory(){
        return Arrays.asList(
                new RecipeCategory(0, "Burkmat", null),
                new RecipeCategory(0, "Billig mat", null)
        );
    }

    public List<RecipeInstruction> recipeInstruction(){
        return Arrays.asList(
                new RecipeInstruction(null, "Blanda och njut"),
                new RecipeInstruction(null, "Blanda och njut")
        );
    }
}
