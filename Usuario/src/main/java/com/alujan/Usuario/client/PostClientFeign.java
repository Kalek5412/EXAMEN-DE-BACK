package com.alujan.Usuario.client;

import com.alujan.Usuario.entidades.modelos.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "ms-post",url = "localhost:9001")
public interface PostClientFeign {
    @GetMapping("/api/postuser/{usuarioId}")
    List<Post> listarPorIdUsers(@PathVariable Integer usuarioId);

}
