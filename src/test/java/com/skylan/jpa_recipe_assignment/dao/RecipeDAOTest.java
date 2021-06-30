package com.skylan.jpa_recipe_assignment.dao;

import com.skylan.jpa_recipe_assignment.TestObjectGenerator;
import com.skylan.jpa_recipe_assignment.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RecipeDAOTest {
    @Autowired private RecipeDAO testObject;
    @Autowired private TestEntityManager em;

    private List<Recipe> recipes;
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
        this.recipes = testObject.saveAll(recipes);
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
        recipes.get(0).setCategories(recipeCategories);
        assertEquals(1, testObject.findByCategoriesRecipeCategoriesSizeGreaterThenOne().size());
    }

    @Test
    void findByRecipeNameIgnoreCase() {
        assertNotNull(testObject.findByRecipeNameIgnoreCase("RECIPE1"));
        List<Recipe> actual = new ArrayList<>(Collections.singletonList(recipes.get(0)));
        List<Recipe> expected = testObject.findByRecipeNameIgnoreCase("REcIpE1");
        assertEquals(expected, actual);
    }

    @Test
    void findByRecipeIngredientsIngredientIngredientNameIgnoreCase() {
        recipeIngredients.get(0).setIngredient(ingredients.get(0));
        recipes.get(0).setRecipeIngredients(new ArrayList<>(Collections.singletonList(recipeIngredients.get(0))));
        List<Recipe> recipe = new ArrayList<>(Collections.singletonList(recipes.get(0)));
        assertEquals(recipe, testObject.findRecipeByRecipeIngredientsIngredientIngredientNameIgnoreCase("lök"));
    }

    @Test
    void findByCategoriesRecipeCategoryName() {
        recipes.get(0).setCategories(recipeCategories);
        assertNotNull(testObject.findByCategoriesRecipeCategoryName("Burkmat"));
        List<Recipe> recipesList = new ArrayList<>(Collections.singletonList(recipes.get(0)));
        assertEquals(recipesList, testObject.findByCategoriesRecipeCategoryName("Burkmat"));
    }

    @Test
    void findByMultipleCategories() {
        recipes.get(0).setCategories(recipeCategories);
        List<Recipe> recipesList = new ArrayList<>(Collections.singletonList(recipes.get(0)));
        assertEquals(1, testObject.findByMultipleCategories("Burkmat", "Billig mat").size());
        assertEquals(recipesList, testObject.findByMultipleCategories("Burkmat", "Billig mat"));
    }
}