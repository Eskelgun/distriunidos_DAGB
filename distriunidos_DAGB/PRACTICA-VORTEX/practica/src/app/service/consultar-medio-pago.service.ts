import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';

@Injectable({ 
  providedIn: 'root'
})
export class ConsultarMedioPagoService {

  constructor(public httpClient:HttpClient) { }

  private url:string = 'http://localhost:9091/api/paymentM';

  public consultarMedioPago():Observable<any>{
    
    console.log(this.url+'/consultarMetodosPago');
    return this.httpClient.get(this.url+'/consultarMetodosPago/');
  }

}





