package com.informatorio.blogapirest.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
    private long id;
    private String titulo;
    private String descripcion;
    private String contenido;
    private String fechaDeCreacion;
    private Usuario autor;
    private boolean publicado;
    private static long contadorPost = 1;

    public Post() {
        this.id = contadorPost++;
        this.fechaDeCreacion = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public Post(String titulo, String descripcion, String contenido, Usuario usuario, boolean publicado) {
        this.id = contadorPost++;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.contenido = contenido;
        this.fechaDeCreacion = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.autor = usuario;
        this.publicado = publicado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(String fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public boolean isPublicado() {
        return publicado;
    }

    public void setPublicado(boolean publicado) {
        this.publicado = publicado;
    }

    public static long getContadorPost() {
        return contadorPost;
    }

    public static void setContadorPost(long contadorPost) {
        Post.contadorPost = contadorPost;
    }
}
