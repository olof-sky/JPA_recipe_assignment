package com.skylan.jpa_recipe_assignment.controller;

import com.skylan.jpa_recipe_assignment.model.dto.IngredientDTO;
import com.skylan.jpa_recipe_assignment.service.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping("/api/v1/ingredient")
    public ResponseEntity<IngredientDTO> create(@RequestBody IngredientDTO ingredientDTO){
        return ResponseEntity.status(201).body(ingredientService.create(ingredientDTO));
    }

    @GetMapping("/api/v1/ingredient")
    public ResponseEntity<List<IngredientDTO>> search(){
        return ResponseEntity.ok(ingredientService.findAll());
    }

    @GetMapping("/api/v1/ingredient/{id}")
    public ResponseEntity<IngredientDTO> findById(@PathVariable(name = "id") Integer id){
        return ResponseEntity.ok(ingredientService.findById(id));
    }

    @PutMapping("/api/v1/ingredient/{id}")
    public ResponseEntity<IngredientDTO> update(@PathVariable(name = "id") Integer id, @RequestBody IngredientDTO ingredientDTO){
        return ResponseEntity.ok(ingredientService.update(id, ingredientDTO));
    }
}
