package com.skylan.jpa_recipe_assignment.dao;

import com.skylan.jpa_recipe_assignment.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface RecipeDAO extends JpaRepository<Recipe, Integer> {
    List<Recipe> findByRecipeNameIgnoreCase(String recipeName);
    List<Recipe> findByRecipeIngredientsIngredientIngredientNameIgnoreCase(String ingredientName);
    List<Recipe> findByCategoriesRecipeCategoryName(String categoryName);
    @Query("SELECT r FROM Recipe r WHERE SIZE(r.categories) > 1")
    List<Recipe> findByCategoriesRecipeCategoriesSizeGreaterThenOne();
}