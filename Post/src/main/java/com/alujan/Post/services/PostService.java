package com.alujan.Post.services;

import java.util.List;
import java.util.Optional;


import com.alujan.Post.entidades.Post;



public interface PostService {
	
	List<Post> listarPost();
	Post crearUsuario(Post post);

	Optional<Post> obtenerPorId(Integer id);
	void eliminar(Integer id);
////////////////////////////////////////////////
	List<Post> findByUserId(Integer usuarioId);


}
