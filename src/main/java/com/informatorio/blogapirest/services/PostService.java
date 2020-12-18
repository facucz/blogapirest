package com.informatorio.blogapirest.services;

import com.informatorio.blogapirest.model.Post;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private UserService userService = new UserService();

    public List<Post> posts = new ArrayList<>(Arrays.asList(
            new Post("Titulo Post", "Descripcion Post", "Contenido del post",
                    userService.usuarios.get(1), true),
            new Post("Cosas", "Post sobre cosas", "Las cosas son objetos",
                    userService.usuarios.get(1), false))
    );

    public List<Post> getAllPost() {
        return posts;
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public void updatePost(long id, Post post) {
        for (int i = 0; i < posts.size(); i++) {
            Post p = posts.get(i);
            if (p.getId() == id) {
                posts.set(i, post);
                return;
            }
        }
    }

    public void deletePost(long id) {
        posts.removeIf(p ->p.getId() == id);
    }

    public List<Post> getAllPost(boolean isPublicado) {
        return posts.stream().filter(p -> p.isPublicado() == isPublicado).collect(Collectors.toList());
    }

    public List<Post> getAllPost(String wordInTitle) {
        return posts.stream().filter(p -> p.getTitulo().contains(wordInTitle)).collect(Collectors.toList());
    }
}
