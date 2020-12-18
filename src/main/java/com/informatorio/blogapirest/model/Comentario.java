package com.informatorio.blogapirest.model;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Comentario {

    private long id;
    private Usuario autor;
    private Post post;
    private String fechaDeCreacion;

    @Size(max = 200)
    private String comentario;

    private static long contadorComentario = 1;

    public Comentario() {
        this.id = contadorComentario++;
        this.fechaDeCreacion = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public Comentario(Usuario usuario, Post post, String comentario) {
        this.id = contadorComentario++;
        this.autor = usuario;
        this.post = post;
        this.fechaDeCreacion = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.comentario = comentario;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public static long getContadorComentario() {
        return contadorComentario;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public long getId() {
        return id;
    }

    public String getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFechaDeCreacion(String fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public static void setContadorComentario(long contadorComentario) {
        Comentario.contadorComentario = contadorComentario;
    }
}
