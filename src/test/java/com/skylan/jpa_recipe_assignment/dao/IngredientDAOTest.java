package com.skylan.jpa_recipe_assignment.dao;

import com.skylan.jpa_recipe_assignment.TestObjectGenerator;
import com.skylan.jpa_recipe_assignment.models.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
    class IngredientDAOTest {
        @Autowired private IngredientDAO testObject;
        @Autowired private TestEntityManager em;

        private List<Ingredient> ingredients;

        @BeforeEach
        void setUp(){
            TestObjectGenerator testObjectGenerator = new TestObjectGenerator();
            ingredients = new ArrayList<>();
            for(Ingredient ingredient : testObjectGenerator.ingredients()){
                ingredients.add(em.persist(ingredient));
            }
            em.flush();
        }

    @Test
    void findIngredientByIngredientName() {
            List<Ingredient> expected = Arrays.asList(ingredients.get(0));
            List<Ingredient> actual = testObject.findIngredientByIngredientName("lök");
            assertEquals(expected, actual);
        }

    @Test
    void findIngredientByIngredientNameContaining() {
        List<Ingredient> expected = Arrays.asList(ingredients.get(0));
        List<Ingredient> actual = testObject.findIngredientByIngredientNameContaining("ök");
        assertEquals(expected, actual);
    }
}