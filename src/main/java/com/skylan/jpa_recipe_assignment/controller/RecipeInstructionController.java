package com.skylan.jpa_recipe_assignment.controller;

import com.skylan.jpa_recipe_assignment.model.dto.RecipeInstructionDTO;
import com.skylan.jpa_recipe_assignment.service.RecipeInstructionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RecipeInstructionController {

    private final RecipeInstructionService recipeInstructionService;

    public RecipeInstructionController(RecipeInstructionService recipeInstructionService) {
        this.recipeInstructionService = recipeInstructionService;
    }

    @PostMapping("/api/v1/recipe-instruction")
    public ResponseEntity<RecipeInstructionDTO> create(@RequestBody RecipeInstructionDTO recipeInstructionDTO){
        return ResponseEntity.status(201).body(recipeInstructionService.create(recipeInstructionDTO));
    }

    @GetMapping("/api/v1/recipe-instruction")
    public ResponseEntity<List<RecipeInstructionDTO>> search(){
        return ResponseEntity.ok(recipeInstructionService.findAll());
    }

    @GetMapping("/api/v1/recipe-instruction/{id}")
    public ResponseEntity<RecipeInstructionDTO> findById(@PathVariable(name = "id") String id){
        return ResponseEntity.ok(recipeInstructionService.findById(id));
    }

    @PutMapping("/api/v1/recipe-instruction/{id}")
    public ResponseEntity<RecipeInstructionDTO> update(@PathVariable(name = "id") String id, @RequestBody RecipeInstructionDTO recipeInstructionDTO){
        return ResponseEntity.ok(recipeInstructionService.update(id, recipeInstructionDTO));
    }
}
