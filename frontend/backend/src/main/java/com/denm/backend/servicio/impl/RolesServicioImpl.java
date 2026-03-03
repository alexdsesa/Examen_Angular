package com.denm.backend.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.denm.backend.modelo.entidad.Roles;
import com.denm.backend.repositorio.IRolesRepositorio;
import com.denm.backend.servicio.IRolesServicio;

@Service
@Component
public class RolesServicioImpl implements IRolesServicio{
	
	@Autowired
	private IRolesRepositorio repositorio;

	@Override
	public Roles insertarRoles(Roles roles) {
		// TODO Auto-generated method stub
		return repositorio.save(roles);
	}

	@Override
	public Roles editarRoles(int idRol) {
		// TODO Auto-generated method stub
		return repositorio.findById(idRol).get();
	}

	@Override
	public void eliminarRoles(int idRol) {
		// TODO Auto-generated method stub
		repositorio.delete(editarRoles(idRol));
	}

	@Override
	public List<Roles> listarRoles() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

}
