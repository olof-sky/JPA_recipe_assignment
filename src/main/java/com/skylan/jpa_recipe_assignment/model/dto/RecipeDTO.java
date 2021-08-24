package com.skylan.jpa_recipe_assignment.model.dto;

import com.skylan.jpa_recipe_assignment.model.entity.RecipeCategory;
import com.skylan.jpa_recipe_assignment.model.entity.RecipeIngredient;
import com.skylan.jpa_recipe_assignment.model.entity.RecipeInstruction;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RecipeDTO implements Serializable {
    private int recipeId;
    private String recipeName;
    private List<RecipeIngredient> recipeIngredients;
    private RecipeInstruction recipeInstruction;
    private List<RecipeCategory> categories;
}
