package com.skylan.jpa_recipe_assignment.service;


import com.skylan.jpa_recipe_assignment.dao.IngredientDAO;
import com.skylan.jpa_recipe_assignment.exception.ResourceAlreadyExistException;
import com.skylan.jpa_recipe_assignment.exception.ResourceNotFoundException;
import com.skylan.jpa_recipe_assignment.model.dto.IngredientDTO;
import com.skylan.jpa_recipe_assignment.model.entity.Ingredient;
import com.skylan.jpa_recipe_assignment.service.conversion.IngredientFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientService {
    private final IngredientDAO ingredientDAO;
    private final IngredientFactory ingredientFactory;

    public IngredientService(IngredientDAO ingredientDAO, IngredientFactory ingredientFactory) {
        this.ingredientDAO = ingredientDAO;
        this.ingredientFactory = ingredientFactory;
    }

    @Transactional(readOnly = true)
    public IngredientDTO toDTO (Ingredient ingredient){
        IngredientDTO ingredientDTO = null;
        if(ingredient != null){
            ingredientDTO = new IngredientDTO();
            ingredientDTO.setIngredientId(ingredient.getIngredientId());
            ingredientDTO.setIngredientName(ingredient.getIngredientName());
        }
        return ingredientDTO;
    }

    @Transactional(readOnly = true)
    public List<IngredientDTO> toDTOs (List<Ingredient> ingredients){
        List<IngredientDTO> ingredientDTOS = new ArrayList<>();
        if (ingredients != null){
            for (Ingredient ingredient : ingredients){
                ingredientDTOS.add(toDTO(ingredient));
            }
        }
        return ingredientDTOS;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public IngredientDTO create (IngredientDTO ingredientDTO){
        Ingredient ingredient = ingredientFactory.CreateFromDTO(ingredientDTO);
        if (ingredientDAO.findIngredientByIngredientName(ingredientDTO.getIngredientName()).isEmpty()){
            ingredientDAO.save(ingredient);
        }else throw new ResourceAlreadyExistException("Ingredient " + ingredient.getIngredientName() + " already exist");
        return toDTO(ingredient);
    }

    @Transactional(readOnly = true)
    public List<IngredientDTO> findAll(){
        return toDTOs(ingredientDAO.findAll());
    }

    @Transactional(readOnly = true)
    public IngredientDTO findById(Integer id) {
        return toDTO(ingredientDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not find ingredient with id of " + id)));
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public IngredientDTO update(Integer id, IngredientDTO ingredientDTO){
        Ingredient ingredient = ingredientDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not find ingredient with id of " + id));
        ingredient.setIngredientName(ingredientDTO.getIngredientName());
        ingredientDAO.save(ingredient);
        return toDTO(ingredient);
    }
}
