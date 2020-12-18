package com.informatorio.blogapirest.controller;

import com.informatorio.blogapirest.model.Usuario;
import com.informatorio.blogapirest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UsuarioController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/usuarios")
    public List<Usuario> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/usuarios/{ciudad}")
    public List<Usuario> getAllUsers(@PathVariable String ciudad) {
        return userService.getAllUsers(ciudad);
    }

    @GetMapping(path = "/usuario/{id}")
    public Usuario getUser(@PathVariable long id) {
        return userService.getUser(id);
    }

    @GetMapping(path = "/usuarios/{fechaCreacion}")
    public List<Usuario> getUsers(@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") String fechaCreacion) throws ParseException {
        return userService.getUsers(fechaCreacion);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "usuarios")
    public void addUser(@RequestBody Usuario usuario) {
        userService.addUser(usuario);
    }

    @PutMapping(path = "usuarios/{id}")
    public void updateUser(@RequestBody Usuario usuario, @PathVariable long id) {
        userService.updateUser(id, usuario);
    }

    @DeleteMapping(path = "/usuario/{id}")
    public String deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return "User with id " + id + " was successfully delete.";
    }
}

