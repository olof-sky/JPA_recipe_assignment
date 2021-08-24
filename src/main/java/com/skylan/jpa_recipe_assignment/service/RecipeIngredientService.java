package com.skylan.jpa_recipe_assignment.service;

import com.skylan.jpa_recipe_assignment.dao.RecipeIngredientDAO;
import com.skylan.jpa_recipe_assignment.service.conversion.RecipeIngredientFactory;
import org.springframework.stereotype.Service;

@Service
public class RecipeIngredientService {
    private final RecipeIngredientDAO recipeIngredientDAO;
    private final RecipeIngredientFactory recipeIngredientFactory;

    public RecipeIngredientService(RecipeIngredientDAO recipeIngredientDAO, RecipeIngredientFactory recipeIngredientFactory) {
        this.recipeIngredientDAO = recipeIngredientDAO;
        this.recipeIngredientFactory = recipeIngredientFactory;
    }


}
