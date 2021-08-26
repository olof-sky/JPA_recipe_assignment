package com.skylan.jpa_recipe_assignment.controller;

import com.skylan.jpa_recipe_assignment.model.dto.RecipeIngredientDTO;
import com.skylan.jpa_recipe_assignment.service.RecipeIngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RecipeIngredientController {
    private final RecipeIngredientService recipeIngredientService;

    public RecipeIngredientController(RecipeIngredientService recipeIngredientService) {
        this.recipeIngredientService = recipeIngredientService;
    }

    @PostMapping("/api/v1/recipe-ingredient")
    public ResponseEntity<RecipeIngredientDTO> create(@RequestBody RecipeIngredientDTO recipeIngredientDTO){
        return ResponseEntity.status(201).body(recipeIngredientService.create(recipeIngredientDTO));
    }

    @GetMapping("/api/v1/recipe-ingredient")
    public ResponseEntity<List<RecipeIngredientDTO>> search(){
        return ResponseEntity.ok(recipeIngredientService.findAll());
    }

    @GetMapping("/api/v1/recipe-ingredient/{id}")
    public ResponseEntity<RecipeIngredientDTO> findById(@PathVariable(name = "id") String id){
        return ResponseEntity.ok(recipeIngredientService.findById(id));
    }

    @PutMapping("/api/v1/recipe-ingredient/{id}")
    public ResponseEntity<RecipeIngredientDTO> update(@PathVariable(name = "id") String id, @RequestBody RecipeIngredientDTO recipeIngredientDTO){
        return ResponseEntity.ok(recipeIngredientService.update(id, recipeIngredientDTO));
    }
}
