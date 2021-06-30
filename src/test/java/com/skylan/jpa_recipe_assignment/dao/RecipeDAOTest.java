package com.skylan.jpa_recipe_assignment.dao;

import com.skylan.jpa_recipe_assignment.TestObjectGenerator;
import com.skylan.jpa_recipe_assignment.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class RecipeDAOTest {
    @Autowired private RecipeDAO testObject;
    @Autowired private IngredientDAO ingredientDAO;
    @Autowired private TestEntityManager em;

    private List<Recipe> recipesInContext;
    private List<Ingredient> ingredients;
    private List<RecipeIngredient> recipeIngredients;
    private List<RecipeInstruction> recipeInstructions;
    private List<RecipeCategory> recipeCategories;
    @BeforeEach
    void setUp(){
        TestObjectGenerator testObjectGenerator = new TestObjectGenerator();
        ingredients = new ArrayList<>();
        for(Ingredient ingredient : testObjectGenerator.ingredients()){
            ingredients.add(em.persist(ingredient));
        }
        recipeCategories = new ArrayList<>();
        for(RecipeCategory recipeCategory : testObjectGenerator.recipeCategory()){
            recipeCategories.add(em.persist(recipeCategory));
        }
        recipeIngredients = new ArrayList<>();
        for(RecipeIngredient recipeIngredient : testObjectGenerator.recipeIngredients()){
            recipeIngredients.add(em.persist(recipeIngredient));
        }
        recipeInstructions = new ArrayList<>();
        for(RecipeInstruction recipeInstruction : testObjectGenerator.recipeInstruction()){
            recipeInstructions.add(em.persist(recipeInstruction));
        }
        List<Recipe> recipes = testObjectGenerator.recipe();
        recipesInContext = testObject.saveAll(recipes);
        em.flush();
    }

    @Test
    void findByCategoriesRecipeCategoriesSizeGreaterThenOne() {
        List<Recipe> actual = testObject.findByCategoriesRecipeCategoriesSizeGreaterThenOne();
        List<Recipe> expected = new ArrayList<>();
        assertEquals(expected, actual);
    }

    @Test
    void findByCategoriesRecipeCategoriesSizeGreaterThenOneSuccesfull() {
        recipesInContext.get(0).setCategories(recipeCategories);
        System.out.println(testObject.findByCategoriesRecipeCategoriesSizeGreaterThenOne());
    }
}