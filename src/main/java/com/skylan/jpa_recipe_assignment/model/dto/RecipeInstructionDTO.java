package com.skylan.jpa_recipe_assignment.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class RecipeInstructionDTO implements Serializable {
    private String recipeInstructionId;
    private String recipeInstruction;
}
