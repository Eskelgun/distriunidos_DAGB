package co.store.app.service;

import java.util.List;
import java.util.Optional;

import co.store.app.domain.Customer;

public interface CustomerService {

	/* CONSULTAR */

	/**
	 * Consulta todos los Clientes
	 * 
	 * @return List<Customer>
	 * @throws Exception
	 */
	public List<Customer> consultarClientes() throws Exception;

	/**
	 * Consulta los Clientes según un correo y token
	 * 
	 * @param email,token
	 * @return List<Customer>
	 * @throws Exception
	 */
	public List<Customer> consultarPorEmailAndToken(String email, String token) throws Exception;

	/**
	 * Consulta los Clientes según un estado
	 * 
	 * @param estado
	 * @return List<Customer>
	 * @throws Exception
	 */
	public List<Customer> consultarPorEstado(String estado) throws Exception;

	/* BUSCAR */

	/**
	 * Busca el cliente segun el correo
	 * 
	 * @param correo
	 * @return Optional<Customer>
	 * @throws Exception
	 */
	public Optional<Customer> buscarPorCorreo(String correo) throws Exception;

	/* GUARDAR */
	/**
	 * Guarda un Cliente
	 * 
	 * @param customer
	 * @throws Exception
	 */
	public void guardarClientes(Customer customer) throws Exception;

	/* ACTUALIZAR */
	/**
	 * Actualiza un Cliente
	 * 
	 * @param customer
	 * @throws Exception
	 */
	public void actualizarCliente(Customer customer) throws Exception;

	/* ELIMINAR */
	/**
	 * Elimina un Cliente
	 * 
	 * @param customer
	 * @throws Exception
	 */
	public void eliminarCliente(Customer customer) throws Exception;


}
