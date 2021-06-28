package com.skylan.jpa_recipe_assignment.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"recipeIngredientId", "recipe", "ingredient"})
@ToString
@Entity
public class RecipeIngredient {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String recipeIngredientId;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "recipe_recipe_ingredient_id")
    private Ingredient ingredient;
    private Double amount;
    private Measurement measurement;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    private Recipe recipe;
}