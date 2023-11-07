package com.alujan.Post.repository;

import com.alujan.Post.entidades.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post,Integer> {
    List<Post> findByusuarioId(Integer usuarioId);
}
