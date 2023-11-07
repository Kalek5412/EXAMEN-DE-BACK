package com.alujan.Usuario.controller;

import com.alujan.Usuario.entidades.Usuario;
import com.alujan.Usuario.entidades.dto.UsuarioDTO;
import com.alujan.Usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> listadoUsuarios(){
        List<Usuario> lista= usuarioService.listarUsuarios();
        return new ResponseEntity< List<Usuario>>(lista, HttpStatus.OK);
    }


    @PostMapping("/usuario")
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.crearUsuario(usuario));
    }
    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/usuario/{id}")
    public ResponseEntity<?> editarUsuario(@RequestBody Usuario usuario,@PathVariable Integer id){
        Optional<Usuario> userOp=usuarioService.obtenerPorId(id);
        if(userOp.isPresent()){
            Usuario userBD= userOp.get();
            userBD.setCellphone(usuario.getCellphone());
            userBD.setName(usuario.getName());
            userBD.setLastName(usuario.getLastName());
            userBD.setPassword(usuario.getPassword());
            return  ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.crearUsuario(userBD));
        }
        return ResponseEntity.notFound().build();
    }
    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<?> eliminarCliente(@PathVariable Integer id){
        Optional<Usuario> userOp=usuarioService.obtenerPorId(id);
        if(userOp.isPresent()){
            usuarioService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/postuser/{userId}")
    public UsuarioDTO listarpost(@PathVariable Integer userId){
        return  usuarioService.buscarPostId(userId);
    }

}
