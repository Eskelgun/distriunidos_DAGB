package co.store.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import co.store.app.domain.Customer;
import co.store.app.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	// Consulta todos los Clientes
	@Override
	public List<Customer> consultarClientes() throws Exception {

		// Creamos una lista cargada con todos los Clientes ordenados por el
		// nombre
		List<Customer> listClientes = customerRepository.findAll(Sort.by("name"));

		if (listClientes.isEmpty()) {
			throw new Exception("No hay Clientes existentes en el sistema.");
		}

		return listClientes;
	}

	// Consulta clientes por email y token
	@Override
	public List<Customer> consultarPorEmailAndToken(String email, String token) throws Exception {
		
//		Email
		if (email == null || email.trim().equals("")) {
			throw new Exception("No puede ser vacío el campo EMAIL.");
		}
		
//		Token
		if (token == null || token.trim().equals("")) {
			throw new Exception("No puede ser vacío el campo TOKEN.");
		}

		List<Customer> listClientes = customerRepository.findByEmailAndToken(email, token);


		return listClientes;
	}

//	Consulta todos los Clientes por estado
	@Override
	public List<Customer> consultarPorEstado(String estado) throws Exception {

		// Creamos una lista cargada con todos los Clientes ordenados por el
		// nombre
		List<Customer> listClientes = customerRepository.findByEnableOrderByName(estado);

		if (listClientes.isEmpty()) {
			throw new Exception("No hay Clientes existentes en el sistema con ese estado.");
		}

		return listClientes;
	}

//	Guarda un Cliente
	@Override
	public void guardarClientes(Customer customer) throws Exception {
		
		if(customer == null) {
			throw new Exception("No hay Clientes existentes en el sistema.");
		}
		
//		Addres
		if (customer.getAddres() == null || customer.getAddres().trim().equals("")) {
			throw new Exception("Error en el dato DIRECCIÓN.");
		}
		
//		Email
		if (customer.getEmail() == null || customer.getEmail().trim().equals("")) {
			throw new Exception("Error en el dato CORREO.");
		}
		
//		Estado
		if (customer.getEnable() == null || customer.getEnable().trim().equals("")) {
			throw new Exception("Error en el dato ESTADO.");
		}
		
//		Nombre
		if (customer.getName() == null || customer.getName().trim().equals("")) {
			throw new Exception("Error en el dato NOMBRE.");
		}
		
//		Telefono
		if (customer.getPhone() == null || customer.getPhone().trim().equals("")) {
			throw new Exception("Error en el dato TELEFONO.");
		}
		
//		Contraseña
		if (customer.getToken() == null || customer.getToken().trim().equals("")) {
			throw new Exception("Error en el dato CONTRASEÑA.");
		}
		
//		Guardamos el cliente
		customerRepository.save(customer);

	}

//	Actualiza un Cliente
	@Override
	public void actualizarCliente(Customer customer) throws Exception {

		if (customer == null) {
			throw new Exception("No hay Clientes existentes en el sistema.");
		}

//		Addres
		if (customer.getAddres() == null || customer.getAddres().trim().equals("")) {
			throw new Exception("Error en el dato DIRECCIÓN.");
		}

//		Email
		if (customer.getEmail() == null || customer.getEmail().trim().equals("")) {
			throw new Exception("Error en el dato CORREO.");
		}

//		Estado
		if (customer.getEnable() == null || customer.getEnable().trim().equals("")) {
			throw new Exception("Error en el dato ESTADO.");
		}

//		Nombre
		if (customer.getName() == null || customer.getName().trim().equals("")) {
			throw new Exception("Error en el dato NOMBRE.");
		}

//		Telefono
		if (customer.getPhone() == null || customer.getPhone().trim().equals("")) {
			throw new Exception("Error en el dato TELEFONO.");
		}

//		Contraseña
		if (customer.getToken() == null || customer.getToken().trim().equals("")) {
			throw new Exception("No hay Clientes existentes en el dato CONTRASEÑA.");
		}

//		Guardamos el cliente
		customerRepository.save(customer);

	}

	// Busca cliente por correo
	@Override
	public Optional<Customer> buscarPorCorreo(String correo) throws Exception {
		
		if (correo == null || correo.trim().equals("")) {
			throw new Exception("No hay Clientes existentes en el dato CORREO.");
		}

		Optional<Customer> customerOP = customerRepository.findById(correo);
		return customerOP;
	}

	@Override
	public void eliminarCliente(Customer customer) throws Exception {

		if (customer == null) {
			throw new Exception("No hay Cliente existente.");
		}

		customerRepository.delete(customer);

	}


	/*
	 * // Actualiza el estado de un cliente
	 * 
	 * @Override public void actualizarEstadoCliente(Customer customer) throws
	 * Exception {
	 * 
	 * }
	 */



}
