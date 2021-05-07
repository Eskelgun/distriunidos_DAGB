import { Component, OnInit } from '@angular/core';
import { MediosPa } from '../domains/mediosPa';
import { ConsultarMedioPagoService } from '../service/consultar-medio-pago.service';

@Component({
  selector: 'app-medios-pago',
  templateUrl: './medios-pago.component.html',
  styleUrls: ['./medios-pago.component.css']
})
export class MediosPagoComponent implements OnInit {

  public medioPagos: MediosPa[];

  constructor(public medioPagosService: ConsultarMedioPagoService) { }

  ngOnInit(): void {
    this.consultarMedioPa();
  }

  public consultarMedioPa() {

    this.medioPagosService.consultarMedioPago().subscribe(
      data=>{
         console.log(data);
         this.medioPagos=data;

      },
      error=>{
        window.alert(error.error);

      }
    );
  }

}
