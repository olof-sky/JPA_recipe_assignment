package com.skylan.jpa_recipe_assignment.service.conversion;

import com.skylan.jpa_recipe_assignment.model.dto.IngredientDTO;
import com.skylan.jpa_recipe_assignment.model.entity.Ingredient;
import org.springframework.stereotype.Service;

@Service
public class IngredientFactory {
    public Ingredient CreateFromDTO(IngredientDTO ingredientDTO){
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientName(ingredientDTO.getIngredientName() == null ? null : ingredientDTO.getIngredientName().trim());
        return ingredient;
    }
}
