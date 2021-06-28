package com.skylan.jpa_recipe_assignment.models;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"ingredientId"})
@ToString
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ingredientId;
    @Column(unique = true)
    private String ingredientName;
}
