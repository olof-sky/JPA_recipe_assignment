package com.skylan.jpa_recipe_assignment.dao;

import com.skylan.jpa_recipe_assignment.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IngredientDAO extends JpaRepository<Ingredient, Integer> {
    List<Ingredient> findIngredientByIngredientName(String ingredientName);
    List<Ingredient> findIngredientsByIngredientNameContaining(String ingredientName);
}
