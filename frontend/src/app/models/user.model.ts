import { Role } from './role.model';

export interface User {
  idUsuario?: number;
  nombreUsuario: string;
  apellidosUsuario: string;
  emailUsuario: string;
  userUsuario: string;
  passUsuario: string;
  estado?: string;
  fkIdRol:  Role | null;
}