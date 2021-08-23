package com.skylan.jpa_recipe_assignment.dao;

import com.skylan.jpa_recipe_assignment.model.entity.RecipeInstruction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeInstructionDAO extends JpaRepository<RecipeInstruction, String> {
}
