package com.denm.backend.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.denm.backend.modelo.entidad.Roles;
import com.denm.backend.servicio.IRolesServicio;

@RestController
@RequestMapping("/api/roles")
public class RolesControlador {
	
	@Autowired
	private IRolesServicio servicio;
	
	@GetMapping
	public List<Roles> listarRol(){
		return servicio.listarRoles();
	}
	
	@PostMapping
	public Roles insertarRoles(@RequestBody Roles roles) {
		return servicio.insertarRoles(roles);
	}
	
	@GetMapping("/{id}")
	public Roles editarRoles(@PathVariable int id) {
		return servicio.editarRoles(id);
	}
	
	@DeleteMapping("/{id}")
	public void eliminarRoles(@PathVariable int id) {
		servicio.eliminarRoles(id);
	}

}