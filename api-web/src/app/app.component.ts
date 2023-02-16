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

  listar() {
    this.usuarioService.listar().subscribe(dados => {
      this.lista = dados;
    });
  }

  getUsername(username: string) {
    this.usuarioService.getUsername(username).subscribe(dados => {
      alert('usuário cadastrado com sucesso!');
      this.listar();
    });
  }
}
