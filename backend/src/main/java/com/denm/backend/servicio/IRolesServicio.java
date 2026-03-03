package com.denm.backend.servicio;

import java.util.List;

import com.denm.backend.modelo.entidad.Roles;

public interface IRolesServicio {
	
	public Roles insertarRoles(Roles roles);
	public Roles editarRoles(int idRol);
	public void eliminarRoles(int idRol);
	public List<Roles> listarRoles();

}
