package com.dwprojects.projetowebservice.resources;


import com.dwprojects.projetowebservice.entities.User;
import com.dwprojects.projetowebservice.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
@Tag(name = "Usuários")
public class UserResource {

    @Autowired
    private UserService service;

    @Operation(
            description = "Retorna uma array de objetos de usuários encontrados na base",
            summary = "Retorna uma lista de usuários")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna os usuários"),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro ao obter recurso")
    })
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @Operation(
            description = "Cria um novo usuário e registra na base de dados",
            summary = "Cria um novo usuário",
            requestBody =
    @io.swagger.v3.oas.annotations.parameters.RequestBody(content =
    @Content(schema = @Schema(implementation = User.class))))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do usuário"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a requisição")
    })
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(uri).body(obj);
    }


    @Operation(
            description = "Retorna um usuário conforme o identificador único na base de dados",
            summary = "Retorna um usuário pelo ID",
            parameters = {
            @Parameter(name = "id", description = "Identificador único do usuário")
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna um usuário"),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro ao obter recurso")
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }



    @Operation(
            description = "Deleta um usuário na base de dados conforme o identificador",
            summary = "Deleta um usuário pelo ID",
            parameters = {
            @Parameter(name = "id", description = "Identificador único do usuário", required = true)
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Usuário deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a requisição")
    })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


    @Operation(
            description = "Atualiza um usuário na base de dados conforme o identificador e o objeto informados",
            summary = "Atualiza um usuário pelo ID",
            parameters = {
            @Parameter(name = "id", description = "Identificador único do usuário", required = true),
            @Parameter(name = "user", description = "Objeto com os dados do usuário", required = true)
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na atualização do usuário"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a requisição")
    })
    @PutMapping(value="/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
