package com.informatorio.blogapirest.services;

import com.informatorio.blogapirest.model.Comentario;
import com.informatorio.blogapirest.model.Post;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ComentarioService {

    private UserService userService = new UserService();
    private PostService postService = new PostService();

    public List<Comentario> comentarios = new ArrayList<>(Arrays.asList(
            new Comentario(userService.usuarios.get(1), postService.posts.get(1), "Este es un comentario de ejemplo"),
            new Comentario(userService.usuarios.get(1), postService.posts.get(1), "Soy un comentario de ejemplo"))
    );

    public void addComentario(Comentario comentario) {
        comentarios.add(comentario);
    }

    public List<Comentario> getAllComentarios() {
        return comentarios;
    }

    public void deleteComentario(long id) {
        comentarios.removeIf(p ->p.getId() == id);
    }

    public void updateComentario(long id, Comentario comentario) {
        for (int i = 0; i < comentarios.size(); i++) {
            Comentario c = comentarios.get(i);
            if (c.getId() == id) {
                comentarios.set(i, comentario);
                return;
            }
        }
    }
}
