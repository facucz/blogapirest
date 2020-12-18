package com.informatorio.blogapirest.services;

import com.informatorio.blogapirest.model.Usuario;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    public List<Usuario> usuarios = new ArrayList<>(Arrays.asList(
            new Usuario("Felipe", "Reyes",
                    "felipe@gmail.com", "feli123",
                    "Resistencia", "Chaco", "Argentina"),
            new Usuario("Juan", "Perez",
                    "jp@gmail.com", "juanpi12",
                    "Valparaiso", "Santiago", "Chile"))
    );

    public List<Usuario> getAllUsers() {
        return usuarios;
    }

    public List<Usuario> getAllUsers(String ciudad) {
        return usuarios.stream().filter(u -> u.getCiudad().equals(ciudad)).collect(Collectors.toList());
    }

    public List<Usuario> getUsers(String fechaCreacion) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        List<Usuario> listaUsuarios = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (sdf.parse(usuario.getFechaDeCreacion()).after(sdf.parse(fechaCreacion))) {
                listaUsuarios.add(usuario);
            }
        }
        return listaUsuarios;
    }

    public Usuario getUser(long id) {
        return usuarios.stream().filter(u -> u.getId() == id).findFirst().get();
    }

    public void addUser(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void updateUser(long id, Usuario usuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario u = usuarios.get(i);
            if (u.getId() == id) {
                usuarios.set(i, usuario);
                return;
            }
        }
    }

    public void deleteUser(long id) {
        usuarios.removeIf(u -> u.getId() == id);
    }
}
