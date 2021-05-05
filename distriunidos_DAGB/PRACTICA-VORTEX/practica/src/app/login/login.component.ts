import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ConsultarClienteService } from '../service/consultar-cliente.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private consultarClienteService: ConsultarClienteService, private router: Router) { }

  public email: string;
  public token: string;


  ngOnInit(): void {

  }

  public validarUsuario() {
    console.log(this.email);
    console.log(this.token);

    this.consultarClienteService.consultarClienteLogin(this.email, this.token).subscribe(
      data => {
        console.log(data);

        // console.log(Object.keys(data).length + " NUM");
        if (Object.keys(data).length >= 1) {
          this.router.navigate(['menu']);
        }

      }, err => {
        console.log('ERROR');
        console.log(err);
        this.router.navigate(['login']);
      });
  }

}
