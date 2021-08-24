package com.skylan.jpa_recipe_assignment.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class IngredientDTO implements Serializable {
    private Integer IngredientId;
    private String IngredientName;
}
