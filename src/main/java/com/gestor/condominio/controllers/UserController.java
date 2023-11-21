package com.gestor.condominio.controllers;

import com.gestor.condominio.models.Evento;
import com.gestor.condominio.models.User;
import com.gestor.condominio.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
@RestController
@RequestMapping(value = "/eventos")
@Api(value = "API REST condomínios")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(value = "Salva um user")
    public ResponseEntity<Void> save (@RequestBody User user){
        userService.salvarUsuario(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
