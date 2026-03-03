package com.denm.backend.modelo.entidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
public class Roles implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRol;
	private String nombreRol;
	private String estadoRol;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "fkIdRol", cascade = CascadeType.REFRESH)
	@JsonBackReference
	private List<Usuario> listaUsuarios = new ArrayList<>();
}
