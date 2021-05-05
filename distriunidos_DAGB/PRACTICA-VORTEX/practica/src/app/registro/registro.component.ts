import { Component, OnInit } from '@angular/core';
import { Usuario } from '../domains/usuario';
import { RegistrarService } from '../service/registrar.service';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {

  public usuarios: Usuario = new Usuario("","","","","","S");

  constructor(public registroClienteService: RegistrarService) {

  }

  ngOnInit(): void {
  }

  public ingresar(): void {
    console.log(this.usuarios.email);
    console.log(this.usuarios.name);
    console.log(this.usuarios.addres);
    console.log(this.usuarios.phone);
    console.log(this.usuarios.token);
    console.log(this.usuarios.enable);

    this.registroClienteService.guardarCliente(this.usuarios).subscribe(
      ok=>{
        console.log('******');
        console.log(ok);
        
      },
      err=>{
        console.log(err.error.error);
        
        
        }
    );


  }

}
