package com.alujan.Usuario.service;

import com.alujan.Usuario.entidades.Usuario;
import com.alujan.Usuario.entidades.dto.UsuarioDTO;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> listarUsuarios();
    Usuario crearUsuario(Usuario usuario);
    Optional<Usuario> obtenerPorId(Integer id);
    void eliminar(Integer id);

    UsuarioDTO buscarPostId(Integer id);
}
