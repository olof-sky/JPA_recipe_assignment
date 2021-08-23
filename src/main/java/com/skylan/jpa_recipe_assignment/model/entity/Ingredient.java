package com.skylan.jpa_recipe_assignment.model.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Data
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
