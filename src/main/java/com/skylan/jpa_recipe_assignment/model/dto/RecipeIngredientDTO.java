package com.skylan.jpa_recipe_assignment.model.dto;

import com.skylan.jpa_recipe_assignment.model.entity.Ingredient;
import com.skylan.jpa_recipe_assignment.model.entity.Measurement;
import com.skylan.jpa_recipe_assignment.model.entity.Recipe;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class RecipeIngredientDTO implements Serializable {
    private String recipeIngredientId;
    private Ingredient ingredient;
    private Double amount;
    private Measurement measurement;
    private Recipe recipe;
}
