package com.skylan.jpa_recipe_assignment.service.conversion;

import com.skylan.jpa_recipe_assignment.model.dto.RecipeIngredientDTO;
import com.skylan.jpa_recipe_assignment.model.entity.RecipeIngredient;
import org.springframework.stereotype.Service;

@Service
public class RecipeIngredientFactory {
    public RecipeIngredient CreateFromDTO(RecipeIngredientDTO recipeIngredientDTO){
        RecipeIngredient recipeIngredient = new RecipeIngredient();
        recipeIngredient.setRecipeIngredientId(recipeIngredientDTO.getRecipeIngredientId());
        recipeIngredient.setIngredient(recipeIngredientDTO.getIngredient() == null ? null : recipeIngredientDTO.getIngredient());
        recipeIngredient.setAmount(recipeIngredientDTO.getAmount() == null ? null : recipeIngredientDTO.getAmount());
        recipeIngredient.setMeasurement(recipeIngredientDTO.getMeasurement() == null ? null : recipeIngredientDTO.getMeasurement());
        recipeIngredient.setRecipe(recipeIngredientDTO.getRecipe() == null ? null : recipeIngredientDTO.getRecipe());
        return recipeIngredient;
    }
}
