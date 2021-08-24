package com.skylan.jpa_recipe_assignment.service;

import com.skylan.jpa_recipe_assignment.dao.RecipeDAO;
import com.skylan.jpa_recipe_assignment.exception.ResourceAlreadyExistException;
import com.skylan.jpa_recipe_assignment.exception.ResourceNotFoundException;
import com.skylan.jpa_recipe_assignment.model.dto.RecipeDTO;
import com.skylan.jpa_recipe_assignment.model.entity.Recipe;
import com.skylan.jpa_recipe_assignment.service.conversion.RecipeFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {
    private final RecipeDAO recipeDAO;
    private final RecipeFactory recipeFactory;

    public RecipeService(RecipeDAO recipeDAO, RecipeFactory recipeFactory) {
        this.recipeDAO = recipeDAO;
        this.recipeFactory = recipeFactory;
    }

    @Transactional(readOnly = true)
    public RecipeDTO toDTO (Recipe recipe){
        RecipeDTO recipeDTO = null;
        if(recipe != null){
            recipeDTO = new RecipeDTO();
            recipeDTO.setRecipeId(recipe.getRecipeId());
            recipeDTO.setRecipeName(recipe.getRecipeName());
            recipeDTO.setRecipeIngredients(recipe.getRecipeIngredients());
            recipeDTO.setRecipeInstruction(recipe.getRecipeInstruction());
            recipeDTO.setCategories(recipe.getCategories());
        }
        return recipeDTO;
    }

    @Transactional(readOnly = true)
    public List<RecipeDTO> toDTOs (List<Recipe> recipes){
        List<RecipeDTO> recipeDTOS = new ArrayList<>();
        if (recipes != null){
            for (Recipe recipe : recipes){
                recipeDTOS.add(toDTO(recipe));
            }
        }
        return recipeDTOS;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeDTO create (RecipeDTO recipeDTO){
        Recipe recipe = recipeFactory.CreateFromDTO(recipeDTO);
        if (recipeDAO.findRecipeByRecipeName(recipe.getRecipeName()).equals(recipe.getRecipeName())){
            throw new ResourceAlreadyExistException("Recipe " + recipe.getRecipeName() + " already exist");
        }else recipeDAO.save(recipe);
        return toDTO(recipe);
    }

    @Transactional(readOnly = true)
    public List<RecipeDTO> findAll(){
        return toDTOs(recipeDAO.findAll());
    }

    @Transactional(readOnly = true)
    public RecipeDTO findById(Integer id) {
        return toDTO(recipeDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not find recipe with id of " + id)));
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeDTO update(Integer id, RecipeDTO recipeDTO){
        Recipe recipe = recipeDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not find ingredient with id of " + id));
        recipe.setRecipeName(recipeDTO.getRecipeName());
        recipe.setRecipeInstruction(recipeDTO.getRecipeInstruction());
        recipe.setRecipeIngredients(recipeDTO.getRecipeIngredients());
        recipe.setCategories(recipeDTO.getCategories());
        recipeDAO.save(recipe);
        return toDTO(recipe);
    }
}
