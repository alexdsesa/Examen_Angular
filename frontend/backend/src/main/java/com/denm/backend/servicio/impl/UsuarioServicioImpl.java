package com.denm.backend.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.denm.backend.modelo.entidad.Usuario;
import com.denm.backend.repositorio.IUsuarioRepositorio;
import com.denm.backend.servicio.IUsuarioServicio;

@Service
@Component
public class UsuarioServicioImpl implements IUsuarioServicio{
	
	@Autowired
	private IUsuarioRepositorio repositorio;

	@Override
	public Usuario insertarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return repositorio.save(usuario);
	}

	@Override
	public Usuario editarUsUario(int idUsuario) {
		// TODO Auto-generated method stub
		return repositorio.findById(idUsuario).get();
	}

	@Override
	public void elimnarUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		repositorio.delete(editarUsUario(idUsuario));
	}

	@Override
	public List<Usuario> listarUsuario() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Usuario login(String userUsuario, String passUsuario) {
		// TODO Auto-generated method stub
		return repositorio.loginUsuario(userUsuario, passUsuario)
			   .orElseThrow(
			   ()-> new RuntimeException(
					   "Usuario o contraseña incorrectos"));
	}
}
