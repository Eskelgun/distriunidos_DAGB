package co.store.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.store.app.domain.Product;
import co.store.app.domain.ShoppingCart;
import co.store.app.domain.ShoppingProduct;
import co.store.app.dto.ShoppingProductDTO;
import co.store.app.service.ProductService;
import co.store.app.service.ShoppingCartService;
import co.store.app.service.ShoppingProductService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/shoppingPro")
public class ShoppingProductRestController {

	@Autowired
	private ShoppingProductService shoppingProductService;

	@Autowired
	private ProductService productService;

	@Autowired
	private ShoppingCartService shoppingCartService;

	/* GUARDAR */
	@PostMapping("/guardarShoppingProduct")
	public ResponseEntity<?> guardarShoppingProduct(@RequestBody ShoppingProductDTO shoppingProductDTO) {

		Product product = null;
		ShoppingCart shoppingCart = null;
		try {

			ShoppingProduct shoppingProduct = new ShoppingProduct();

			product = productService.buscarPorId(shoppingProductDTO.getProId()).get();
			shoppingCart = shoppingCartService.buscarShoppingCartById(shoppingProductDTO.getCarId()).get();

			shoppingProduct.setShoppingCart(shoppingCart);
			shoppingProduct.setProduct(product);
			shoppingProduct.setQuantity(shoppingProductDTO.getQuantity());
			shoppingProduct.setTotal(shoppingProductDTO.getTotal());

			shoppingProductService.guardarShoppingProduct(shoppingProduct);

			return ResponseEntity.ok().body(shoppingProduct);

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

}
