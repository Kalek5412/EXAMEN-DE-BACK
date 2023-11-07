package com.alujan.Post.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


import com.alujan.Post.entidades.Post;
import com.alujan.Post.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class PostController {
	
	@Autowired
	private PostService postService;


	@GetMapping("/posts")
	public ResponseEntity<List<Post>> listadoPosts(){
		List<Post> lista= postService.listarPost();
		return new ResponseEntity< List<Post>>(lista, HttpStatus.OK);
	}


	@PostMapping("/post")
	public ResponseEntity<?> crearPost(@RequestBody Post post){
		LocalDate fechaActual =LocalDate.now();
		post.setCreado(fechaActual);
		return ResponseEntity.status(HttpStatus.CREATED).body(postService.crearUsuario(post));
	}

	@PutMapping("/post/{id}")
	public ResponseEntity<?> editarPost(@RequestBody Post usuario,@PathVariable Integer id){

		Optional<Post> userOp=postService.obtenerPorId(id);
		if(userOp.isPresent()){
			Post userBD= userOp.get();
			userBD.setText(usuario.getText());
			return  ResponseEntity.status(HttpStatus.CREATED).body(postService.crearUsuario(userBD));
		}
		return ResponseEntity.notFound().build();
	}


	@DeleteMapping("/post/{id}")
	public ResponseEntity<?> eliminarPost(@PathVariable Integer id){
		Optional<Post> userOp=postService.obtenerPorId(id);
		if(userOp.isPresent()){
			postService.eliminar(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	///////////////////////////
	@GetMapping("/postuser/{usuarioId}")
	public List<Post> listarPorIdUsers(@PathVariable Integer usuarioId){
		return postService.findByUserId(usuarioId);
	}



}
