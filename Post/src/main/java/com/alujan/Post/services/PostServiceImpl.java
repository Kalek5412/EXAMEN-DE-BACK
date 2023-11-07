package com.alujan.Post.services;

import java.time.LocalDate;
import java.util.*;

import com.alujan.Post.entidades.Post;
import com.alujan.Post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepository;


	@Override
	public List<Post> listarPost()  {
		return (List<Post>) postRepository.findAll();
	}

	@Override
	public Post crearUsuario(Post post) {
		LocalDate fechaActual =LocalDate.now();
		post.setCreado(fechaActual);
		return postRepository.save(post);
	}


	@Override
	public Optional<Post> obtenerPorId(Integer id) {
		return postRepository.findById(id);
	}

	@Override
	public void eliminar(Integer id) {
		postRepository.deleteById(id);
	}

	@Override
	public List<Post> findByUserId(Integer usuarioId) {
		List<Post> posts=postRepository.findByusuarioId(usuarioId);
		return posts;
	}




}



