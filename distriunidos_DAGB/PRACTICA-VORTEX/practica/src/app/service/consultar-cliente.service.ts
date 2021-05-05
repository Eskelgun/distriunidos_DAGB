import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ConsultarClienteService {

  constructor(public httpClient:HttpClient) { }

  private url:string = 'http://localhost:9091/api/customer';

  public consultarClienteLogin(email:string,token:string):Observable<any>{
    
    console.log(this.url+'/consultarClientesByCorreoAndToken');
    return this.httpClient.get(this.url+'/consultarClientesByCorreoAndToken/'+email+"/"+token);
  }

}
