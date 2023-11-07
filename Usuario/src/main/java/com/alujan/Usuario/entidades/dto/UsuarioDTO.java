package com.alujan.Usuario.entidades.dto;


import com.alujan.Usuario.entidades.modelos.Post;
import lombok.Data;

import java.util.List;

@Data
public class UsuarioDTO {

    private String Id;
    private String Cellphone;
    private String Name;
    private String LastName;
    private String Password;
    private List<Post> posts;
}
