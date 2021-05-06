import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { MediosPagoComponent } from './medios-pago/medios-pago.component';
import { MenuComponent } from './menu/menu.component';
import { RegistroComponent } from './registro/registro.component';
import { AuthGuard } from './guard/auth.guard';


const routes: Routes = [{path:"login",component:LoginComponent},
{path:"registro",component:RegistroComponent},
{path:"",redirectTo:"/login", pathMatch:"full"},
{path:"medioPago",component:MediosPagoComponent},
{path:"menu",component:MenuComponent,canActivate:[AuthGuard]  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
