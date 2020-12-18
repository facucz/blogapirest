package com.informatorio.blogapirest.controller;

import com.informatorio.blogapirest.model.Comentario;
import com.informatorio.blogapirest.services.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "comentarios")
    public void addComentario(@RequestBody Comentario comentario) {
        comentarioService.addComentario(comentario);
    }

    @GetMapping(path = "comentarios")
    public List<Comentario> getAllComentarios() {
        return comentarioService.getAllComentarios();
    }

    @DeleteMapping(path = "comentarios/{id}")
    public String deleteComentario(@PathVariable long id) {
        comentarioService.deleteComentario(id);
        return "Comentario with id " + id + " was successfully delete.";
    }

    @PutMapping(path = "comentarios/{id}")
    public void updateComentario(@RequestBody Comentario comentario, @PathVariable long id) {
        comentarioService.updateComentario(id, comentario);
    }
}
