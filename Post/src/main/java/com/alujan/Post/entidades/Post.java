package com.alujan.Post.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="post_id")
	private Integer Id;
	
	@Column(name="text")
	private String Text;

	@Column(name="usuario_id")
	private Integer usuarioId;

	@Transient
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate creado;

}
