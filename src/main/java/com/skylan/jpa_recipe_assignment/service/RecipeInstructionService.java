package com.skylan.jpa_recipe_assignment.service;

import com.skylan.jpa_recipe_assignment.dao.RecipeInstructionDAO;
import com.skylan.jpa_recipe_assignment.exception.ResourceAlreadyExistException;
import com.skylan.jpa_recipe_assignment.exception.ResourceNotFoundException;
import com.skylan.jpa_recipe_assignment.model.dto.RecipeInstructionDTO;
import com.skylan.jpa_recipe_assignment.model.entity.RecipeInstruction;
import com.skylan.jpa_recipe_assignment.service.conversion.RecipeInstructionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeInstructionService {
    private final RecipeInstructionFactory recipeInstructionFactory;
    private final RecipeInstructionDAO recipeInstructionDAO;

    public RecipeInstructionService(RecipeInstructionFactory recipeInstructionFactory, RecipeInstructionDAO recipeInstructionDAO) {
        this.recipeInstructionFactory = recipeInstructionFactory;
        this.recipeInstructionDAO = recipeInstructionDAO;
    }

    @Transactional(readOnly = true)
    public RecipeInstructionDTO toDTO (RecipeInstruction recipeInstruction){
        RecipeInstructionDTO recipeInstructionDTO = null;
        if(recipeInstruction != null){
            recipeInstructionDTO = new RecipeInstructionDTO();
            recipeInstructionDTO.setRecipeInstructionId(recipeInstruction.getRecipeInstructionId());
            recipeInstructionDTO.setRecipeInstruction(recipeInstruction.getRecipeInstruction());
        }
        return recipeInstructionDTO;
    }

    @Transactional(readOnly = true)
    public List<RecipeInstructionDTO> toDTOs (List<RecipeInstruction> recipeInstructions){
        List<RecipeInstructionDTO> recipeInstructionDTOS = new ArrayList<>();
        if (recipeInstructions != null){
            for (RecipeInstruction recipeInstruction : recipeInstructions){
                recipeInstructionDTOS.add(toDTO(recipeInstruction));
            }
        }
        return recipeInstructionDTOS;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeInstructionDTO create (RecipeInstructionDTO recipeInstructionDTO){
        RecipeInstruction recipeInstruction = recipeInstructionFactory.CreateFromDTO(recipeInstructionDTO);
        if(recipeInstructionDAO.findByRecipeInstruction(recipeInstruction.getRecipeInstruction()).equals(recipeInstruction.getRecipeInstruction())){
            throw new ResourceAlreadyExistException("RecipeInstruction " + recipeInstruction.getRecipeInstruction() + " already exist");
        }else recipeInstructionDAO.save(recipeInstruction);
        return toDTO(recipeInstruction);
    }

    @Transactional(readOnly = true)
    public List<RecipeInstructionDTO> findAll(){
        return toDTOs(recipeInstructionDAO.findAll());
    }

    @Transactional(readOnly = true)
    public RecipeInstructionDTO findById(String id) {
        return toDTO(recipeInstructionDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not find recipeInstruction with id of " + id)));
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeInstructionDTO update(String id, RecipeInstructionDTO recipeInstructionDTO){
        RecipeInstruction recipeInstruction = recipeInstructionDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not find recipeInstruction with id of " + id));
        recipeInstruction.setRecipeInstruction(recipeInstructionDTO.getRecipeInstruction());
        recipeInstructionDAO.save(recipeInstruction);
        return toDTO(recipeInstruction);
    }
}
