package com.alujan.Usuario.service.impl;

import com.alujan.Usuario.client.PostClientFeign;
import com.alujan.Usuario.entidades.Usuario;
import com.alujan.Usuario.entidades.dto.UsuarioDTO;
import com.alujan.Usuario.entidades.modelos.Post;
import com.alujan.Usuario.repository.UsuarioRepository;
import com.alujan.Usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PostClientFeign postClientFeign;

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> obtenerPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public void eliminar(Integer id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public UsuarioDTO buscarPostId(Integer id) {
        UsuarioDTO res= new UsuarioDTO();
        Optional<Usuario> usuario=usuarioRepository.findById(id);
        List<Post> posts= postClientFeign.listarPorIdUsers(id);
            res.setId(String.valueOf(usuario.get().getId()));
            res.setCellphone(usuario.get().getCellphone());
            res.setName(usuario.get().getName());
            res.setLastName(usuario.get().getLastName());
            res.setPassword(usuario.get().getPassword());
            res.setPosts(posts);
        return  res;
    }
}
