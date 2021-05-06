package co.store.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.store.app.domain.Customer;
import co.store.app.domain.PaymentMethod;
import co.store.app.domain.ShoppingCart;
import co.store.app.dto.ShoppingCartDTO;
import co.store.app.service.CustomerService;
import co.store.app.service.PaymentMethodService;
import co.store.app.service.ShoppingCartService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/shoppingCar")
public class ShoppingCartRestController {

	@Autowired
	private ShoppingCartService shoppingCartService;

	@Autowired
	private PaymentMethodService paymentMethodService;

	@Autowired
	private CustomerService customerService;

	/* GUARDAR */
	@PostMapping("/guardarShoppingCar")
	public ResponseEntity<?> guardarShoppingCar(@RequestBody ShoppingCartDTO shoppingCartDTO) {

		Customer customer = null;
		PaymentMethod paymentMethod = null;

		try {

			ShoppingCart shoppingCart = new ShoppingCart();

			customer = customerService.buscarPorCorreo(shoppingCartDTO.getEmail()).get();
			paymentMethod = paymentMethodService.buscarPorId(shoppingCartDTO.getPayId()).get();

			shoppingCart.setCustomer(customer);
			shoppingCart.setEnable(shoppingCartDTO.getEnable());
			shoppingCart.setItems(shoppingCartDTO.getItems());
			shoppingCart.setPaymentMethod(paymentMethod);
			shoppingCart.setTotal(shoppingCartDTO.getTotal());

			shoppingCartService.guardarShoppingCart(shoppingCart);

			return ResponseEntity.ok().body(shoppingCart);

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

}
