package com.skylan.jpa_recipe_assignment.service;

import com.skylan.jpa_recipe_assignment.dao.RecipeIngredientDAO;
import com.skylan.jpa_recipe_assignment.exception.ResourceNotFoundException;
import com.skylan.jpa_recipe_assignment.model.dto.RecipeIngredientDTO;
import com.skylan.jpa_recipe_assignment.model.entity.RecipeIngredient;
import com.skylan.jpa_recipe_assignment.service.conversion.RecipeIngredientFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeIngredientService {
    private final RecipeIngredientDAO recipeIngredientDAO;
    private final RecipeIngredientFactory recipeIngredientFactory;

    public RecipeIngredientService(RecipeIngredientDAO recipeIngredientDAO, RecipeIngredientFactory recipeIngredientFactory) {
        this.recipeIngredientDAO = recipeIngredientDAO;
        this.recipeIngredientFactory = recipeIngredientFactory;
    }

    @Transactional(readOnly = true)
    public RecipeIngredientDTO toDTO (RecipeIngredient recipeIngredient){
        RecipeIngredientDTO recipeIngredientDTO = null;
        if(recipeIngredient != null){
            recipeIngredientDTO = new RecipeIngredientDTO();
            recipeIngredientDTO.setRecipeIngredientId(recipeIngredient.getRecipeIngredientId());
            recipeIngredientDTO.setIngredient(recipeIngredient.getIngredient());
            recipeIngredientDTO.setAmount(recipeIngredient.getAmount());
            recipeIngredientDTO.setMeasurement(recipeIngredient.getMeasurement());
            recipeIngredientDTO.setRecipe(recipeIngredient.getRecipe());
        }
        return recipeIngredientDTO;
    }

    @Transactional(readOnly = true)
    public List<RecipeIngredientDTO> toDTOs (List<RecipeIngredient> recipeIngredients){
        List<RecipeIngredientDTO> recipeIngredientDTOS = new ArrayList<>();
        if (recipeIngredients != null){
            for (RecipeIngredient recipeIngredient : recipeIngredients){
                recipeIngredientDTOS.add(toDTO(recipeIngredient));
            }
        }
        return recipeIngredientDTOS;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeIngredientDTO create (RecipeIngredientDTO recipeIngredientDTO){
        RecipeIngredient recipeIngredient = recipeIngredientFactory.CreateFromDTO(recipeIngredientDTO);
        return toDTO(recipeIngredient);
    }

    @Transactional(readOnly = true)
    public List<RecipeIngredientDTO> findAll(){
        return toDTOs(recipeIngredientDAO.findAll());
    }

    @Transactional(readOnly = true)
    public RecipeIngredientDTO findById(String id) {
        return toDTO(recipeIngredientDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not find ingredient with id of " + id)));
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeIngredientDTO update(String id, RecipeIngredientDTO recipeIngredientDTO){
        RecipeIngredient recipeIngredient = recipeIngredientDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not find ingredient with id of " + id));
        recipeIngredient.setIngredient(recipeIngredientDTO.getIngredient());
        recipeIngredient.setAmount(recipeIngredientDTO.getAmount());
        recipeIngredient.setMeasurement(recipeIngredientDTO.getMeasurement());
        recipeIngredient.setRecipe(recipeIngredientDTO.getRecipe());
        recipeIngredientDAO.save(recipeIngredient);
        return toDTO(recipeIngredient);
    }
}
