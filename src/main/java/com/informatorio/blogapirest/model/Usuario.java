package com.informatorio.blogapirest.model;

import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Usuario {

    private long id;
    private String nombre;
    private String apellido;

    @UniqueElements
    private String email;

    private String password;
    private String fechaDeCreacion;
    private String ciudad;
    private String provincia;
    private String pais;
    private static long contadorUsuario = 0;

    public Usuario() {
        this.id = contadorUsuario++;
        this.fechaDeCreacion = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public Usuario(String nombre, String apellido, String email, String password, String ciudad, String provincia, String pais) {
        this.id = contadorUsuario++;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.fechaDeCreacion = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.pais = pais;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFechaDeCreacion(String fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

}
