package com.skylan.jpa_recipe_assignment.service.conversion;


import com.skylan.jpa_recipe_assignment.model.dto.RecipeDTO;
import com.skylan.jpa_recipe_assignment.model.entity.Recipe;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RecipeFactory {
    public Recipe CreateFromDTO(RecipeDTO recipeDTO){
        Recipe recipe = new Recipe();
        recipe.setRecipeName(recipeDTO.getRecipeName() == null ? null : recipeDTO.getRecipeName().trim());
        recipe.setRecipeIngredients(recipeDTO.getRecipeIngredients() == null ? new ArrayList<>() : recipeDTO.getRecipeIngredients());
        recipe.setRecipeInstruction(recipeDTO.getRecipeInstruction() == null ? null : recipeDTO.getRecipeInstruction());
        recipe.setCategories(recipeDTO.getCategories() == null ? new ArrayList<>() : recipeDTO.getCategories());
        return recipe;
    }
}
