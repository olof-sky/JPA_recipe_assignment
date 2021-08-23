package com.skylan.jpa_recipe_assignment.service.conversion;

import com.skylan.jpa_recipe_assignment.model.dto.RecipeInstructionDTO;
import com.skylan.jpa_recipe_assignment.model.entity.RecipeInstruction;
import org.springframework.stereotype.Service;

@Service
public class RecipeInstructionFactory {
    public RecipeInstruction CreateFromDTO(RecipeInstructionDTO recipeInstructionDTO) {
        RecipeInstruction recipeInstruction = new RecipeInstruction();
        recipeInstruction.setRecipeInstructionId(recipeInstructionDTO.getRecipeInstructionId());
        recipeInstruction.setRecipeInstruction(recipeInstructionDTO.getRecipeInstruction() == null ? null : recipeInstruction.getRecipeInstruction());
        return recipeInstruction;
    }
}

