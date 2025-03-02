package com.dwprojects.projetowebservice.resources;

import com.dwprojects.projetowebservice.entities.Category;
import com.dwprojects.projetowebservice.services.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@Tag(name = "Categorias")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @Operation(
            description = "Retorna uma array de objetos de categorias encontradas na base",
            summary = "Retorna uma lista de categorias"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna as categorias"),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro ao obter recurso")
    })
    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categories = categoryService.findAll();
        return ResponseEntity.ok().body(categories);
    }


    @Operation(
            description = "Retorna uma categoria conforme o identificador único informado",
            summary = "Retorna uma categoria pelo ID",
            parameters = {
            @Parameter(name = "id", description = "Identificador único da categoria")
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna uma categoria"),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro ao obter recurso")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        return ResponseEntity.ok().body(category);
    }
}
