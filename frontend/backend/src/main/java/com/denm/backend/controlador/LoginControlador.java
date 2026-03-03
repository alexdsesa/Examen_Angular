package com.denm.backend.controlador;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.denm.backend.modelo.entidad.Usuario;
import com.denm.backend.servicio.IUsuarioServicio;

@RestController
@RequestMapping("/api/login")
public class LoginControlador {
	
	@Autowired
	private IUsuarioServicio servicio;
	
	@PostMapping
	public ResponseEntity<?> login(
			@RequestBody Map< String, String> credenciales){
		System.out.println("jason:"+credenciales);
		try {
			String usuario = credenciales.get("userUsuario");
			String contrasena = credenciales.get("passUsuario");
			if(usuario ==null && contrasena == null) {
				return ResponseEntity.badRequest()
						.body("Falta datos");
			}
			Usuario usuarioAutenticado = servicio.login(usuario, 
			                                           contrasena); 
			return ResponseEntity.ok(usuarioAutenticado);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
				   .body("Usuarios o contraseña incorrectos");
		}
	}

}
