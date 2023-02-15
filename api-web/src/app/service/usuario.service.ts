import { environment } from './../../environments/environment.dev';
import { Usuario } from './../model/usuario';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  api_url = environment.api_url;

  constructor(private http: HttpClient) { }

  listar(){
    return this.http.get<Usuario[]>(this.api_url);
  }

  salvar(username: string){
    return this.http.post<Usuario>(this.api_url, username);
  }
}
