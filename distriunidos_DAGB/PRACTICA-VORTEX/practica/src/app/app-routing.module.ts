import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { MenuComponent } from './menu/menu.component';
import { RegistroComponent } from './registro/registro.component';

const routes: Routes = [{path:"login",component:LoginComponent},
{path:"registro",component:RegistroComponent},
{path:"",redirectTo:"/login", pathMatch:"full"},
{path:"menu",component:MenuComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
