package com.skylan.jpa_recipe_assignment.controller;

import com.skylan.jpa_recipe_assignment.model.dto.RecipeDTO;
import com.skylan.jpa_recipe_assignment.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/api/v1/recipe")
    public ResponseEntity<RecipeDTO> create(@RequestBody RecipeDTO recipeDTO){
        return ResponseEntity.status(201).body(recipeService.create(recipeDTO));
    }

    @GetMapping("/api/v1/recipe")
    public ResponseEntity<List<RecipeDTO>> search(){
        return ResponseEntity.ok(recipeService.findAll());
    }

    @GetMapping("/api/v1/recipe/{id}")
    public ResponseEntity<RecipeDTO> findById(@PathVariable(name = "id") Integer id){
        return ResponseEntity.ok(recipeService.findById(id));
    }

    @PutMapping("/api/v1/recipe/{id}")
    public ResponseEntity<RecipeDTO> update(@PathVariable(name = "id") Integer id, @RequestBody RecipeDTO recipeDTO){
        return ResponseEntity.ok(recipeService.update(id, recipeDTO));
    }
}
