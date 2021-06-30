package com.skylan.jpa_recipe_assignment.dao;

import com.skylan.jpa_recipe_assignment.models.RecipeInstruction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeInstructionDAO extends JpaRepository<RecipeInstruction, String> {
}
