package com.skylan.jpa_recipe_assignment.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientDTO implements Serializable {
    private Integer ingredientId;
    private String ingredientName;
}
