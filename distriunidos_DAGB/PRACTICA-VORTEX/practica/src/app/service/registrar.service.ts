import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Usuario } from '../domains/usuario';

@Injectable({
  providedIn: 'root'
})
export class RegistrarService {

  constructor(public httpClient:HttpClient) { }

  private url:string = 'http://localhost:9091/api/customer';

  public guardarCliente(usuarios: Usuario):Observable<any>{
    // this.url+'/consultarClientes'
    console.log(this.url+'/guardarCliente');
    return this.httpClient.post(this.url+'/guardarCliente', usuarios);
  }

}




 