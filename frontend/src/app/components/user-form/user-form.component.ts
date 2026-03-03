import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { UserService } from '../../services/user.service';
import { Role } from '../../models/role.model';

@Component({
  selector: 'app-user-form',
  standalone: true,
  imports: [
    CommonModule,          // Para *ngIf, *ngFor
    ReactiveFormsModule,   // Para formGroup, formControlName
    RouterModule           // Para routerLink (si lo usas)
  ],
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {
  userForm: FormGroup;
  roles: Role[] = [];
  submitted = false;

  constructor(
    private fb: FormBuilder,
    private userService: UserService,
    private router: Router
  ) {
    this.userForm = this.fb.group({
      nombreUsuario: ['', Validators.required],
      apellidosUsuario: ['', Validators.required],
      emailUsuario: ['', [Validators.required, Validators.email]],
      userUsuario: ['', Validators.required],
      passUsuario: ['', [Validators.required, Validators.minLength(4)]],
      estado: ['ACTIVO'],
      idRol: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.loadRoles();
  }

  loadRoles(): void {
    this.userService.getRoles().subscribe({
      next: (data) => this.roles = data,
      error: (err) => console.error('Error al cargar roles', err)
    });
  }

  get f() { return this.userForm.controls; }

  onSubmit(): void {
    this.submitted = true;

    if (this.userForm.invalid) {
      return;
    }

    const roleId = this.userForm.value.idRol;
    const selectedRole = this.roles.find(r => r.idRol === Number(roleId));

    const newUser = {
      nombreUsuario: this.userForm.value.nombreUsuario,
      apellidosUsuario: this.userForm.value.apellidosUsuario,
      emailUsuario: this.userForm.value.emailUsuario,
      userUsuario: this.userForm.value.userUsuario,
      passUsuario: this.userForm.value.passUsuario,
      estado: this.userForm.value.estado,
      fkIdRol: selectedRole!
    };

    this.userService.createUser(newUser).subscribe({
      next: (user) => {
        console.log('Usuario creado', user);
        this.router.navigate(['/']);
      },
      error: (err) => {
        console.error('Error al crear usuario', err);
        alert('Error al crear usuario. Verifique los datos.');
      }
    });
  }

  onReset(): void {
    this.submitted = false;
    this.userForm.reset({ estado: 'ACTIVO' });
  }
}