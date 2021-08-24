package com.skylan.jpa_recipe_assignment.dao;

import com.skylan.jpa_recipe_assignment.model.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
public interface RecipeDAO extends JpaRepository<Recipe, Integer> {
    @Query("SELECT r.recipeName FROM Recipe r WHERE (r.recipeName) = :name")
    String findRecipeByRecipeName(@Param("name") String name);
    List<Recipe> findByRecipeNameIgnoreCase(String recipeName);
    List<Recipe> findRecipeByRecipeIngredientsIngredientIngredientNameIgnoreCase(String ingredientName);
    List<Recipe> findByCategoriesRecipeCategoryName(String categoryName);
    @Query("SELECT r FROM Recipe r WHERE SIZE(r.categories) > 1")
    List<Recipe> findByCategoriesRecipeCategoriesSizeGreaterThenOne();
    @Query("SELECT DISTINCT r FROM Recipe r JOIN r.categories category1 JOIN r.categories category2 WHERE category1.recipeCategoryName = :category1 AND category2.recipeCategoryName = :category2")
    List<Recipe> findByMultipleCategories(
            @Param("category1") String category1,
            @Param("category2") String category2
    );
}