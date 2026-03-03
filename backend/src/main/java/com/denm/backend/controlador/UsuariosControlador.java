package com.denm.backend.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.denm.backend.modelo.entidad.Roles;
import com.denm.backend.modelo.entidad.Usuario;
import com.denm.backend.servicio.IRolesServicio;
import com.denm.backend.servicio.IUsuarioServicio;

@RestController
@RequestMapping("/api/usuario")
public class UsuariosControlador {
	
	@Autowired
	private IUsuarioServicio servicio;
	
	@Autowired
	private IRolesServicio servicioRoles;
	
	@GetMapping
	public List<Usuario> listarUsuario(){
		return servicio.listarUsuario();
	}
	
	@PostMapping
	public Usuario insertarUsuario(@RequestBody Usuario usuario) {
		if(usuario.getFkIdRol() !=null && 
	       usuario.getFkIdRol().getIdRol() > 0) {
			Roles rol = servicioRoles.editarRoles(
					      usuario.getFkIdRol().getIdRol());
			if(rol != null) {
				usuario.setFkIdRol(rol);
			}else {
				throw new RuntimeException(
						"El rol con Id:"+usuario.getFkIdRol().getIdRol()+
						" no existe");
			}
		}else {
			throw new RuntimeException("El rol es obligatorio");
		}
		return servicio.insertarUsuario(usuario);
	}
	
}
