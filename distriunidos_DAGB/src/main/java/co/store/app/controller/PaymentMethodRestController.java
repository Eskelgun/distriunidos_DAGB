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

import co.store.app.domain.PaymentMethod;
import co.store.app.dto.PaymentMethodDTO;
import co.store.app.service.PaymentMethodService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/paymentM")
public class PaymentMethodRestController {

	@Autowired
	private PaymentMethodService paymentMethodService;

	/* CONSULTAR */

//	Consultar todos los Metodos de Pago	
	@GetMapping("/consultarMetodosPago")
	public ResponseEntity<?> consultarMetodosPago() {

		try {
			return ResponseEntity.ok(paymentMethodService.consultarMetodosPago());
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

//	Consultar todos los Metodos de Pago	por estado
	@GetMapping("/consultarMetodosPagoByEstado")
	public ResponseEntity<?> consultarMetodosPagoByEstado(@RequestParam("estado") String estado) {

		try {
			return ResponseEntity.ok(paymentMethodService.consultarPorEstado(estado));
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

	/* GUARDAR */
	@PostMapping("/guardarMetodosPago")
	public ResponseEntity<?> guardarMetodosPago(@RequestBody PaymentMethodDTO paymentMethodDTO) {

		try {

			PaymentMethod paymentMethod = new PaymentMethod();

			paymentMethod.setName(paymentMethodDTO.getName());
			paymentMethod.setEnable(paymentMethodDTO.getEnable());

			paymentMethodService.guardarMetodoPago(paymentMethod);

			return ResponseEntity.ok().body(paymentMethod);

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

	/* ACTUALIZAR */
	@PutMapping("/actualizarMetodosPago")
	public ResponseEntity<?> actualizarMetodosPago(@RequestBody PaymentMethodDTO paymentMethodDTO) {

		Optional<PaymentMethod> paymentMethodOP = null;
		PaymentMethod paymentMethod = null;

		try {
			paymentMethodOP = paymentMethodService.buscarPorId(paymentMethodDTO.getPayId());

			paymentMethod = paymentMethodOP.get();

			paymentMethod.setName(paymentMethodDTO.getName());
			paymentMethod.setEnable(paymentMethodDTO.getEnable());

			paymentMethodService.actualizarMetodoPago(paymentMethod);

			return ResponseEntity.ok().body(paymentMethod);

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

	/* ELIMINAR */
	@DeleteMapping("/eliminarMetodosPago/{id}")
	public ResponseEntity<?> eliminarMetodosPago(@PathVariable("id") int id) {

		Optional<PaymentMethod> PaymentMethodOP;

		try {
			PaymentMethodOP = paymentMethodService.buscarPorId(id);
			paymentMethodService.eliminarMetodoPago(PaymentMethodOP.get());

			return ResponseEntity.ok().body(PaymentMethodOP.get());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

}
