package com.skylan.jpa_recipe_assignment.service.conversion;

import com.skylan.jpa_recipe_assignment.model.dto.RecipeCategoryDTO;
import com.skylan.jpa_recipe_assignment.model.entity.RecipeCategory;
import org.springframework.stereotype.Service;

@Service
public class RecipeCategoryFactory {
    public RecipeCategory CreateFromDTO(RecipeCategoryDTO recipeCategoryDTO){
        RecipeCategory recipeCategory = new RecipeCategory();
        recipeCategory.setRecipeCategoryId(recipeCategoryDTO.getRecipeCategoryId());
        recipeCategory.setRecipeCategoryName(recipeCategoryDTO.getRecipeCategoryName() == null ? null : recipeCategoryDTO.getRecipeCategoryName().trim());
        return recipeCategory;
    }
}
