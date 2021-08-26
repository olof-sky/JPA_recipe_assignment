package com.skylan.jpa_recipe_assignment.dao;

import com.skylan.jpa_recipe_assignment.model.entity.Ingredient;
import com.skylan.jpa_recipe_assignment.model.entity.RecipeInstruction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeInstructionDAO extends JpaRepository<RecipeInstruction, String> {
    String findByRecipeInstruction(String recipeInstruction);
}
