import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthGuard } from '../guard/auth.guard';
import { ConsultarClienteService } from '../service/consultar-cliente.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private consultarClienteService: ConsultarClienteService, private router: Router,private auth:AuthGuard) { }

  public email: string;
  public token: string;


  ngOnInit(): void {
    
    localStorage.removeItem("usuario");

  }

  public validarUsuario() {
    console.log(this.email);
    console.log(this.token);

    this.consultarClienteService.consultarClienteLogin(this.email, this.token).subscribe(
      data => {
        console.log(data);

        // console.log(Object.keys(data).length + " NUM");
        if (Object.keys(data).length >= 1) {

          
          localStorage.setItem("usuario",data[0].name);
          localStorage.setItem("pass",data[0].token);
          
          if(this.auth.canActivate){
            this.router.navigate(['menu']);
          }          
        }else{
          window.alert("No se encontraron datos validos");
        }

      }, err => {
        console.log('ERROR');
        console.log(err);
        this.router.navigate(['login']);
        window.alert(err.error);
      });
  }

}
