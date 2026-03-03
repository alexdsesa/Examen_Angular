package com.denm.backend.servicio;

import java.util.List;

import com.denm.backend.modelo.entidad.Usuario;

public interface IUsuarioServicio {
	
	public Usuario insertarUsuario(Usuario usuario);
	public Usuario editarUsUario(int idUsuario);
	public void elimnarUsuario(int idUsuario);
	public List<Usuario> listarUsuario();
	public Usuario login(String userUsuario, 
			             String passUsuario);

}
