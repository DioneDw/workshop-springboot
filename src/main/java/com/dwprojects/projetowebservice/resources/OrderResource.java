package com.dwprojects.projetowebservice.resources;

import com.dwprojects.projetowebservice.entities.Order;
import com.dwprojects.projetowebservice.services.OrderService;

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
@RequestMapping(value= "/orders")
@Tag(name = "Pedidos")
public class OrderResource {

    @Autowired
    private OrderService service;

    @Operation(
            description = "Retorna uma array de objetos de pedidos encontrados na base",
            summary = "Retorna uma lista de pedidos"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Retorna os pedidos"),
        @ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro ao obter recurso")
    })
    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> orders = service.findAll();
        return ResponseEntity.ok().body(orders);
    }

    @Operation(
            description = "Retorna uma categoria conforme o identificador único informado",
            summary = "Retorna uma categoria pelo ID",
            parameters = {
            @Parameter(name = "id", description = "Identificador único do pedido")
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna um pedido"),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro ao obter recurso")
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order order = service.findById(id);
        return ResponseEntity.ok().body(order);
    }


}
