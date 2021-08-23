package com.skylan.jpa_recipe_assignment.dao;

import com.skylan.jpa_recipe_assignment.model.entity.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeIngredientDAO extends JpaRepository<RecipeIngredient, String> {
}
