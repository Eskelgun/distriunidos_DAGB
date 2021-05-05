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

import co.store.app.domain.Customer;
import co.store.app.dto.CustomerDTO;
import co.store.app.service.CustomerService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;

	/* CONSULTAR */

//	Consultar todos los clientes	
	@GetMapping("/consultarClientes")
	public ResponseEntity<?> consultarClientes() {

		try {
			return ResponseEntity.ok(customerService.consultarClientes());
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

//	Consultar todos cliente por correo y token
	@GetMapping("/consultarClientesByCorreoAndToken/{email}/{token}")
	public ResponseEntity<?> consultarClientesByCorreoAndToken(@PathVariable("email") String email,
			@PathVariable("token") String token) {

		try {
			return ResponseEntity.ok(customerService.consultarPorEmailAndToken(email, token));
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

//	Consultar todos los clientes por estado
	@GetMapping("/consultarClientesByEstado")
	public ResponseEntity<?> consultarClientesByEstado(@RequestParam("estado") String estado) {

		try {
			return ResponseEntity.ok(customerService.consultarPorEstado(estado));
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

	/* GUARDAR */
	@PostMapping("/guardarCliente")
	public ResponseEntity<?> guardarCliente(@RequestBody CustomerDTO customerDTO) {

		try {

			Customer customer = new Customer();

			customer.setAddres(customerDTO.getAddres());
			customer.setEmail(customerDTO.getEmail());
			customer.setEnable(customerDTO.getEnable());
			customer.setName(customerDTO.getName());
			customer.setPhone(customerDTO.getPhone());
			customer.setToken(customerDTO.getToken());


			customerService.guardarClientes(customer);
			System.out.println("¡Cliente guardado con exito!");
			return ResponseEntity.ok().body(customer);

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

	/* ACTUALIZAR */
	@PutMapping("/actualizarCustomer")
	public ResponseEntity<?> actualizarCustomer(@RequestBody CustomerDTO customerDTO) {

		Optional<Customer> customerOP = null;
		Customer customer = null;

		try {
			customerOP = customerService.buscarPorCorreo(customerDTO.getEmail());

			customer = customerOP.get();

			customer.setAddres(customerDTO.getAddres());
			customer.setEmail(customerDTO.getEmail());
			customer.setEnable(customerDTO.getEnable());
			customer.setName(customerDTO.getName());
			customer.setPhone(customerDTO.getPhone());
			customer.setToken(customerDTO.getToken());

			customerService.actualizarCliente(customer);

			return ResponseEntity.ok().body(customer);

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

	/* ELIMINAR */
	@DeleteMapping("/eliminarCliente/{correo}")
	public ResponseEntity<?> eliminarCliente(@PathVariable("correo") String correo) {

		Optional<Customer> clienteOP;

		try {
			clienteOP = customerService.buscarPorCorreo(correo);
			customerService.eliminarCliente(clienteOP.get());

			return ResponseEntity.ok().body(clienteOP.get());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

}// END CLASS
