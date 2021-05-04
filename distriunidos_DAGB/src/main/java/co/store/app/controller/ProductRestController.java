package co.store.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.store.app.domain.Product;
import co.store.app.dto.ProductDTO;
import co.store.app.service.ProductService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/product")
public class ProductRestController {

	@Autowired
	private ProductService productService;

	/* CONSULTAR */

//	Consultar todos los Productos
	@GetMapping("/consultarProducto")
	public ResponseEntity<?> consultarProducto() {

		try {
			return ResponseEntity.ok(productService.consultarProductos());
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

//	Consultar todos los Productos por estado
	@GetMapping("/consultarProductoByEstado")
	public ResponseEntity<?> consultarProductoByEstado(@RequestParam("estado") String estado) {

		try {
			return ResponseEntity.ok(productService.consultarPorEstado(estado));
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

	/* GUARDAR */
	@PostMapping("/guardarProducto")
	public ResponseEntity<?> guardarProducto(@RequestBody ProductDTO productDTO) {

		try {

			Product product = new Product();

			product.setDetail(productDTO.getDetail());
			product.setEnable(productDTO.getEnable());
			product.setImage(productDTO.getImage());
			product.setName(productDTO.getName());
			product.setPrice(productDTO.getPrice());


			productService.guardarProductos(product);

			return ResponseEntity.ok().body(product);

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

	/* ACTUALIZAR */
	@PutMapping("/actualizarProducto")
	public ResponseEntity<?> actualizarProducto(@RequestBody ProductDTO productDTO) {

		Optional<Product> productOP = null;
		Product product = null;

		try {
			productOP = productService.buscarPorId(productDTO.getProId());

			product = productOP.get();

			product.setDetail(productDTO.getDetail());
			product.setEnable(productDTO.getEnable());
			product.setImage(productDTO.getImage());
			product.setName(productDTO.getName());
			product.setPrice(productDTO.getPrice());


			productService.actualizarProductos(product);
			;

			return ResponseEntity.ok().body(product);

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

	/* ELIMINAR */
	@DeleteMapping("/eliminarProducto/{id}")
	public ResponseEntity<?> eliminarProducto(@PathVariable("id") int id) {

		Optional<Product> productOP;

		try {
			productOP = productService.buscarPorId(id);
			productService.eliminarProducto(productOP.get());

			return ResponseEntity.ok().body(productOP.get());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

}
