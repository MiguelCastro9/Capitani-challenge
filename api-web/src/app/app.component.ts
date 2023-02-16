import { HttpErrorResponse } from '@angular/common/http';
import { Usuario } from './model/usuario';
import { UsuarioService } from './service/usuario.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  lista!: Usuario[];
  username!: string;

  constructor(private usuarioService: UsuarioService) { }

  ngOnInit(): void {
    this.listar();
  }

  validarFormulario() {
    if (!this.username) {
      alert('campo não preenchido.');
    }
  return true;
  }

  listar() {
    this.usuarioService.listar().subscribe(dados => {
      this.lista = dados;
    });
  }

  getUsername(username: string) {
    if (!this.validarFormulario()) {
      return;
    }
    this.usuarioService.getUsername(username).subscribe(dados => {
      alert('usuário encontrado com sucesso!');
      this.listar();
    }, (erro: HttpErrorResponse) => {
      if (erro.status == 404) {
        alert('usuário não encontrado.');
      }

    });
  }
}
