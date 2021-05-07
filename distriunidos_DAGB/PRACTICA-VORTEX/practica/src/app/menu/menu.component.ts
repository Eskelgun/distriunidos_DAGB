import { Component, OnInit } from '@angular/core';
import { ProductosService } from '../service/productos.service';
import { Producto } from '../domains/producto';


@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  public productos: Producto[];

  constructor(public productosService: ProductosService) { }



  ngOnInit(): void {
    this.consultarProductos();
  }


   public consultarProductos() {

     this.productosService.consultarProducto().subscribe(
       data=>{
          console.log(data);
          this.productos=data;

       },
       error=>{
         window.alert(error.error);

       }
     );
   }
}
