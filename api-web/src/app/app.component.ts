import { Usuario } from './model/usuario';
import { UsuarioService } from './service/usuario.service';
import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';

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

  listar() {
    this.usuarioService.listar().subscribe(dados => this.lista = dados);
  }

  salvar(username: string) {
    this.usuarioService.salvar(username).subscribe(dados => {
      alert('usuário encontrado com sucesso!');
    }, (erro: HttpErrorResponse) => {
      alert('usuário não encontrado.');
    });
  }
}
