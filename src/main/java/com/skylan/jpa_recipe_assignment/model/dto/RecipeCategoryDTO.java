package com.skylan.jpa_recipe_assignment.model.dto;
import com.skylan.jpa_recipe_assignment.model.entity.Recipe;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RecipeCategoryDTO {
    private int recipeCategoryId;
    private String recipeCategoryName;
    private List<Recipe> recipes;
}
