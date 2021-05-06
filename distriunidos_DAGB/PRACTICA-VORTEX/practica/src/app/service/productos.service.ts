import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';

@Injectable({ 
  providedIn: 'root'
})
export class ProductosService {

  constructor(public httpClient:HttpClient) { }

  private url:string = 'http://localhost:9091/api/product';

  public consultarProducto():Observable<any>{
    
    console.log(this.url+'/consultarProducto');
    return this.httpClient.get(this.url+'/consultarProducto/');
  }

}



