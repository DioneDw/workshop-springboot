package com.dwprojects.projetowebservice.resources;

import com.dwprojects.projetowebservice.entities.Product;
import com.dwprojects.projetowebservice.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
@Tag(name = "Produtos")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @Operation(
            description = "Retorna uma array de objetos de produtos encontrados na base",
            summary = "Retorna uma lista de produtos"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna os produtos"),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro ao obter recurso")
    })
    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> products = productService.findAll();
        return ResponseEntity.ok().body(products);
    }


    @Operation(
            description = "Retorna um produto conforme o identificador único informado",
            summary = "Retorna um produto pelo ID",
            parameters = {
            @Parameter(name = "id", description = "Identificador único do produto")
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna um produto"),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro ao obter recurso")
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product product = productService.findById(id);
        return ResponseEntity.ok().body(product);
    }
}
