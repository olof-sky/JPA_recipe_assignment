package com.skylan.jpa_recipe_assignment;

import com.skylan.jpa_recipe_assignment.models.*;

import java.util.Arrays;
import java.util.List;

public class TestObjectGenerator{

    public List<Ingredient> ingredients(){
        return Arrays.asList(
                new Ingredient(0, "lök"),
                new Ingredient(1, "bönor")
        );
    }

    public List<Recipe> recipe(){
        return Arrays.asList(
                new Recipe(0, "recipe1", null, null, null),
                new Recipe(1, "recipe2", null, null, null),
                new Recipe(2, "recipe3", null, null, null),
                new Recipe(3, "recipe4", null, null, null)
        );
    }

    public List<RecipeIngredient> recipeIngredients(){
        return Arrays.asList(
                new RecipeIngredient("UUID1", null, 1.0, Measurement.ST, null),
                new RecipeIngredient("UUID2", null, 1.0, Measurement.ST, null),
                new RecipeIngredient("UUID3", null, 1.0, Measurement.ST, null),
                new RecipeIngredient("UUID4", null, 1.0, Measurement.ST, null)
        );
    }

    public List<RecipeCategory> recipeCategory(){
        return Arrays.asList(
                new RecipeCategory(0, "Burkmat", null),
                new RecipeCategory(1, "Billig mat", null)
        );
    }

    public List<RecipeInstruction> recipeInstruction(){
        return Arrays.asList(
                new RecipeInstruction("UUID1", "Blanda och njut"),
                new RecipeInstruction("UUID2", "Blanda och njut")
        );
    }
}
